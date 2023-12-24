package ru.handh.school.igor.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    startScreen: String,
    navController: NavHostController,
    signInContent: @Composable () -> Unit,
    aboutContent: @Composable () -> Unit,
    profileContent: @Composable () -> Unit
) {
    NavHost(
        navController = navController, startDestination = startScreen
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