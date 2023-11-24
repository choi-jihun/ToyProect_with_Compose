package com.example.toyproject.ui.components.feed

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.toyproject.ui.theme.Paddings
import com.example.toyproject.ui.theme.ToyProjectTheme

@Composable
fun SimpleChip(
    text: String,
    onChipClicked: () -> Unit,
    onRemoveChip: (String) -> Unit
) {
    Surface(
        color = MaterialTheme.colors.primary,
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .padding(Paddings.xsmall)
            .clickable(onClick = onChipClicked),
        elevation = Paddings.small
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = text, modifier = Modifier.padding(start = Paddings.medium))
            IconButton(onClick = { onRemoveChip(text) }) {
                Icon(
                    imageVector = Icons.Filled.Clear,
                    contentDescription = "칩 삭제",
                    modifier = Modifier.size(20.dp)
                )
            }

        }
    }
}

@Preview
@Composable
fun SimpleChipPreview() {
    ToyProjectTheme {
        SimpleChip(text = "가나다라마바사", onChipClicked = { /*TODO*/ }, onRemoveChip = {})
    }
}