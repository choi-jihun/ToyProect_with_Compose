package com.example.toyproject.ui.components.feed

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FeedList(feedItems: List<FeedItemData>) {
    LazyColumn {
        items(feedItems) { feedItem ->
            FeedItem(
                username = feedItem.username,
                imageUrl = feedItem.imageUrl,
                textContent = feedItem.textContent,
                timestamp = feedItem.timestamp,
                isLiked = feedItem.isLiked,
                onLikedClicked = {
                    // 좋아요 버튼 클릭 시 수행할 로직
                    // 추후에 추가
                },
                onCommentClicked = {
                    // 댓글 버튼 클릭 시 수행할 로직
                    // 추후에 추가
                }
            )
        }
    }
}

data class FeedItemData(
    val id: String,
    val username: String,
    val imageUrl: String?,
    val textContent: String,
    val timestamp: String,
    val isLiked: Boolean
)

@Preview
@Composable
fun FeedListPreview() {
    val sampleFeedItems = listOf(
        FeedItemData(
            id = "1",
            username = "사용자1",
            imageUrl = "dummy",
            textContent = "여기에는 더 많은 내용들이 들어가게 될 것입니다. 첫 번째 피드.",
            timestamp = "1시간 전",
            isLiked = false
        ),
        FeedItemData(
            id = "2",
            username = "사용자2",
            imageUrl = "dummy",
            textContent = "두 번째 피드입니다. 여기에도 흥미로운 내용이 있습니다.",
            timestamp = "2시간 전",
            isLiked = true
        )
    )

    FeedList(feedItems = sampleFeedItems)
}