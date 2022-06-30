package net.zerotask.libraries.android.compose.forms.transformers

import net.zerotask.libraries.android.compose.forms.Transformer

class IdentityTransformer<T>: Transformer<T, T> {
    override fun transform(value: T): T = value
}
