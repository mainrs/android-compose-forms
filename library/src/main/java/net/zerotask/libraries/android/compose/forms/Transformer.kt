package net.zerotask.libraries.android.compose.forms

fun interface Transformer<in T, out R> {
    fun transform(value: T): R
}
