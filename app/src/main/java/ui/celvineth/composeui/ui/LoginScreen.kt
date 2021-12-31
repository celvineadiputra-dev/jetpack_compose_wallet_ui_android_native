package ui.celvineth.composeui.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ui.celvineth.composeui.R
import ui.celvineth.composeui.ui.theme.*
import ui.celvineth.composeui.ui.theme.component.NavigationComponent


class TextFieldState() {
    var text: String by mutableStateOf("")
}

@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current
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
            phoneSection(phoneState = phoneState)
            Spacer(modifier = Modifier.height(28.dp))
            passwordSection(passwordState = passwordState)
            Spacer(modifier = Modifier.height(8.dp))
            checkSection(navController)
            Spacer(modifier = Modifier.height(40.dp))
            buttonSection(navController, onClick = {
                if(phoneState.text.isNotEmpty() && passwordState.text.isNotEmpty()){
                    Toast.makeText(context, "${phoneState.text} and ${passwordState.text}", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(context, "Field required", Toast.LENGTH_SHORT).show()
                }
            })
            Spacer(modifier = Modifier.height(16.dp))
            signupSection(navController)
        }
    }
}

@Composable
fun phoneSection(
    phoneState: TextFieldState = remember {
        TextFieldState()
    }
) {
    Column(
        modifier = Modifier.padding(horizontal = 24.dp)
    ) {
        Text(
            text = stringResource(R.string.phone),
            style = MaterialTheme.typography.caption,
            color = secondary
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = phoneState.text,
            onValueChange = { phoneState.text = it },
            label = {
                Text(text = "Phone Number", style = MaterialTheme.typography.body1)
            },
            placeholder = {
                Text(text = "Phone Number", style = MaterialTheme.typography.body1)
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = primary,
                unfocusedBorderColor = borderNor,
                backgroundColor = primary
            ),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            maxLines = 1,
            singleLine = true,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun passwordSection(
    passwordState: TextFieldState = remember {
        TextFieldState()
    }
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
                Text(text = "Password", style = MaterialTheme.typography.body1)
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = primary,
                unfocusedBorderColor = borderNor,
                backgroundColor = primary
            ),
            placeholder = {
                Text(text = "At least 8 characters", style = MaterialTheme.typography.body1)
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
fun buttonSection(navController: NavController, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Text(
            text = stringResource(id = R.string.log_in),
            modifier = Modifier.padding(vertical = 15.dp),
            style = MaterialTheme.typography.body2
        )
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