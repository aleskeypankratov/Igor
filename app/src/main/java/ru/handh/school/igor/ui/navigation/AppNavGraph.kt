package ru.handh.school.igor.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    navController: NavHostController,
    signInContent: @Composable () -> Unit,
    aboutContent: @Composable () -> Unit,
    profileContent: @Composable () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = NavigationItem.SignIn.route
    ) {
        composable(route = NavigationItem.SignIn.route) {
            signInContent()
        }
        composable(route = NavigationItem.About.route) {
            aboutContent()
        }
        composable(route = NavigationItem.Profile.route) {
            profileContent()
        }
    }
}