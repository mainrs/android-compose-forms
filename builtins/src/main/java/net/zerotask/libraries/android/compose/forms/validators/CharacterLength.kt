package net.zerotask.libraries.android.compose.forms.validators

import net.zerotask.libraries.android.compose.forms.UpdateType
import net.zerotask.libraries.android.compose.forms.Validator

class CharacterLength<out E>(
    override val updateType: UpdateType = UpdateType.FOCUS_CHANGE,
    private val range: IntRange,
    private val error: E,
) : Validator<CharSequence, E> {
    override fun validate(value: CharSequence): Validator.Result<E> {
        if (value.length in range) {
            return Validator.Result.Success
        }
        return Validator.Result.Error(error)
    }
}
