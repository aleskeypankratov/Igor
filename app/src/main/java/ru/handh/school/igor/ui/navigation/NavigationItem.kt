package ru.handh.school.igor.ui.navigation

sealed class NavigationItem(
    val route: String
) {
    data object SignIn : NavigationItem("SignInScreen")
    data object About : NavigationItem("AboutScreen")
    data object Profile : NavigationItem("ProfileContent")
    data object Project : NavigationItem("ProjectScreen")
    data object ProjectDetail : NavigationItem("ProjectDetail")
}