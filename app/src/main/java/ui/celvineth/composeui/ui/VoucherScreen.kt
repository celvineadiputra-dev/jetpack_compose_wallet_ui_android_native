package ui.celvineth.composeui.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import ui.celvineth.composeui.R
import ui.celvineth.composeui.ui.theme.*
import ui.celvineth.composeui.ui.theme.component.NavigationComponent
import ui.celvineth.composeui.ui.theme.component.Separator

@Composable
fun VoucherScreen(navController: NavController) {
    ComposeUiTheme {
        Column {
            NavigationComponent(
                navName = stringResource(id = R.string.voucher),
                context = LocalContext.current,
                navController = navController
            )
            Spacer(modifier = Modifier.padding(top = dp12))
            ListCard()
            Separator()
            ListCategories()
            Separator()
        }
    }
}

@Composable
fun ListCard() {
    data class Coupons(val title: String, val code: String, val color: Color)

    val listCoupons = listOf(
        Coupons("THE TEST KITCHEN", "R012", white),
        Coupons("THE COURSE", "OXE1", onSurface),
        Coupons("THE BOOT", "R001", onSurface),
    )
    LazyRow(modifier = Modifier.padding(start = dp16, bottom = dp10)) {
        items(listCoupons) { item ->
            CardVoucher(title = item.title, code = item.code, item.color)
        }
    }
}

@Composable
fun CardVoucher(title: String, code: String, color: Color) {
    Card(
        modifier = Modifier
            .height(dp140)
            .width(dp300)
            .padding(end = dp12, start = dp2),
        backgroundColor = color
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(horizontal = dp24, vertical = dp16)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.body1.copy(
                    fontWeight = FontWeight.Medium,
                    color = if (color == onSurface) white else onSurface
                ),
                modifier = Modifier.padding(bottom = dp5)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = code,
                    style = MaterialTheme.typography.h3.copy(color = success, fontSize = sp24),
                    modifier = Modifier.padding(bottom = dp2)
                )

                Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(primary)) {
                    Text(
                        text = "Copy",
                        style = MaterialTheme.typography.button.copy(color = white),
                        modifier = Modifier.padding(horizontal = dp10)
                    )
                }
            }
            Text(
                text = "COUPON",
                style = MaterialTheme.typography.caption.copy(color = if (color == onSurface) white else secondary)
            )
            Row(
                modifier = Modifier.padding(top = dp10),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_alert_minor),
                    contentDescription = "Alert",
                    modifier = Modifier.padding(end = dp5)
                )
                Text(
                    text = "Term of use",
                    style = MaterialTheme.typography.caption.copy(color = secondary)
                )
            }
        }
    }
}

@Composable
fun ListCategories() {
    data class CategoryModel(val text: String, val icon: Int, val color: Color)

    val listCategory = listOf(
        CategoryModel("All", R.drawable.ic_ticket, primary),
        CategoryModel(stringResource(id = R.string.internet), R.drawable.ic_internet, interactive),
        CategoryModel(stringResource(id = R.string.electricity), R.drawable.ic_electricity, warning),
        CategoryModel(stringResource(id = R.string.market), R.drawable.ic_market, success),
        CategoryModel(stringResource(id = R.string.medical), R.drawable.ic_medical, critical),
        CategoryModel(stringResource(id = R.string.wallet), R.drawable.ic_water, softBlue),
    )
    Column(modifier = Modifier.padding(top = dp12, bottom = dp12, start = dp16)) {
        Text(
            text = stringResource(id = R.string.categories),
            modifier = Modifier.padding(bottom = dp16),
            style = MaterialTheme.typography.h4.copy(color = onSurface)
        )
        LazyRow {
            items(listCategory) { item ->
                Spacer(modifier = Modifier.width(dp10))
                Categories(text = item.text, icon = item.icon, color = item.color)
            }
        }
    }
}

@Composable
fun Categories(text: String, icon: Int, color: Color) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .size(dp56)
                .clip(shape = CircleShape)
                .background(color = color)
                .padding(dp14),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = text
            )
        }
        Text(
            text = text,
            modifier = Modifier.padding(top = dp8),
            style = MaterialTheme.typography.caption.copy(
                fontWeight = FontWeight.Normal,
                color = onSurface
            )
        )
    }
}