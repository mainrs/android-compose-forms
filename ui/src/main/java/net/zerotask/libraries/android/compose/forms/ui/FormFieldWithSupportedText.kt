package net.zerotask.libraries.android.compose.forms.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp

@Composable
fun FormFieldWithSupportedText(
    hint: String? = null,
    content: @Composable () -> Unit,
) {
    Column {
        content()
        Text(
            text = hint ?: "",
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .padding(start = 16.dp, top = 4.dp)
                .alpha(if (hint != null) 1f else 0f)
        )
    }
}
