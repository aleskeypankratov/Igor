package ru.handh.school.igor.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import ru.handh.school.igor.R

data class AppTextStyles(
    val smallMediumText: TextStyle,
    val mediumMediumText: TextStyle,
    val normalMediumText: TextStyle,
    val maxMediumText: TextStyle,
    val smallLightText: TextStyle,
)

val defaultTextStyles = AppTextStyles(
    smallMediumText = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_medium)),
        fontSize = 14.sp,
        lineHeight = 22.sp
    ),
    mediumMediumText = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_medium)),
        fontSize = 16.sp,
        lineHeight = 20.sp
    ),
    normalMediumText = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_medium)),
        fontSize = 24.sp,
        lineHeight = 20.sp
    ),
    maxMediumText = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_medium)),
        fontSize = 32.sp,
        lineHeight = 20.sp
    ),
    smallLightText = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_light)),
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
)
