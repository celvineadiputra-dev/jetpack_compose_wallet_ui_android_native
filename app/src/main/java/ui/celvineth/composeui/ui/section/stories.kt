package ui.celvineth.composeui.ui.section

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import ui.celvineth.composeui.R
import ui.celvineth.composeui.ui.theme.*

private val listName =
    mutableListOf("Celvine", "Alice", "Petter", "Alika", "Cabelita", "Rucika", "Admin")


@Composable
fun Stories() {
    LazyRow {
        items(listName) { name ->
            SubStories(name = name)
        }
    }
}

@Composable
fun SubStories(name: String) {
    Column(
        modifier = Modifier.padding(end = dp16),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .border(width = dp2, color = primary, shape = CircleShape)
                .padding(dp4),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.avatar_stories),
                contentDescription = "AvatarStories"
            )
        }
        Spacer(modifier = Modifier.height(dp8))
        Text(text = name, style = MaterialTheme.typography.caption)
    }
}
