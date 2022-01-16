package ui.celvineth.composeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ui.celvineth.composeui.ui.*
import ui.celvineth.composeui.ui.theme.ComposeUiTheme
import ui.celvineth.composeui.ui.theme.component.AppBottomBar

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeUiTheme {
                Navigation()
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun Navigation() {
    val navController = rememberNavController()
    val bottomBarState = rememberSaveable {
        (mutableStateOf(false))
    }

    Scaffold(bottomBar = {
        AppBottomBar(navController = navController, bottomBarState = bottomBarState)
    }) {
        NavHost(navController = navController, startDestination = "splash_screen") {
            composable("splash_screen") {
                bottomBarState.value = false
                SplashScreen(navController = navController)
            }
            composable("boarding_screen") {
                bottomBarState.value = false
                BoardingScreen(navController = navController)
            }
            composable("login_screen") {
                bottomBarState.value = false
                LoginScreen(navController = navController)
            }
            composable("register_screen") {
                bottomBarState.value = false
                RegisterScreen(navController = navController)
            }
            composable("home_screen") {
                bottomBarState.value = true
                HomeScreen()
            }
            composable("chart_screen") {
                bottomBarState.value = true
                ChartScreen(navController = navController)
            }
            composable("discount_screen") {
                bottomBarState.value = true
                VoucherScreen(navController = navController)
            }
        }
    }
}