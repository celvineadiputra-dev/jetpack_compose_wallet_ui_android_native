package ui.celvineth.composeui.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
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
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current

    var phoneIsError by remember {
        mutableStateOf(false)
    }
    var phoneErrorMessage by remember {
        mutableStateOf("")
    }

    var phoneState = remember {
        TextFieldState()
    }
    var passwordState = remember {
        TextFieldState()
    }
    ComposeUiTheme {
        Column(modifier = Modifier.background(color = white)) {
            NavigationComponent(
                navName = stringResource(id = R.string.login),
                context = LocalContext.current,
                navController = navController
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlineField(
                textState = phoneState,
                label = stringResource(id = R.string.phone),
                placeholder = stringResource(
                    id = R.string.phone_number
                ),
                isError = phoneIsError,
                errorMessage = phoneErrorMessage
            )
            Spacer(modifier = Modifier.height(28.dp))
            OutlinePasswordField(
                passwordState = passwordState,
                label = stringResource(id = R.string.password),
                placeholder = stringResource(
                    id = R.string.eight_characters
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            checkSection(navController)
            Spacer(modifier = Modifier.height(40.dp))
            ButtonComponent(label = stringResource(id = R.string.log_in), onClick = {
                phoneIsError = false
                phoneErrorMessage = ""
                if (phoneState.text.isNotEmpty() && passwordState.text.isNotEmpty()) {
                    Toast.makeText(
                        context,
                        "${phoneState.text} and ${passwordState.text}",
                        Toast.LENGTH_SHORT
                    ).show()
                    navController.navigate("home_screen")
                } else if (phoneState.text.isEmpty()){
                    phoneIsError = true
                    phoneErrorMessage = "Field is required !"
                }
            })
            Spacer(modifier = Modifier.height(16.dp))
            signupSection(navController)
        }
    }
}

@Composable
fun checkSection(navController: NavController) {
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
            TextButton(onClick = {
                checkSelected = !checkSelected
            }, modifier = Modifier.clickable(
                interactionSource = remember {
                    MutableInteractionSource()
                },
                indication = rememberRipple(bounded = false),
                onClick = {}
            )) {
                Text(
                    text = stringResource(id = R.string.save_password),
                    style = MaterialTheme.typography.caption,
                    color = onSurface
                )
            }
        }
        TextButton(onClick = { /*TODO*/ }) {
            Text(
                text = stringResource(id = R.string.forgot_password),
                style = MaterialTheme.typography.caption,
                color = primary
            )
        }
    }
}

@Composable
fun signupSection(navController: NavController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.dont_have_account),
            style = MaterialTheme.typography.body2
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = stringResource(id = R.string.sign_up),
            style = MaterialTheme.typography.body2,
            color = primary,
            modifier = Modifier.clickable(
                interactionSource = remember {
                    MutableInteractionSource()
                },
                indication = null
            ) {
                navController.navigate("register_screen")
            }
        )
    }
}