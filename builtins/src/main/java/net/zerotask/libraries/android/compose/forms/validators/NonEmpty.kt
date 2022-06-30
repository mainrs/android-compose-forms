package net.zerotask.libraries.android.compose.forms.validators

import net.zerotask.libraries.android.compose.forms.UpdateType
import net.zerotask.libraries.android.compose.forms.Validator

class NonEmpty<out E>(private val message: E) : Validator<CharSequence, E> {
    override val updateType: UpdateType
        get() = UpdateType.FOCUS_CHANGE

    override fun validate(value: CharSequence): Validator.Result<E> =
        if (value.isNotEmpty()) {
            Validator.Result.Success
        } else {
            Validator.Result.Error(message)
        }
}
