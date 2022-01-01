package ui.celvineth.composeui.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ui.celvineth.composeui.R
import ui.celvineth.composeui.ui.theme.*
import ui.celvineth.composeui.ui.theme.component.ButtonComponent
import ui.celvineth.composeui.ui.theme.component.NavigationComponent
import ui.celvineth.composeui.ui.theme.component.field.OutlineField
import ui.celvineth.composeui.ui.theme.component.field.OutlinePasswordField
import ui.celvineth.composeui.ui.theme.component.field.TextFieldState

@Composable
fun RegisterScreen(navController: NavController) {
    var userNameState = remember {
        TextFieldState()
    }
    var phoneNumberState = remember {
        TextFieldState()
    }
    var passwordState = remember {
        TextFieldState()
    }
    var confirmPasswordState = remember {
        TextFieldState()
    }
    ComposeUiTheme {
        Column(
            modifier = Modifier
                .background(color = white)
        ) {
            NavigationComponent(
                navName = stringResource(id = R.string.register),
                context = LocalContext.current,
                navController = navController
            )
            Column(
                modifier = Modifier
                    .background(color = white)
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                OutlineField(
                    textState = userNameState,
                    label = stringResource(id = R.string.user_name),
                    placeholder = stringResource(id = R.string.user_name)
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlineField(
                    textState = phoneNumberState,
                    label = stringResource(id = R.string.phone),
                    placeholder = stringResource(id = R.string.phone_number)
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinePasswordField(
                    passwordState = passwordState,
                    label = stringResource(id = R.string.password),
                    placeholder = stringResource(
                        id = R.string.eight_characters
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinePasswordField(
                    passwordState = confirmPasswordState,
                    label = stringResource(id = R.string.confirm_password),
                    placeholder = stringResource(
                        id = R.string.eight_characters
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                checkSectionRegister()
                Spacer(modifier = Modifier.height(40.dp))
                ButtonComponent(label = stringResource(id = R.string.register), onClick = {

                })
                Spacer(modifier = Modifier.height(16.dp))
                signinSectionRegister(navController = navController)
            }
        }
    }
}

@Composable
fun checkSectionRegister() {
    var checkSelected by remember {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checkSelected,
                onCheckedChange = { checkSelected = it },
                colors = CheckboxDefaults.colors(uncheckedColor = primary, checkedColor = primary)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "${stringResource(id = R.string.text_register)} ${stringResource(id = R.string.tearms_register)}",
                style = MaterialTheme.typography.caption,
                color = onSurface
            )
        }
    }
}

@Composable
fun signinSectionRegister(navController: NavController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.have_account),
            style = MaterialTheme.typography.body2
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = stringResource(id = R.string.login),
            style = MaterialTheme.typography.body2,
            color = primary,
            modifier = Modifier.clickable(
                interactionSource = remember {
                    MutableInteractionSource()
                },
                indication = null
            ) {
                navController.popBackStack()
            }
        )
    }
}