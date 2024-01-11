package ru.handh.school.igor.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    startScreen: String,
    navController: NavHostController,
    content: ComposableContent
) {
    NavHost(
        navController = navController, startDestination = startScreen
    ) {
        composable(route = NavigationItem.SignIn.route) {
            content.signInContent()
        }
        composable(route = NavigationItem.About.route) {
            content.aboutContent()
        }
        composable(route = NavigationItem.Profile.route) {
            content.profileContent()
        }
        composable(route = NavigationItem.Project.route) {
            content.projectContent()
        }
        composable(route = NavigationItem.ProjectDetail.route) {
            content.projectDetail()
        }
    }
}

data class ComposableContent(
    val signInContent: @Composable () -> Unit,
    val aboutContent: @Composable () -> Unit,
    val projectContent: @Composable () -> Unit,
    val profileContent: @Composable () -> Unit,
    val projectDetail: @Composable () -> Unit
)