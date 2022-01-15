package ui.celvineth.composeui.ui.theme.component

import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import ui.celvineth.composeui.R
import ui.celvineth.composeui.ui.theme.dp70
import ui.celvineth.composeui.ui.theme.onSurface
import ui.celvineth.composeui.ui.theme.primary
import ui.celvineth.composeui.ui.theme.white


data class menuList(val title: String, val iconActive: Int, val iconUnActive: Int)

@Preview
@Composable
fun AppBottomBar() {
    var selectedState = remember {
        "home"
    }

    BottomAppBar(modifier = Modifier.height(dp70), backgroundColor = white) {
        val valueMenu: List<menuList> = listOf(
            menuList("home", R.drawable.ic_home, R.drawable.ic_home),
            menuList("chart", R.drawable.ic_chart, R.drawable.ic_chart),
            menuList("discount", R.drawable.ic_discount, R.drawable.ic_discount),
            menuList("profile", R.drawable.ic_profile, R.drawable.ic_profile)
        )
        for (item in valueMenu) {
            BottomNavigationItem(
                selected = selectedState == item.title,
                onClick = { selectedState = item.title },
                icon = {
                    if (selectedState == item.title) {
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