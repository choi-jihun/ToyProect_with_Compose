package com.example.toyproject.ui.components.feed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.toyproject.ui.theme.Paddings

@Composable
fun FeedItem() {
    Card(
        shape = MaterialTheme.shapes.large,
        backgroundColor = MaterialTheme.colors.surface,
        elevation = Paddings.none,
        modifier = Modifier.padding(Paddings.medium)
    ) {
        var isLiked by remember {
            mutableStateOf(false)
        }
        var commentClicked by remember {
            mutableStateOf(false)
        }

        Column(
            modifier = Modifier
                .height(700.dp)
                .fillMaxWidth()
        ) {
            UserProfileHeader(
                imageUrl = "",
                username = "IU",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(Paddings.xsmall))
            FeedExpand(
                textContent = "컨텐츠가 들어갑니다.컨텐츠가 들어갑니다.컨텐츠가 들어갑니다.컨텐츠가 들어갑니다",
                imageUrl = "dummy"
            )

            Text(
                text = "xxxx년 xx월 xx일",
                modifier = Modifier
                    .padding(horizontal = Paddings.medium)
                    .padding(bottom = Paddings.small)
            )

            FeedActions(
                onCommentClicked = { commentClicked = !commentClicked },
                onLikedClicked = { isLiked = !isLiked },
                isLiked = isLiked
            )
        }
    }
}

@Preview
@Composable
fun FeedItemPreview() {
    FeedItem()
}