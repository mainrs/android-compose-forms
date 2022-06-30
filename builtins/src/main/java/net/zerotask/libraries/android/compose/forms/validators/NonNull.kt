package net.zerotask.libraries.android.compose.forms.validators

import net.zerotask.libraries.android.compose.forms.UpdateType
import net.zerotask.libraries.android.compose.forms.Validator

class NonNull<T, out E>(
    override val updateType: UpdateType = UpdateType.FOCUS_CHANGE,
    private val error: E,
) : Validator<T, E> {
    override fun validate(value: T): Validator.Result<E> {
        return when (value) {
            null -> Validator.Result.Error(error)
            else -> Validator.Result.Success
        }
    }
}
