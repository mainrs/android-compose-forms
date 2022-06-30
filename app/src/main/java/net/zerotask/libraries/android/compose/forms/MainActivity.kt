package net.zerotask.libraries.android.compose.forms

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import net.zerotask.libraries.android.compose.forms.ui.FormFieldWithSupportedText

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = MainViewModel()
        setContent {
            val context = LocalContext.current

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column(
                    modifier = Modifier
                        .padding(32.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    val username by viewModel.form.username.value.collectAsState()
                    val hasUsernameError by viewModel.form.username.hasError.collectAsState()
                    val usernameError by viewModel.form.username.error.collectAsState()

                    val password by viewModel.form.password.value.collectAsState()
                    val hasPasswordError by viewModel.form.password.hasError.collectAsState()
                    val passwordError by viewModel.form.password.error.collectAsState()

                    FormFieldWithSupportedText(usernameError?.let { stringResource(it) }) {
                        OutlinedTextField(
                            modifier = Modifier.onFocusChanged {
                                if (it.isFocused) viewModel.form.username.setFocused(true)
                                else viewModel.form.username.setFocused(false)
                            },
                            value = username,
                            onValueChange = { viewModel.form.username.setValue(it) },
                            label = { Text("Username") },
                            isError = hasUsernameError,
                        )
                    }

                    FormFieldWithSupportedText(passwordError?.let { stringResource(it) }) {
                        OutlinedTextField(
                            modifier = Modifier.onFocusChanged {
                                if (it.isFocused) viewModel.form.password.setFocused(true)
                                else viewModel.form.password.setFocused(false)
                            },
                            value = password,
                            onValueChange = { viewModel.form.password.setValue(it) },
                            label = { Text("Password") },
                            isError = hasPasswordError,
                        )
                    }

                    val isValid by viewModel.form.isValid.collectAsState()
                    TextButton(onClick = {
                        Toast.makeText(context, "Submitted form!", Toast.LENGTH_LONG).show()
                    }, enabled = isValid) {
                        Text("Submit")
                    }
                }
            }
        }
    }
}
