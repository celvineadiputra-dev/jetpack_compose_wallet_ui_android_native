package ui.celvineth.composeui.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import ui.celvineth.composeui.R
import ui.celvineth.composeui.ui.section.TradingHistory
import ui.celvineth.composeui.ui.theme.*
import ui.celvineth.composeui.ui.theme.component.NavigationComponent
import ui.celvineth.composeui.ui.theme.component.Separator

//@Preview
@Composable
fun ChartScreen(navController: NavController) {
    var scrollState = rememberScrollState()
    ComposeUiTheme {
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)) {
            NavigationComponent(
                navName = stringResource(id = R.string.analyse),
                context = LocalContext.current,
                navController = navController
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(bottom = dp16)
                    .padding(horizontal = dp16)
            ) {
                income()
                Spacer(modifier = Modifier.width(dp10))
                outcome()
            }
            Separator()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dp16),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                timeLine("The last 7 days")
                timeLine("30 days")
                timeLine("custom", true)
            }
            chart()
            Separator()
            TradingHistory()
            Spacer(modifier = Modifier.height(dp70))
        }
    }
}

@Composable
fun income() {
    Card(
        shape = RoundedCornerShape(dp15),
        modifier = Modifier
            .height(dp76)
            .width(dp163)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                .background(color = white)
                .padding(start = dp12, top = dp12, bottom = dp12)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_arrow_up),
                contentDescription = "income",
                modifier = Modifier
                    .clip(RoundedCornerShape(dp10))
                    .background(color = success.copy(alpha = 0.2f))
                    .padding(vertical = dp16, horizontal = dp5)
            )
            Spacer(modifier = Modifier.width(dp12))
            Column {
                Text(
                    text = stringResource(id = R.string.income),
                    style = MaterialTheme.typography.caption.copy(color = secondary)
                )
                Text(
                    text = "\$778.35",
                    style = MaterialTheme.typography.h4.copy(color = success, fontSize = sp18)
                )
            }
        }
    }
}

@Composable
fun outcome() {
    Card(
        shape = RoundedCornerShape(dp15),
        modifier = Modifier
            .height(dp76)
            .width(dp163)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                .background(color = white)
                .padding(start = dp12, top = dp12, bottom = dp12)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_arrow_down),
                contentDescription = "outcome",
                modifier = Modifier
                    .clip(RoundedCornerShape(dp10))
                    .background(color = critical.copy(alpha = 0.2f))
                    .padding(vertical = dp16, horizontal = dp5)
            )
            Spacer(modifier = Modifier.width(dp12))
            Column {
                Text(
                    text = stringResource(id = R.string.outcome),
                    style = MaterialTheme.typography.caption.copy(color = secondary)
                )
                Text(
                    text = "\$878.35",
                    style = MaterialTheme.typography.h4.copy(color = critical, fontSize = sp18)
                )
            }
        }
    }
}

@Composable
fun chart() {
    Row(modifier = Modifier.padding(dp16)) {
        Image(
            painter = painterResource(id = R.drawable.fake_chart),
            contentDescription = "fake chart"
        )
    }
}

@Preview
@Composable
fun timeLine(text: String = "30 days", isActive: Boolean = false) {
    var isButtonActive = remember { mutableStateOf(isActive) }
    OutlinedButton(
        shape = RoundedCornerShape(dp7),
        border = BorderStroke(dp1, color = if (isButtonActive.value) primary else borderNor),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = onSurface),
        onClick = {
            isButtonActive.value = true
        }) {
        Text(text = text, style = MaterialTheme.typography.caption.copy(color = onSurface))
    }
}