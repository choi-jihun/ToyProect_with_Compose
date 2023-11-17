package com.example.toyproject.ui.theme.color

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray

val Red50 = Color(0xFFFFEBEE)
val Red100 = Color(0xFFFFCDD2)
val Red200 = Color(0xFFEF9A9A)
val Red300 = Color(0xFFE57373)
val Red400 = Color(0xFFEF5350)
val Red500 = Color(0xFFF44336)
val Red600 = Color(0xFFE53935)
val Red700 = Color(0xFFD32F2F)
val Red800 = Color(0xFFC62828)
val Red900 = Color(0xFFB71C1C)
val Purple50 = Color(0xFFF3E5F5)
val Purple100 = Color(0xFFE1BEE7)
val Purple200 = Color(0xFFCE93D8)
val Purple300 = Color(0xFFBA68C8)
val Purple400 = Color(0xFFAB47BC)
val Purple500 = Color(0xFF9C27B0)
val Purple600 = Color(0xFF8E24AA)
val Purple700 = Color(0xFF7B1FA2)
val Purple800 = Color(0xFF6A1B9A)
val Purple900 = Color(0xFF4A148C)
val DeepPurple50 = Color(0xFFEDE7F6)
val DeepPurple100 = Color(0xFFD1C4E9)
val DeepPurple200 = Color(0xFFB39DDB)
val DeepPurple300 = Color(0xFF9575CD)
val DeepPurple400 = Color(0xFF7E57C2)
val DeepPurple500 = Color(0xFF673AB7)
val DeepPurple600 = Color(0xFF5E35B1)
val DeepPurple700 = Color(0xFF512DA8)
val DeepPurple800 = Color(0xFF4527A0)
val DeepPurple900 = Color(0xFF311B92)
val Blue50 = Color(0xFFE3F2FD)
val Blue100 = Color(0xFFBBDEFB)
val Blue200 = Color(0xFF90CAF9)
val Blue300 = Color(0xFF64B5F6)
val Blue400 = Color(0xFF42A5F5)
val Blue500 = Color(0xFF2196F3)
val Blue600 = Color(0xFF1E88E5)
val Blue700 = Color(0xFF1976D2)
val Blue800 = Color(0xFF1565C0)
val Blue900 = Color(0XFF0D47A1)
val LightBlue50 = Color(0xFFE1F5FE)
val LightBlue100 = Color(0xFFB3E5FC)
val LightBlue200 = Color(0xFF81D4FA)
val LightBlue300 = Color(0xFF4FC3F7)
val LightBlue400 = Color(0xFF29B6F6)
val LightBlue500 = Color(0xFF03A9F4)
val LightBlue600 = Color(0xFF039BE5)
val LightBlue700 = Color(0xFF0288D1)
val LightBlue800 = Color(0xFF0277BD)
val LightBlue900 = Color(0XFF01579B)
val Green50 = Color(0xFFE8F5E9)
val Green100 = Color(0xFFC8E6C9)
val Green200 = Color(0xFFA5D6A7)
val Green300 = Color(0xFF81C784)
val Green400 = Color(0xFF66BB6A)
val Green500 = Color(0xFF4CAF50)
val Green600 = Color(0xFF43A047)
val Green700 = Color(0xFF388E3C)
val Green800 = Color(0xFF2E7D32)
val Green900 = Color(0xFF1B5E20)
val Gray50 = Color(0xFFFAFAFA)
val Gray100 = Color(0xFFF5F5F5)
val Gray200 = Color(0xFFEEEEEE)
val Gray300 = Color(0xFFE0E0E0)
val Gray400 = Color(0xFFBDBDBD)
val Gray500 = Color(0xFF9E9E9E)
val Gray600 = Color(0xFF757575)
val Gray700 = Color(0xFF616161)
val Gray800 = Color(0xFF424242)
val Gray900 = Color(0xFF212121)
val White = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)

sealed class ColorSet {
    open lateinit var LightColors: MyColors
    open lateinit var DarkColors: MyColors

    data object Default : ColorSet() {
        override var LightColors = MyColors(
            material = lightColors(
                primary = Blue500,
                primaryVariant = Blue700,
                secondary = LightBlue200,
                secondaryVariant = LightBlue400,
                surface = White,
                onSurface = Gray800,
                background = White,
                onBackground = Gray800,
                error = Red600,
                onPrimary = White,
                onSecondary = Gray900,
                onError = White
            ),
            // MyColors에서 지정해준 확장 색상
            success = Green400,
            disabledSecondary = Gray300,
            textFiledBackground = Gray100
        )

        override var DarkColors = MyColors(
            material = darkColors(
                primary = Purple200,
                primaryVariant = Purple700,
                secondary = DeepPurple200,
                secondaryVariant = DeepPurple700,
                surface = Gray900,
                onSurface = White,
                background = Gray900,
                onBackground = White,
                error = Red200,
                onPrimary = Black,
                onSecondary = White,
                onError = Black
            )
        )
    }
}