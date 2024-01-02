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
    val titleText: TextStyle,
    val miniMediumText: TextStyle,
    val normalRegularText: TextStyle,
    val mediumRegularText: TextStyle,
    val smallRegularText: TextStyle,
)

val defaultTextStyles = AppTextStyles(
    smallMediumText = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_medium)), fontSize = 14.sp, lineHeight = 22.sp
    ), mediumMediumText = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_medium)), fontSize = 16.sp, lineHeight = 20.sp
    ), miniMediumText = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_medium)), fontSize = 20.sp, lineHeight = 20.sp
    ), normalMediumText = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_medium)), fontSize = 24.sp, lineHeight = 20.sp
    ), maxMediumText = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_medium)), fontSize = 32.sp, lineHeight = 20.sp
    ), smallLightText = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_light)), fontSize = 14.sp, lineHeight = 20.sp
    ), titleText = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_regular)), fontSize = 22.sp, lineHeight = 28.sp
    ), normalRegularText = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_regular)), fontSize = 22.sp, lineHeight = 28.sp
    ), mediumRegularText = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_regular)), fontSize = 16.sp, lineHeight = 24.sp, letterSpacing = 0.5f.sp
    ), smallRegularText = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_regular)), fontSize = 14.sp, lineHeight = 20.sp, letterSpacing = 0.25f.sp
    )
)
