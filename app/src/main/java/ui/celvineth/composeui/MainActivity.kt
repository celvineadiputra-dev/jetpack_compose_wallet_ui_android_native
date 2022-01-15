package ui.celvineth.composeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ui.celvineth.composeui.ui.*
import ui.celvineth.composeui.ui.theme.ComposeUiTheme
import ui.celvineth.composeui.ui.theme.component.AppBottomBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeUiTheme {
                Navigation()
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home_screen"){
        composable("splash_screen"){
            SplashScreen(navController = navController)
        }
        composable("boarding_screen"){
            BoardingScreen(navController = navController)
        }
        composable("login_screen"){
            LoginScreen(navController = navController)
        }
        composable("register_screen"){
            RegisterScreen(navController = navController)
        }
        composable("home_screen"){
            HomeScreen()
        }
        composable("chart_screen"){
            ChartScreen(navController = navController)
        }
    }
    Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.Bottom) {
        AppBottomBar(navController = navController
        )
    }
}