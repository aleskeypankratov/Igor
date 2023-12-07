package ru.handh.school.igor.ui.theme

import androidx.compose.ui.graphics.Color

data class AppColors(

    val primaryBrand: Color,
    val primary: Color,
    val textOnControl: Color,
    val unfocus: Color
)

val defaultColors = AppColors(
    primaryBrand = Color(0xFF000000),
    primary = Color(0xFF0D6EFD),
    unfocus = Color(0xFFC2C2C2),
    textOnControl = Color(0xFFFFFFFF)
)
