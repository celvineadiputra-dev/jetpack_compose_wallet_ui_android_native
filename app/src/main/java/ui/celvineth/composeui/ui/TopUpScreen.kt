package ui.celvineth.composeui.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import ui.celvineth.composeui.R
import ui.celvineth.composeui.ui.theme.*
import ui.celvineth.composeui.ui.theme.component.NavigationComponent

@Composable
fun TopUpScreen(navController: NavController) {
    ComposeUiTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            NavigationComponent(
                navName = stringResource(id = R.string.top_up),
                context = LocalContext.current,
                navController = navController
            )
        }
    }
}

@Composable
fun Denominations() {

}

@Preview
@Composable
fun CardDenomination() {
    OutlinedButton(
        onClick = { /*TODO*/ },
        border = BorderStroke(dp1, primary),
        shape = RoundedCornerShape(
            dp15
        ),
        modifier = Modifier
            .width(dp159p5)
            .height(dp60)
    ) {
        Text(
            text = "$50",
            style = MaterialTheme.typography.h4.copy(fontSize = sp18, color = onSurface)
        )
    }
}