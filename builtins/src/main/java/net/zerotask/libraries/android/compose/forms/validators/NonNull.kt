package net.zerotask.libraries.android.compose.forms.validators

import net.zerotask.libraries.android.compose.forms.UpdateType
import net.zerotask.libraries.android.compose.forms.Validator

class NonNull<T, out E>(private val message: E) : Validator<T, E> {
    override val updateType: UpdateType
        get() = UpdateType.FOCUS_CHANGE

    override fun validate(value: T): Validator.Result<E> {
        return when (value) {
            null -> Validator.Result.Error(message)
            else -> Validator.Result.Success
        }
    }
}
