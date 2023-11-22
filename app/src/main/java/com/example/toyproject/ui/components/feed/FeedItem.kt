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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.toyproject.ui.theme.Paddings

@Composable
fun FeedItem(
    username: String,
    imageUrl: String?,
    textContent: String,
    timestamp: String,
    isLiked: Boolean,
    onLikedClicked: (Boolean) -> Unit,
    onCommentClicked: () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.large,
        backgroundColor = MaterialTheme.colors.surface,
        elevation = Paddings.none,
        modifier = Modifier.padding(Paddings.medium)
    ) {
        var liked by remember {
            mutableStateOf(isLiked) // 초기 상태를 매개변수에서 가져옴
        }

        Column(
            modifier = Modifier
                .height(700.dp)
                .fillMaxWidth()
        ) {
            UserProfileHeader(
                imageUrl = "",
                username = username
            )
            Spacer(modifier = Modifier.padding(Paddings.xsmall))
            FeedExpand(
                textContent = textContent,
                imageUrl = imageUrl
            )
            Text(
                text = timestamp,
                modifier = Modifier
                    .padding(horizontal = Paddings.medium)
                    .padding(bottom = Paddings.small)
            )
            FeedActions(
                onCommentClicked = onCommentClicked,
                onLikedClicked = {
                    liked = !liked
                    onLikedClicked(liked)
                },
                isLiked = liked
            )
        }
    }
}


@Preview
@Composable
fun FeedItemPreview() {
    FeedItem(
        username = "IU",
        imageUrl = "dummy",
        textContent = "테스트 피드입니다. 여기에는 더 많은 내용들이 들어가게 될 것입니다.",
        timestamp = "1시간 전",
        isLiked = false,
        onLikedClicked = { /* 좋아요 버튼 클릭 시 수행할 로직 */ },
        onCommentClicked = { /* 댓글 버튼 클릭 시 수행할 로직 */ }
    )
}