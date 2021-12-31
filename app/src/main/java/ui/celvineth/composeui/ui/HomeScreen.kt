package ui.celvineth.composeui.ui

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ui.celvineth.composeui.R
import ui.celvineth.composeui.ui.theme.component.NavigationComponent


@Composable
fun HomeScreen() {
    Column {
        Column {
            MessageCard(msg = Message("Thingki", "Hello World!"))
            MessageCard(msg = Message("Thingki", "Hello World!"))
        }
    }
}

data class Message(val author: String, val content: String)

@Composable
fun MessageCard(msg: Message) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = R.drawable.ic_money),
            contentDescription = stringResource(
                id = R.string.logo_app
            ),
            modifier = Modifier
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = msg.author, color = MaterialTheme.colors.secondaryVariant)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = msg.content)
        }
    }
}

@Composable
@Preview
fun previewMessageCard() {
    MessageCard(msg = Message("Thingki", "Hello World!"))
}