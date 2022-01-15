package ui.celvineth.composeui.ui.section

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import ui.celvineth.composeui.R
import ui.celvineth.composeui.ui.theme.*

@Composable
fun TradingHistory() {
    Column(
        modifier = Modifier
            .padding(vertical = dp24, horizontal = dp16)
    ) {
        Text(
            text = stringResource(id = R.string.trading_history),
            style = MaterialTheme.typography.h4
        )
        Spacer(modifier = Modifier.height(dp12))
        listHistory()
    }
}

@Composable
fun listHistory(){
    for (i in 0..4){
        Spacer(modifier = Modifier.height(dp8))
        List(
            text = "Electric bill",
            status = "Sent",
            money = "-$41.02",
            date = "Today, 12/01/22",
            color = critical
        )
    }
}

@Composable
fun List(text: String, status: String, money: String, date: String, color: Color) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        iconGenerator(icon = R.drawable.ic_electricity, color = warning)
        Spacer(modifier = Modifier.width(dp12))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column{
                Text(text = text, style = MaterialTheme.typography.body1)
                Text(text = status, style = MaterialTheme.typography.caption.copy(color = color))
            }
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = money,
                    style = MaterialTheme.typography.body1.copy(
                        fontWeight = FontWeight.Medium,
                        color = color
                    ),
                    modifier = Modifier.align(Alignment.End)
                )
                Text(
                    text = date,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.align(Alignment.End)
                )
            }
        }
    }
}


@Composable
fun iconGenerator(icon: Int, color: Color) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .height(dp48)
            .width(dp48)
            .clip(RoundedCornerShape(dp18))
            .background(color = color)
            .padding(dp12)
    ) {
        Image(painter = painterResource(id = icon), contentDescription = "icon")
    }
}