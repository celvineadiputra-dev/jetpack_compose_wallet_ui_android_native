package ui.celvineth.composeui.ui.theme.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import ui.celvineth.composeui.R
import ui.celvineth.composeui.ui.theme.dp70
import ui.celvineth.composeui.ui.theme.onSurface
import ui.celvineth.composeui.ui.theme.primary
import ui.celvineth.composeui.ui.theme.white


data class MenuList(
    val title: String,
    val screen: String,
    val iconActive: Int,
    val iconUnActive: Int
)

@ExperimentalAnimationApi
@Composable
fun AppBottomBar(navController: NavController, bottomBarState: MutableState<Boolean>) {
    var selectedState = remember { mutableStateOf("home") }

    AnimatedVisibility(visible = bottomBarState.value) {
        BottomAppBar(modifier = Modifier.height(dp70), backgroundColor = white) {
            val valueMenu: List<MenuList> = listOf(
                MenuList("home", "home_screen", R.drawable.ic_home_active, R.drawable.ic_home),
                MenuList("chart", "chart_screen", R.drawable.ic_chart_active, R.drawable.ic_chart),
                MenuList(
                    "discount",
                    "discount_screen",
                    R.drawable.ic_discount_active,
                    R.drawable.ic_discount
                ),
                MenuList(
                    "profile",
                    "profile_screen",
                    R.drawable.ic_profile_active,
                    R.drawable.ic_profile
                )
            )
            for (item in valueMenu) {
                BottomNavigationItem(
                    selected = selectedState.value == item.title,
                    onClick = {
                        selectedState.value = item.title
                        navController.popBackStack()
                        navController.navigate(item.screen)
                    },
                    icon = {
                        if (selectedState.value == item.title) {
                            Icon(
                                painter = painterResource(id = item.iconActive),
                                contentDescription = item.title
                            )
                        } else {
                            Icon(
                                painter = painterResource(id = item.iconUnActive),
                                contentDescription = item.title
                            )
                        }
                    },
                    selectedContentColor = primary,
                    unselectedContentColor = onSurface
                )
            }
        }
    }
}