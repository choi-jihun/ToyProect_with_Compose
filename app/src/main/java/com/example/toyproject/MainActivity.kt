package com.example.toyproject

import android.os.Bundle
import android.os.Environment
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.toyproject.ui.components.feed.SomeParentComposable
import com.example.toyproject.ui.theme.ToyProjectTheme
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            checkAndCreatePicturesFolder()
            ToyProjectTheme {
                SomeParentComposable(onFeedSubmit = {
                    //나중에 서버에 저장되도록
                }, onCancel = {
                    //뒤로가기
                }
                )
            }
        }
    }

    private fun checkAndCreatePicturesFolder() {
        val picturesDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        if (picturesDir == null || !picturesDir.exists()) {
            Timber.tag("MainActivity").d("Pictures 폴더 생성 없음")
        } else {
            Timber.tag("MainActivity").d("Pictures 폴더 이미 존재함")
        }
    }
}

