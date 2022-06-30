package net.zerotask.libraries.android.compose.forms.validators

import net.zerotask.libraries.android.compose.forms.UpdateType
import net.zerotask.libraries.android.compose.forms.Validator

class CharacterLength<out E>(
    private val range: IntRange,
    private val message: E,
) : Validator<CharSequence, E> {
    override val updateType: UpdateType
        get() = UpdateType.FOCUS_CHANGE

    override fun validate(value: CharSequence): Validator.Result<E> {
        if (value.length in range) {
            return Validator.Result.Success
        }
        return Validator.Result.Error(message)
    }
}
