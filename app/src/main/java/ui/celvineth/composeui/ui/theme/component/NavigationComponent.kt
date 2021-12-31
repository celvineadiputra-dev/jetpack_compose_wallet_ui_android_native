package ui.celvineth.composeui.ui.theme.component

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ui.celvineth.composeui.R
import ui.celvineth.composeui.ui.theme.ComposeUiTheme

@Composable
fun NavigationComponent(navName: String, context: Context, navController: NavController) {
    ComposeUiTheme {
        Row(
            modifier = Modifier
                .background(colorResource(id = R.color.white))
                .fillMaxWidth()
                .padding(vertical = 25.dp, horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = stringResource(
                    R.string.icon_back
                ),
                modifier = Modifier
                    .size(24.dp)
                    .clickable(
                        interactionSource = remember {
                            MutableInteractionSource()
                        },
                        indication = null
                    ) {
                        navController.popBackStack()
                    }
            )
            //text
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(navName, style = MaterialTheme.typography.h3)
            }
        }
    }
}

//@Composable
//@Preview
//fun PreviewNavigationComponent() {
//    NavigationComponent(stringResource(id = R.string.home), LocalContext.current)
//}