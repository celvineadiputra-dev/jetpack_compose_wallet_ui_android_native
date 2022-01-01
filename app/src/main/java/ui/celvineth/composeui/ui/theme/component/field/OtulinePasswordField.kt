package ui.celvineth.composeui.ui.theme.component.field

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ui.celvineth.composeui.R
import ui.celvineth.composeui.ui.theme.borderNor
import ui.celvineth.composeui.ui.theme.primary
import ui.celvineth.composeui.ui.theme.secondary

@Composable
fun OutlinePasswordField(
    passwordState: TextFieldState = remember {
        TextFieldState()
    }, label: String, placeholder: String
) {
    Column(
        modifier = Modifier.padding(horizontal = 24.dp)
    ) {
        var passwordVisibility by remember {
            mutableStateOf(false)
        }
        Text(
            text = stringResource(R.string.password),
            style = MaterialTheme.typography.caption,
            color = secondary
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = passwordState.text,
            onValueChange = { passwordState.text = it },
            label = {
                Text(text = label, style = MaterialTheme.typography.body1)
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = primary,
                unfocusedBorderColor = borderNor,
                backgroundColor = primary
            ),
            placeholder = {
                Text(text = placeholder, style = MaterialTheme.typography.body1)
            },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    if (passwordVisibility) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_show),
                            contentDescription = "Hide",
                            modifier = Modifier.size(20.dp)
                        )
                    } else {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_hide),
                            contentDescription = "Hide",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            },
            maxLines = 1,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun previewOutlinePasswordField() {
    OutlinePasswordField(passwordState = remember {
        TextFieldState()
    }, stringResource(id = R.string.password), stringResource(id = R.string.password))
}