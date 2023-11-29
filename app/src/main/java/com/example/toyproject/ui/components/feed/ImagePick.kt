package com.example.toyproject.ui.components.feed

import androidx.compose.foundation.layout.Column
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import com.example.toyproject.R

@Composable
fun ImagePickerButton(
    onPickFromGallery: () -> Unit,
    onTakePhoto: () -> Unit
) {
    var showMenu by remember { mutableStateOf(false) }

    Column {
        IconButton(onClick = { showMenu = true }) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_camera_alt_24),
                contentDescription = "사진 추가"
            )
        }
        DropdownMenu(
            expanded = showMenu,
            onDismissRequest = { showMenu = false }
        ) {
            DropdownMenuItem(onClick = {
                onPickFromGallery()
                showMenu = false
            }) {
                Text("갤러리에서 가져오기")
            }
            DropdownMenuItem(onClick = {
                onTakePhoto()
                showMenu = false
            }) {
                Text("카메라로 촬영하기")
            }
        }
    }
}
