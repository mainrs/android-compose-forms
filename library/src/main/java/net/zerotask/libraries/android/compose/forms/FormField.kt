package net.zerotask.libraries.android.compose.forms

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FormField<T, out E, out R>(
    initialValue: T,
    private val transformer: Transformer<T, R>,
    private val validators: List<Validator<T, E>> = emptyList(),
) {
    private val _value: MutableStateFlow<T> = MutableStateFlow(initialValue)
    val value: StateFlow<T> = _value.asStateFlow()

    private val _hasError: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val hasError: StateFlow<Boolean> = _hasError.asStateFlow()

    private val _error: MutableStateFlow<E?> = MutableStateFlow(null)
    val error: StateFlow<E?> = _error.asStateFlow()

    fun evaluate(): R = transformer.transform(value.value)

    fun focusChanged() {
        validate(updateType = UpdateType.FOCUS_CHANGE)
    }

    fun setValue(value: T) {
        _value.value = value
        validate(updateType = UpdateType.VALUE_CHANGE)
    }

    fun validateSubmit() {
        validate(updateType = UpdateType.FORM_SUBMIT)
    }

    private fun validate(updateType: UpdateType) {
        val filteredValidators = validators.filter { it.updateType == updateType }

        // Only the first error sets the error message itself.
        for (validator in filteredValidators) {
            val result = validator.validate(value.value)
            if (result is Validator.Result.Error) {
                _error.value = result.message
                _hasError.value = true

                return
            }
        }

        // If no errors have been found, reset the error status.
        _error.value = null
        _hasError.value = false
    }
}
