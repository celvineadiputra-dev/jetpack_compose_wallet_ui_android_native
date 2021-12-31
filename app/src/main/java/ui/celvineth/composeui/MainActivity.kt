package ui.celvineth.composeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ui.celvineth.composeui.ui.*
import ui.celvineth.composeui.ui.theme.ComposeUiTheme

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
    NavHost(navController = navController, startDestination = "splash_screen"){
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
    }
}