package ui.celvineth.composeui.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import ui.celvineth.composeui.R
import ui.celvineth.composeui.ui.theme.*
import ui.celvineth.composeui.ui.theme.component.NavigationComponent
import ui.celvineth.composeui.ui.theme.component.Separator


@Composable
fun ProfileScreen(navController: NavController) {
    ComposeUiTheme {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(color = bgSeparator)) {
            NavigationComponent(
                navName = stringResource(id = R.string.profile),
                context = LocalContext.current,
                navController = navController
            )
            Separator()
            Profile("Celvine Adi Putra", "+6812-8751-2959", R.drawable.im_profile_dummy)
            Separator()
            Point()
            Separator()
            System()
            Spacer(modifier = Modifier.height(dp40))
            Logout()
            Spacer(modifier = Modifier.height(dp70))
        }
    }
}

@Composable
fun Profile(name: String, phoneNumber: String, image: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = white)
            .padding(vertical = dp12, horizontal = dp32),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = name
        )
        Spacer(modifier = Modifier.width(dp16))
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.h4.copy(color = onSurface, fontSize = sp18)
            )
            Spacer(modifier = Modifier.height(dp5))
            Text(
                text = phoneNumber,
                style = MaterialTheme.typography.caption.copy(color = secondary, fontSize = sp16)
            )
        }
    }
}

@Composable
fun Point() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = white)
            .padding(horizontal = dp32, vertical = dp16)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = stringResource(id = R.string.point),
                style = MaterialTheme.typography.body1.copy(color = onSurface, fontSize = sp16)
            )
            Text(
                text = "4000",
                style = MaterialTheme.typography.body1.copy(color = success, fontSize = sp16)
            )
        }
        Spacer(modifier = Modifier.height(dp15))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = stringResource(id = R.string.balance_in_wallet),
                style = MaterialTheme.typography.body1.copy(color = onSurface, fontSize = sp16)
            )
            Text(
                text = "$12.123.001",
                style = MaterialTheme.typography.body1.copy(color = onSurface, fontSize = sp16)
            )
        }
    }
}

@Composable
fun System() {
    data class Systems(val icon: Int, val text: String)

    val listSystems = listOf(
        Systems(icon = R.drawable.ic_wallet_mono, text = stringResource(id = R.string.card_bank)),
        Systems(
            icon = R.drawable.ic_discount,
            text = stringResource(id = R.string.affilate_service)
        ),
        Systems(icon = R.drawable.ic_multi_user, text = stringResource(id = R.string.group_friend)),
        Systems(icon = R.drawable.ic_unlock, text = stringResource(id = R.string.payment_security)),
        Systems(icon = R.drawable.ic_setting, text = stringResource(id = R.string.setting))
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = white)
            .padding(horizontal = dp32, vertical = dp16)
    ) {
        items(listSystems) { item ->
            SystemSection(icon = item.icon, text = item.text)
        }
    }
}

@Composable
fun SystemSection(icon: Int, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = dp12),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = text
            )
            Spacer(modifier = Modifier.width(dp15))
            Text(
                text = text,
                style = MaterialTheme.typography.body1.copy(color = onSurface, fontSize = sp16)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = "arrow"
        )
    }
}

@Composable
fun Logout() {
    Button(
        onClick = { /*TODO*/ }, modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dp32)
    ) {
        Text(
            text = stringResource(id = R.string.log_out),
            style = MaterialTheme.typography.button,
            modifier = Modifier.padding(vertical = dp15)
        )
    }
}