package ui.celvineth.composeui.ui.theme.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ui.celvineth.composeui.ui.theme.bgSeparator
import ui.celvineth.composeui.ui.theme.dp8


@Composable
fun Separator() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(dp8)
            .background(color = bgSeparator)
    ) {
    }
}