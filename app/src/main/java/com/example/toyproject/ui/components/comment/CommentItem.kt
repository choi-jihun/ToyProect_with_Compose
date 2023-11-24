package com.example.toyproject.ui.components.comment

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.toyproject.R
import com.example.toyproject.ui.theme.Paddings

@Composable
fun CommentsList(comments: List<Comment>) {
    val replyVisibilityState = remember { mutableStateMapOf<String, Boolean>() }
    val replyInputVisibilityState = remember { mutableStateMapOf<String, Boolean>() }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(comments) { comment ->
            CommentItem(
                comment = comment,
                replyVisibilityState = replyVisibilityState,
                replyInputVisibilityState = replyInputVisibilityState,
                onToggleRepliesVisibility = { id, isVisible ->
                    replyVisibilityState[id] = isVisible
                },
                onToggleReplyInputVisibility = { id, isVisible ->
                    replyInputVisibilityState[id] = isVisible
                }
            )
        }
    }
}

@Composable
fun CommentItem(
    comment: Comment,
    replyVisibilityState: Map<String, Boolean>,
    replyInputVisibilityState: Map<String, Boolean>,
    onToggleRepliesVisibility: (String, Boolean) -> Unit,
    onToggleReplyInputVisibility: (String, Boolean) -> Unit
) {
    val isRepliesVisible = replyVisibilityState[comment.id] == true
    val isReplyInputVisible = replyInputVisibilityState[comment.id] == true

    Row(
        modifier = Modifier
            .padding(Paddings.medium)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.iu),
            contentDescription = "프로필사진",
            modifier = Modifier
                .size(40.dp)
                .clip(
                    CircleShape
                )
                .border(Paddings.xsmall, MaterialTheme.colors.onBackground, CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.padding(Paddings.medium))
        Column {
            Text(text = comment.userName, style = MaterialTheme.typography.h5)
            Spacer(modifier = Modifier.size(Paddings.small))
            Text(text = comment.content, style = MaterialTheme.typography.body2)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = comment.timestamp, style = MaterialTheme.typography.caption)
                TextButton(onClick = {
                    onToggleReplyInputVisibility(
                        comment.id,
                        !isReplyInputVisible
                    )
                }) {
                    Text("답글 달기")
                }
            }
            if (isReplyInputVisible) {
                CommentSection {
                    //나중에 서버에 전달하는 로직 구현
                }
            }
            if (comment.replies.isNotEmpty()) {
                TextButton(onClick = { onToggleRepliesVisibility(comment.id, !isRepliesVisible) }) {
                    Text(text = if (isRepliesVisible) "답글 숨기기" else "답글 ${comment.replies.size}개 보기")
                }
            }

            if (isRepliesVisible) {
                comment.replies.forEach { reply ->
                    CommentItem(
                        comment = reply,
                        replyVisibilityState = replyVisibilityState,
                        replyInputVisibilityState = replyInputVisibilityState,
                        onToggleRepliesVisibility = onToggleRepliesVisibility,
                        onToggleReplyInputVisibility = onToggleReplyInputVisibility
                    )
                }
            }
        }
    }
}

data class Comment(
    val id: String,
    val userImageUrl: String,
    val userName: String,
    val content: String,
    val timestamp: String,
    val replies: List<Comment>
)

@Preview
@Composable
fun CommentsListPreview() {
    val sampleComments = listOf(
        Comment(
            id = "1",
            userImageUrl = "https://example.com/image1.jpg",
            userName = "사용자1",
            content = "첫 번째 댓글입니다.",
            timestamp = "1시간 전",
            replies = listOf(
                Comment(
                    id = "2",
                    userImageUrl = "https://example.com/image2.jpg",
                    userName = "사용자2",
                    content = "첫 번째 댓글에 대한 답글입니다.",
                    timestamp = "30분 전",
                    replies = listOf()
                )
            )
        ),
        Comment(
            id = "3",
            userImageUrl = "https://example.com/image3.jpg",
            userName = "사용자3",
            content = "두 번째 댓글입니다.",
            timestamp = "2시간 전",
            replies = listOf()
        )
    )

    CommentsList(comments = sampleComments)
}