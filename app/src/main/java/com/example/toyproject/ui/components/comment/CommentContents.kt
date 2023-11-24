package com.example.toyproject.ui.components.comment

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.toyproject.ui.theme.color.Black
import com.example.toyproject.ui.theme.color.Blue500
import com.example.toyproject.ui.theme.color.Gray300
import com.example.toyproject.ui.theme.color.Gray500

@Composable
fun CommentSection(onCommentSubmit: (String) -> Unit) {
    var comment by remember {
        mutableStateOf("")
    }

    CommentInputField(
        text = comment,
        onTextChange = { comment = it },
        onCommentSubmit = {
            if (comment.isNotBlank()) {
                onCommentSubmit(comment)
                comment = ""
            }
        }
    )
}

@Composable
fun CommentInputField(
    text: String,
    onTextChange: (String) -> Unit,
    onCommentSubmit: () -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        TextField(
            value = text,
            onValueChange = onTextChange,
            placeholder = { Text("댓글을 입력하세요...") },
            modifier = Modifier.weight(1f),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Gray300,
                textColor = Black
            )
        )
        IconButton(
            onClick = onCommentSubmit,
            enabled = text.isNotBlank(),
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            Icon(
                imageVector = Icons.Filled.Send,
                contentDescription = "전송",
                tint = if (text.isNotBlank()) Blue500 else Gray500
            )
        }
    }
}

@Preview
@Composable
fun CommentInputFieldPreview() {
    CommentSection {
        //나중에 서버에 전달하는 로직 구현
    }
}