package net.zerotask.libraries.android.compose.forms

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import net.zerotask.libraries.android.compose.forms.sample.R
import net.zerotask.libraries.android.compose.forms.transformers.IdentityTransformer
import net.zerotask.libraries.android.compose.forms.validators.CharacterLength
import net.zerotask.libraries.android.compose.forms.validators.NonEmpty

private val PasswordValidator = object : Validator<CharSequence, Int> {
    override val updateType: UpdateType
        get() = UpdateType.VALUE_CHANGE

    override fun validate(value: CharSequence): Validator.Result<Int> {
        return when (value.contains('?')) {
            true -> Validator.Result.Success
            false -> Validator.Result.Error(R.string.error_password)
        }
    }
}

class MainViewModel : ViewModel() {
    internal class Form(coroutineScope: CoroutineScope) {
        val username: FormField<String, Int, String> = FormField(
            initialValue = "",
            transformer = IdentityTransformer(),
            validators = listOf(
                NonEmpty(error = R.string.error_required),
                CharacterLength(error = R.string.error_username_length, range = 3..8)
            )
        )

        val password: FormField<String, Int, String> = FormField(
            initialValue = "",
            transformer = IdentityTransformer(),
            validators = listOf(NonEmpty(error = R.string.error_required), PasswordValidator)
        )

        val isValid: StateFlow<Boolean> =
            username.hasError.combine(password.hasError) { username, password ->
                !username && !password
            }.stateIn(coroutineScope, SharingStarted.Eagerly, false)
    }

    internal val form: Form = Form(viewModelScope)
}
