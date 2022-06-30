package net.zerotask.libraries.android.compose.forms.validators

import net.zerotask.libraries.android.compose.forms.UpdateType
import net.zerotask.libraries.android.compose.forms.Validator

class NonEmpty<out E>(
    override val updateType: UpdateType = UpdateType.FOCUS_CHANGE,
    private val error: E,
) : Validator<CharSequence, E> {
    override fun validate(value: CharSequence): Validator.Result<E> =
        if (value.isNotEmpty()) {
            Validator.Result.Success
        } else {
            Validator.Result.Error(error)
        }
}
