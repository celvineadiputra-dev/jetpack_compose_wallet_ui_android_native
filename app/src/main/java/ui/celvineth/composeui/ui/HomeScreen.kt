package ui.celvineth.composeui.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ui.celvineth.composeui.R
import ui.celvineth.composeui.ui.section.Payment
import ui.celvineth.composeui.ui.section.Stories
import ui.celvineth.composeui.ui.section.TradingHistory
import ui.celvineth.composeui.ui.theme.*
import ui.celvineth.composeui.ui.theme.component.AppBottomBar
import ui.celvineth.composeui.ui.theme.component.Separator


@Composable
fun HomeScreen(navController : NavController) {
    val scrollState = rememberScrollState()
    ComposeUiTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = white)
                .verticalScroll(scrollState)
        ) {
            HeaderSection()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = -dp40)
                    .padding(horizontal = dp16),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                ToolBar()
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = dp16, bottom = dp12)
            ) {
                Text(
                    text = stringResource(id = R.string.sendAgain),
                    style = MaterialTheme.typography.h4
                )
                Spacer(modifier = Modifier.height(dp12))
                Stories()
            }
            Separator()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dp16, vertical = dp12)
            ) {
                Text(
                    text = stringResource(id = R.string.payment_list),
                    style = MaterialTheme.typography.h4
                )
                Spacer(modifier = Modifier.height(dp12))
                Payment()
            }
            Separator()
            TradingHistory()
            Spacer(modifier = Modifier.height(dp70))
        }
    }
}

@Composable
fun HeaderSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(dp170)
            .clip(
                RoundedCornerShape(bottomStart = dp40, bottomEnd = dp40)
            )
            .background(color = primary)
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_ornament),
            contentDescription = "Ornament",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(0.dp)
                .clip(shape = RoundedCornerShape(topEnd = 100.dp))
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            Text(text = "Balance", style = MaterialTheme.typography.h4, color = white)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Rp. 341.000.001",
                style = MaterialTheme.typography.h3,
                color = primarySub
            )
        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(horizontal = dp25, vertical = dp25),
            horizontalAlignment = Alignment.End
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_notification),
                contentDescription = "Notification"
            )
        }
    }
}

@Composable
fun ToolBar() {
    Box(
        modifier = Modifier
            .width(343.dp)
            .height(74.dp)
            .clip(RoundedCornerShape(dp15))
            .background(color = white)
            .padding(horizontal = dp21, vertical = dp12)
    ) {
        Row {
            SubMenuToolBar(text = stringResource(id = R.string.topUp), icon = R.drawable.ic_topup)
            Spacer(modifier = Modifier.width(dp35))
            SubMenuToolBar(text = stringResource(id = R.string.wallet), icon = R.drawable.ic_wallet)
            Spacer(modifier = Modifier.width(dp35))
            SubMenuToolBar(
                text = stringResource(id = R.string.qr_scan),
                icon = R.drawable.ic_qr_scan
            )
            Spacer(modifier = Modifier.width(dp35))
            SubMenuToolBar(text = stringResource(id = R.string.my_qr), icon = R.drawable.ic_my_qr)
        }
    }
}

@Composable
fun SubMenuToolBar(text: String, icon: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = "Top UP"
        )
        Spacer(modifier = Modifier.height(dp2))
        Text(
            text = text,
            style = MaterialTheme.typography.caption.copy(fontWeight = FontWeight.Medium)
        )
    }
}

