package ui.celvineth.composeui.ui

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ui.celvineth.composeui.R
import ui.celvineth.composeui.ui.theme.ComposeUiTheme
import ui.celvineth.composeui.ui.theme.component.ButtonComponent
import ui.celvineth.composeui.ui.theme.onSurface
import ui.celvineth.composeui.ui.theme.secondary

@Composable
fun BoardingScreen(navController: NavController) {
    ComposeUiTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.white)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            GraphicSection()
            TextSection()
            Spacer(modifier = Modifier.height(40.dp))
            ButtonComponent(label = stringResource(R.string.get_started), onClick = {
                navController.navigate("login_screen")
            })
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun GraphicSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp, vertical = 44.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.im_1),
            contentDescription = stringResource(R.string.graphic_image_boarding),
            modifier = Modifier
                .width(340.dp)
                .height(326.dp)
        )
    }
}

@Composable
fun TextSection() {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.im_wallet),
            contentDescription = stringResource(
                R.string.wallet_icon
            )
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = stringResource(R.string.wallet_ui),
            style = MaterialTheme.typography.h3,
            color = onSurface
        )
        Spacer(modifier = Modifier.height(14.dp))
        Text(
            text = stringResource(R.string.desc_boarding),
            style = MaterialTheme.typography.caption,
            textAlign = TextAlign.Center,
            color = secondary,
            modifier = Modifier
                .width(223.dp)
        )
    }
}