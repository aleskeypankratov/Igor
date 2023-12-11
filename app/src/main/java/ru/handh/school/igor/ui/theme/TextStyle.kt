package ru.handh.school.igor.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import ru.handh.school.igor.R

data class AppTextStyles(
    val smallText: TextStyle,
    val mediumText: TextStyle,
    val normalText: TextStyle,
    val maxText: TextStyle,
)

val defaultTextStyles = AppTextStyles(
    smallText = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_medium)), fontSize = 14.sp, lineHeight = 22.sp
    ), mediumText = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_medium)), fontSize = 16.sp, lineHeight = 20.sp
    ), normalText = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_medium)), fontSize = 24.sp, lineHeight = 20.sp
    ), maxText = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_medium)), fontSize = 32.sp, lineHeight = 20.sp
    )
)
