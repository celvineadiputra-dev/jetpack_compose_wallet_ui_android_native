package ui.celvineth.composeui.ui.theme.component.field

import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ui.celvineth.composeui.R
import ui.celvineth.composeui.ui.theme.*

@Composable
fun OutlineField(
    textState: TextFieldState = remember {
        TextFieldState()
    }, label: String, placeholder: String, isError: Boolean = false, errorMessage: String = ""
) {
    Column(modifier = Modifier.padding(horizontal = 24.dp)) {
        Text(text = label, style = MaterialTheme.typography.caption, color = secondary)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = textState.text,
            onValueChange = {
                textState.text = it
            },
            label = {
                Text(text = label, style = MaterialTheme.typography.body1)
            },
            placeholder = {
                Text(text = placeholder, style = MaterialTheme.typography.body1)
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = primary,
                unfocusedBorderColor = borderNor,
                backgroundColor = primary,
                errorLabelColor = critical,
                errorBorderColor = critical
            ),
            isError = isError,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            maxLines = 1,
            singleLine = true,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
        )
        if (isError){
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = errorMessage, style = MaterialTheme.typography.caption, color = critical)
        }
    }
}


@Preview
@Composable
fun previewOutlineField() {
    var phoneState = remember {
        TextFieldState()
    }
    OutlineField(
        phoneState,
        stringResource(id = R.string.phone),
        stringResource(id = R.string.phone_number),
        isError = true,
        "HELP ERROR"
    )
}