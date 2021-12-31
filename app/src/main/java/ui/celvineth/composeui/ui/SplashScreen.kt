package ui.celvineth.composeui.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import ui.celvineth.composeui.R

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(key1 = true){
        delay(3000L)
        navController.popBackStack()
        navController.navigate("boarding_screen")
    }
    Box(
        contentAlignment = Alignment.Center, modifier = Modifier
            .fillMaxSize()
            .background(
                colorResource(id = R.color.primary)
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_money),
            contentDescription = stringResource(
                id = R.string.logo_app
            ),
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
        )
    }
}
