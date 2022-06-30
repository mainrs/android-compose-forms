package net.zerotask.libraries.android.compose.forms

interface Validator<in T, out E> {
    val updateType: UpdateType

    fun validate(value: T): Result<E>

    sealed class Result<out E> {
        class Error<out E>(val message: E) : Result<E>()
        object Success : Result<Nothing>()

        fun isValid(): Boolean = this is Success
    }
}
