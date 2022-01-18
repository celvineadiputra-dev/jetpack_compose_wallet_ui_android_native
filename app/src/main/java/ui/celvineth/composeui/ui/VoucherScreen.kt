package ui.celvineth.composeui.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ui.celvineth.composeui.R
import ui.celvineth.composeui.ui.theme.*
import ui.celvineth.composeui.ui.theme.component.NavigationComponent
import ui.celvineth.composeui.ui.theme.component.Separator

@Composable
fun VoucherScreen(navController: NavController) {
    var scrollState = rememberScrollState()
    ComposeUiTheme {
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)) {
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
            Sale()
            Separator()
            SaleOff()
            Spacer(modifier = Modifier.height(dp70))
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
        CategoryModel(
            stringResource(id = R.string.electricity),
            R.drawable.ic_electricity,
            warning
        ),
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
                Spacer(modifier = Modifier.width(dp8))
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

@Composable
fun Sale() {
    Column(modifier = Modifier.padding(dp16)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.top_trending_deals),
                style = MaterialTheme.typography.h4.copy(color = onSurface, fontSize = sp18)
            )
            Text(
                text = stringResource(id = R.string.view_all),
                style = MaterialTheme.typography.caption.copy(color = primary)
            )
        }
        Spacer(modifier = Modifier.height(dp12))
        ListTopDeal()
    }
}

@Composable
fun SaleOff() {
    Column(modifier = Modifier.padding(dp16)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Sale off 50%",
                style = MaterialTheme.typography.h4.copy(color = onSurface, fontSize = sp18)
            )
            Text(
                text = stringResource(id = R.string.view_all),
                style = MaterialTheme.typography.caption.copy(color = primary)
            )
        }
        Spacer(modifier = Modifier.height(dp12))
        ListSaleOff()
    }
}

@Composable
fun ListTopDeal() {
    data class TopDeals(
        val title: String,
        val rating: String,
        val category: String,
        val type: String,
        val image: Int
    )

    val listTopDeals = listOf(
        TopDeals(
            title = "Chillox Burger",
            rating = "4.7",
            category = "Burgers * Fast food",
            type = "FreeShip",
            image = R.drawable.ic_dummy_img
        ),
        TopDeals(
            title = "Sandwich",
            rating = "4.9",
            category = "Sandwich * Fast food",
            type = "FreeShip",
            image = R.drawable.ic_dummy_img
        ),
        TopDeals(
            title = "Chillox Burger",
            rating = "4.7",
            category = "Burgers * Fast food",
            type = "FreeShip",
            image = R.drawable.ic_dummy_img
        ),
    )

    LazyRow {
        items(listTopDeals) { item ->
            CardSection(
                title = item.title,
                rating = item.rating,
                category = item.category,
                type = item.type,
                image = item.image
            )
            Spacer(modifier = Modifier.width(dp10))
        }
    }
}

@Composable
fun ListSaleOff() {
    data class TopDeals(
        val title: String,
        val rating: String,
        val category: String,
        val type: String,
        val image: Int
    )

    val listTopDeals = listOf(
        TopDeals(
            title = "Chillox Burger",
            rating = "4.7",
            category = "Burgers * Fast food",
            type = "FreeShip",
            image = R.drawable.ic_dummy_img
        ),
        TopDeals(
            title = "Sandwich",
            rating = "4.9",
            category = "Sandwich * Fast food",
            type = "FreeShip",
            image = R.drawable.ic_dummy_img
        ),
        TopDeals(
            title = "Chillox Burger",
            rating = "4.7",
            category = "Burgers * Fast food",
            type = "FreeShip",
            image = R.drawable.ic_dummy_img
        ),
    )

    LazyRow {
        items(listTopDeals) { item ->
            CardSection(
                title = item.title,
                rating = item.rating,
                category = item.category,
                type = item.type,
                image = item.image
            )
            Spacer(modifier = Modifier.width(dp10))
        }
    }
}

@Composable
fun CardSection(title: String, rating: String, category: String, type: String, image: Int) {
    Card(
        modifier = Modifier
            .width(dp200)
            .height(dp166), backgroundColor = white
    ) {
        Column(modifier = Modifier.padding(0.dp)) {
            Image(
                painter = painterResource(id = image),
                contentDescription = title,
                modifier = Modifier
                    .width(dp200)
                    .height(100.dp)
                    .padding(0.dp)
            )
            Column(modifier = Modifier.padding(dp8)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.caption.copy(fontWeight = FontWeight.Medium)
                    )
                    Text(
                        text = type,
                        style = MaterialTheme.typography.caption.copy(
                            color = success,
                            fontSize = sp12
                        )
                    )
                }
                Spacer(modifier = Modifier.height(dp4))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = category,
                        style = MaterialTheme.typography.caption.copy(color = secondary)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_star),
                            contentDescription = "rating"
                        )
                        Spacer(modifier = Modifier.width(dp4))
                        Text(
                            text = rating,
                            style = MaterialTheme.typography.caption.copy(color = onSurface)
                        )
                    }
                }
            }
        }
    }
}