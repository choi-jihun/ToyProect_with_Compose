package com.example.toyproject.ui.components.feed

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.toyproject.ui.theme.Paddings
import com.example.toyproject.ui.theme.ToyProjectTheme
import com.example.toyproject.ui.theme.color.Black

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PostCreationScreen(
    title: String,
    onTitleChange: (String) -> Unit,
    inputTag: String,
    tags: List<String>,
    onTagAdded: (String) -> Unit,
    onTagRemoved: (String) -> Unit,
    onTagsChange: (String) -> Unit,
    content: String,
    onContentChange: (String) -> Unit,
    onSubmit: () -> Unit,
    onCancel: () -> Unit,
    onPickFromGallery: () -> Unit,
    onTakePhoto: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            value = title,
            onValueChange = onTitleChange,
            label = { Text("제목") },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                textColor = Black
            ),
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = inputTag,
            onValueChange = {
                if (it.endsWith(",") || it.endsWith("\n")) {
                    onTagAdded(it.trim().removeSuffix(",").removeSuffix("\n"))
                    onTagsChange("")
                } else {
                    onTagsChange(it)
                }
            },
            label = { Text("태그 (쉼표로 구분)") },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                textColor = Black
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        )
        TextField(
            value = content,
            onValueChange = onContentChange,
            label = { Text("본문") },
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                textColor = Black
            )
        )

        ImagePickerButton(
            onPickFromGallery = onPickFromGallery,
            onTakePhoto = onTakePhoto
        )

        FlowRow(
            modifier = Modifier
                .padding(Paddings.medium)
        ) {
            tags.forEach { tag ->
                SimpleChip(
                    text = tag,
                    onChipClicked = { onTagRemoved(tag) },
                    onRemoveChip = { onTagRemoved(tag) }
                )
                Spacer(modifier = Modifier.padding(Paddings.medium))
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = Paddings.medium),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = onCancel,
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
            ) {
                Text("취소", color = MaterialTheme.colors.onPrimary, fontSize = 15.sp)
            }

            Spacer(modifier = Modifier.width(Paddings.medium))

            Button(
                onClick = onSubmit,
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
            ) {
                Text("제출", color = MaterialTheme.colors.onPrimary, fontSize = 15.sp)
            }
        }
    }
}

@Composable
fun SomeParentComposable(onFeedSubmit: () -> Unit, onCancel: () -> Unit) {
    val context = LocalContext.current

    var title by remember { mutableStateOf("") }
    var inputTag by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    var tags by remember { mutableStateOf(listOf<String>()) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val galleryLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            if (uri != null) {
                imageUri = uri
            }
        }

    val onTagAdded: (String) -> Unit = { newTag ->
        val trimmedTag = newTag.trim().removeSuffix(",").removeSuffix("\n")
        if (trimmedTag.isNotBlank() && trimmedTag !in tags) {
            tags = tags + trimmedTag
        }
        inputTag = ""
    }

    val onTagRemoved: (String) -> Unit = { tag ->
        tags = tags.filterNot { it == tag }
    }

    val onPickFromGallery: () -> Unit = {
        galleryLauncher.launch("image/*")
    }

    val onTakePhoto: () -> Unit = {
    }


    PostCreationScreen(
        title = title,
        onTitleChange = { title = it },
        inputTag = inputTag,
        tags = tags,
        onTagAdded = onTagAdded,
        onTagRemoved = onTagRemoved,
        onTagsChange = { inputTag = it },
        content = content,
        onContentChange = { content = it },
        onSubmit = onFeedSubmit,
        onCancel = onCancel,
        onPickFromGallery = onPickFromGallery,
        onTakePhoto = onTakePhoto
    )
}

@Preview
@Composable
fun PostCreationScreenPreview() {
    ToyProjectTheme {
        SomeParentComposable(onFeedSubmit = {
            //나중에 서버에 저장되도록
        }, onCancel = {
            //뒤로가기
        }
        )
    }
}