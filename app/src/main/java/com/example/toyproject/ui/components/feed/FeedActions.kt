package com.example.toyproject.ui.components.feed

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.toyproject.R
import com.example.toyproject.ui.theme.Paddings
import com.example.toyproject.ui.theme.color.Gray900
import com.example.toyproject.ui.theme.color.Red500

@Composable
fun FeedActions(
    onCommentClicked: () -> Unit,
    onLikedClicked: () -> Unit,
    isLiked: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Paddings.medium),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_comment_24),
                contentDescription = "댓글"
            )

        }
        Spacer(modifier = Modifier.padding(Paddings.medium))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = if (isLiked) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                contentDescription = "좋아요",
                tint = if (isLiked) Red500 else Gray900
            )
        }
    }
}

@Preview
@Composable
fun FeedActionsPreview() {
    FeedActions(onCommentClicked = { /*TODO*/ }, onLikedClicked = { /*TODO*/ }, isLiked = true)
}