package com.example.toyproject.ui.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.example.toyproject.R

private val spoqaBold = FontFamily(Font(R.font.spoqa_han_sans_neo_bold, FontWeight.Bold))
private val spoqaRegular = FontFamily(Font(R.font.spoqa_han_sans_neo_regular, FontWeight.Normal))
private val spoqaThin = FontFamily(Font(R.font.spoqa_han_sans_neo_thin, FontWeight.Thin))

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 60.sp
    ),
    h2 = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 32.sp,
    ),
    h3 = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 24.sp
    ),
    h4 = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 32.sp
    ),
    h5 = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 18.sp
    ),
    h6 = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 15.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = spoqaRegular,
        fontSize = 18.sp,
    ),
    button = TextStyle(
        fontFamily = spoqaRegular,
        fontSize = 18.sp,
    ),
    subtitle2 = TextStyle(
        fontFamily = spoqaRegular,
        fontSize = 14.sp
    ),
    body1 = TextStyle(
        fontFamily = spoqaRegular,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = spoqaRegular,
        fontSize = 12.sp,
    ),
    caption = TextStyle(
        fontFamily = spoqaThin,
        fontSize = 14.sp
    )

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

val Typography.H5Title: TextStyle
    @Composable get() = h5.copy(
        fontSize = 24.sp
    )

val Typography.dialogButton: TextStyle
    @Composable get() = button.copy(
        fontSize = 18.sp
    )

val Typography.underlinedDialogButton: TextStyle
    @Composable get() = button.copy(
        textDecoration = TextDecoration.Underline
    )

val Typography.underlinedButton: TextStyle
    @Composable get() = button.copy(
        textDecoration = TextDecoration.Underline
    )