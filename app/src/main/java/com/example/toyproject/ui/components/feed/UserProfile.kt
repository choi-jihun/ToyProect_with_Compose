package com.example.toyproject.ui.components.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.toyproject.R
import com.example.toyproject.ui.theme.Paddings

@Composable
fun UserProfileHeader(
    imageUrl: String,
    username: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = Paddings.medium, vertical = Paddings.medium) // 적당한 padding으로 조정
    ) {
        ProfilePicture(imageUrl = imageUrl)
        Spacer(modifier = Modifier.width(Paddings.large)) // 사진과 이름 사이의 간격
        Text(
            text = username,
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.onSurface
        )
    }
}

@Composable
fun ProfilePicture(imageUrl: String?, size: Dp = 40.dp) {
    val imagePainter = if (!imageUrl.isNullOrEmpty()) {
        rememberAsyncImagePainter(model = imageUrl)
    } else {
        painterResource(id = R.drawable.iu)
    }

    Image(
        painter = imagePainter,
        contentDescription = "Profile Image",
        modifier = Modifier
            .size(size)
            .clip(CircleShape)
            .border(Paddings.xsmall, MaterialTheme.colors.onBackground, CircleShape),
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
fun UserProfileHeaderPreview() {
    UserProfileHeader(
        imageUrl = "",
        username = "IU"
    )
}

