package ru.handh.school.igor.ui.navigation

sealed class NavigationItem(
    val route: String
) {
    data object SignIn : NavigationItem("SignInContent")
    data object About : NavigationItem("AboutContent")
    data object Profile : NavigationItem("ProfileScreen")
}