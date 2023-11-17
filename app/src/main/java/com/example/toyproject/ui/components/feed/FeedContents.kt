package com.example.toyproject.ui.components.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.toyproject.R
import com.example.toyproject.ui.theme.Paddings

@Composable
fun FeedContent(
    textContent: String,
    imageUrl: String? = null,
    expanded: Boolean = false,
    onExpandedChange: (Boolean) -> Unit
) {
    val typography = MaterialTheme.typography

    Column(
        modifier = Modifier
            .padding(Paddings.medium)
            .height(500.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = if (expanded || textContent.length <= 30) textContent else textContent.take(30) + "...더보기",
            style = typography.body1,
            maxLines = if (expanded) Int.MAX_VALUE else 2, // 확장되면 최대 줄 수 없음
            modifier = Modifier.clickable { onExpandedChange(expanded) } // 클릭하여 확장/축소
        )

        Spacer(modifier = Modifier.padding(Paddings.medium))

        // 이미지 URL이 있다면 이미지를 보여주는 부분
//        imageUrl?.let {
//            Spacer(modifier = Modifier.height(Paddings.medium))
//            Image(
//                painter = rememberAsyncImagePainter(it),
//                contentDescription = "피드 이미지",
//                modifier = Modifier.fillMaxWidth()
//            )
//        } 나중에 여기 주석 풀어주기

        if (imageUrl == "dummy") {
            Spacer(modifier = Modifier.fillMaxWidth())
            Image(
                painter = painterResource(id = R.drawable.iu), // 프리뷰용 이미지
                contentDescription = "피드 이미지",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
        } else if (imageUrl != null) {
            Spacer(modifier = Modifier.height(Paddings.medium))
            Image(
                painter = rememberAsyncImagePainter(imageUrl),
                contentDescription = "피드 이미지",
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun FeedExpand(textContent: String, imageUrl: String?) {
    var expanded by remember {
        mutableStateOf(false)
    }

    FeedContent(
        textContent = textContent,
        imageUrl = imageUrl,
        expanded = expanded,
        onExpandedChange = { expanded = it }
    )
}

@Preview
@Composable
fun FeedExpandPreview() {
    FeedExpand(
        textContent = "테스트 피드입니다. 여기에는 더 많은 내용들이 들어가게 될 것입니다. 이게 과연 30자를 넘어갈까요??? 아마 그럴거 같아요",
        imageUrl = "dummy" //나중에 수정필요
    )
}