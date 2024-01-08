package ru.handh.school.igor.ui.navigation

sealed class NavigationItem(
    val route: String
) {
    data object SignIn : NavigationItem("SignIn")
    data object About : NavigationItem("About")
    data object Profile : NavigationItem("Profile")
    data object Project : NavigationItem("Project")
}