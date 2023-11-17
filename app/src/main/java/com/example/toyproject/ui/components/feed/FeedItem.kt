package com.example.toyproject.ui.components.feed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.toyproject.ui.theme.Paddings

@Composable
fun FeedItem() {
    Card(
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.surface,
        elevation = Paddings.none,
        modifier = Modifier.padding(Paddings.medium)
    ) {
        var expanded by remember { mutableStateOf(false) }

        Column(modifier = Modifier.fillMaxHeight()) {
            UserProfileHeader(
                imageUrl = "",
                username = "IU",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(Paddings.xsmall))
            FeedContent(
                textContent = "컨텐츠가 들어갑니다",
                imageUrl = "dummy",
                expanded = expanded,
                onExpandedChange = { expanded = it }
            )
        }
    }
}

@Preview
@Composable
fun FeedItemPreview() {
    FeedItem()
}