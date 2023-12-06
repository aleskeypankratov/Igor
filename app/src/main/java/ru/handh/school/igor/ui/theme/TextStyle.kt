package ru.handh.school.igor.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import ru.handh.school.igor.R

data class AppTextStyles(
    val text1: TextStyle,
    val textEnter: TextStyle
)

val defaultTextStyles = AppTextStyles(
    text1 = TextStyle(
        fontSize = 14.sp,
        lineHeight = 22.sp
    ),
    textEnter = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_bold)),
        fontSize = 32.sp,
        lineHeight = 20.sp,
        letterSpacing = 1.sp,

    )
)
