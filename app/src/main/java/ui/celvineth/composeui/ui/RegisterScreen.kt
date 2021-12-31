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
import ui.celvineth.composeui.ui.theme.component.NavigationComponent

@Composable
fun RegisterScreen(navController: NavController) {
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
                userNameSectionRegister()
                Spacer(modifier = Modifier.height(10.dp))
                phoneSectionRegister()
                Spacer(modifier = Modifier.height(10.dp))
                passwordSectionRegister()
                Spacer(modifier = Modifier.height(10.dp))
                confirmPasswordSectionRegister()
                Spacer(modifier = Modifier.height(8.dp))
                checkSectionRegister()
                Spacer(modifier = Modifier.height(40.dp))
                buttonSectionRegister()
                Spacer(modifier = Modifier.height(16.dp))
                signinSectionRegister(navController = navController)
            }
        }
    }
}

@Composable
fun userNameSectionRegister() {
    Column(
        modifier = Modifier.padding(horizontal = 24.dp)
    ) {
        var textState by remember {
            mutableStateOf("")
        }
        Text(
            text = stringResource(R.string.user_name),
            style = MaterialTheme.typography.caption,
            color = secondary
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = textState,
            onValueChange = { textState = it },
            label = {
                Text(
                    text = stringResource(id = R.string.user_name),
                    style = MaterialTheme.typography.body1
                )
            },
            placeholder = {
                Text(
                    text = stringResource(id = R.string.user_name),
                    style = MaterialTheme.typography.body1
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = primary,
                unfocusedBorderColor = borderNor,
                backgroundColor = primary
            ),
            maxLines = 1,
            singleLine = true,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun phoneSectionRegister() {
    Column(
        modifier = Modifier.padding(horizontal = 24.dp)
    ) {
        var textState by remember {
            mutableStateOf("")
        }
        Text(
            text = stringResource(R.string.phone),
            style = MaterialTheme.typography.caption,
            color = secondary
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = textState,
            onValueChange = { textState = it },
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
fun passwordSectionRegister() {
    Column(
        modifier = Modifier.padding(horizontal = 24.dp)
    ) {
        var textState by remember {
            mutableStateOf("")
        }
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
            value = textState,
            onValueChange = { textState = it },
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
fun confirmPasswordSectionRegister() {
    Column(
        modifier = Modifier.padding(horizontal = 24.dp)
    ) {
        var textState by remember {
            mutableStateOf("")
        }
        var passwordVisibility by remember {
            mutableStateOf(false)
        }
        Text(
            text = stringResource(R.string.confirm_password),
            style = MaterialTheme.typography.caption,
            color = secondary
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = textState,
            onValueChange = { textState = it },
            label = {
                Text(
                    text = stringResource(id = R.string.confirm_password),
                    style = MaterialTheme.typography.body1
                )
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
fun buttonSectionRegister() {
    Button(
        onClick = { /*TODO*/ }, modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Text(
            text = stringResource(id = R.string.register),
            modifier = Modifier.padding(vertical = 15.dp),
            style = MaterialTheme.typography.body2
        )
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