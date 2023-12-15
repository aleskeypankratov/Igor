package ru.handh.school.igor.ui.screen

sealed class NavigationItem(
    val route: String
) {
    object SignIn : NavigationItem("SignInContent")
    object About : NavigationItem("AboutContent")
}