package ru.handh.school.igor.ui.theme

import androidx.compose.ui.graphics.Color

data class AppColors(

    val primaryBrand: Color,
    val primary: Color,
    val textOnControl: Color,
    val unfocus: Color,
    val background: Color,
    val button: Color,
    val projectDescription: Color,
    val projectName: Color
)

val defaultColors = AppColors(
    primaryBrand = Color(0xFF000000),
    primary = Color(0xFF0D6EFD),
    unfocus = Color(0xFFC2C2C2),
    textOnControl = Color(0xFFFFFFFF),
    background = Color(0xFFFEF7FF),
    projectDescription = Color(0xFF49454F),
    projectName = Color(0xFF1D1B20),
    button = Color(0xFFDC3545)
)
