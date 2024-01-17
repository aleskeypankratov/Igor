package ru.handh.school.igor.ui.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.koin.androidx.compose.koinViewModel
import ru.handh.school.igor.ui.screen.about.AboutScreen
import ru.handh.school.igor.ui.screen.profile.ProfileScreen
import ru.handh.school.igor.ui.screen.project.ProjectDetailScreen
import ru.handh.school.igor.ui.screen.project.ProjectScreen
import ru.handh.school.igor.ui.screen.project.ProjectViewModel
import ru.handh.school.igor.ui.screen.signin.SignInScreen



@Composable
fun AppNavGraph(
    navController: NavHostController,
    startScreen: String,
    context: Context
) {
    NavHost(
        navController = navController, startDestination = startScreen, route = "root"
    ) {
        composable(route = NavigationItem.SignIn.route) {
            SignInScreen(
                vm = koinViewModel(),
                navController = navController,
                context = context
            )
        }
        composable(route = NavigationItem.About.route) {
            AboutScreen(
                navController = navController,
                context = context
            )
        }
        composable(route = NavigationItem.Profile.route) {
            ProfileScreen(
                vm = koinViewModel(),
                navController = navController,
            )
        }
        composable(route = NavigationItem.Project.route) {
            val viewModel = it.sharedViewModel<ProjectViewModel>(navController = navController)
            val state by viewModel.stateId.collectAsStateWithLifecycle()
            ProjectScreen(
                vm = viewModel,
                navController = navController,
                stateId = state
            )
        }
        composable(route = NavigationItem.ProjectDetail.route) {
            val viewModel = it.sharedViewModel<ProjectViewModel>(navController = navController)
            val state by viewModel.stateId.collectAsStateWithLifecycle()
            ProjectDetailScreen(
                vm = viewModel,
                navController = navController,
                stateId = state
            )
        }
    }
}

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(
    navController: NavController
): T {
    val navGraphRoute = destination.parent?.route ?: return koinViewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return koinViewModel(viewModelStoreOwner = parentEntry)
}