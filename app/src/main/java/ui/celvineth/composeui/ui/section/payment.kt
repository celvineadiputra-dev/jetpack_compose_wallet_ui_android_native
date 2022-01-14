package ui.celvineth.composeui.ui.section

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import ui.celvineth.composeui.R
import ui.celvineth.composeui.ui.theme.*


@Composable
fun Payment() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = dp16),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            subPayment(
                type = stringResource(id = R.string.electricity),
                icon = R.drawable.ic_electricity,
                color = warning
            )

            subPayment(
                type = stringResource(id = R.string.internet),
                icon = R.drawable.ic_internet,
                color = interactive
            )

            subPayment(
                type = stringResource(id = R.string.insurrance),
                icon = R.drawable.ic_insurrance,
                color = success
            )

            subPayment(
                type = stringResource(id = R.string.medical),
                icon = R.drawable.ic_medical,
                color = critical
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            subPayment(
                type = stringResource(id = R.string.market),
                icon = R.drawable.ic_market,
                color = success
            )

            subPayment(
                type = stringResource(id = R.string.electric_bill),
                icon = R.drawable.ic_electric,
                color = warning
            )

            subPayment(
                type = stringResource(id = R.string.television),
                icon = R.drawable.ic_tv,
                color = interactive
            )

            subPayment(
                type = stringResource(id = R.string.water_bill),
                icon = R.drawable.ic_water,
                color = softBlue
            )
        }
    }
}

@Composable
fun subPayment(type: String, icon: Int, color: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            modifier = Modifier
                .width(dp56)
                .height(dp58)
                .clip(RoundedCornerShape(dp20))
                .background(color = color)
                .padding(dp14)
        ) {
            Image(painter = painterResource(id = icon), contentDescription = type)
        }
        Spacer(modifier = Modifier.height(dp8))
        Text(text = type, style = MaterialTheme.typography.caption)
    }
}