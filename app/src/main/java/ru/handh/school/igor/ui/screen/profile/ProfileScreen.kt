package ru.handh.school.igor.ui.screen.profile

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import ru.handh.school.igor.domain.model.ProfileInfo
import ru.handh.school.igor.domain.usecase.result.ResultProfile
import ru.handh.school.igor.ui.navigation.NavigationItem



@Composable
fun ProfileScreen(
    vm: ProfileViewModel,
    context: Context,
    navController: NavHostController,
    profileInfo: ProfileInfo
) {
    val state by vm.state.collectAsState()
    ProfileContent(
        state = state,
        navController = navController,
        onAction = vm::onAction,
        profileInfo
    )

    LaunchedEffect(state.result) {
        when (state.result) {
            is ResultProfile.GotProfile -> {}
            is ResultProfile.Default -> {}
            is ResultProfile.RequestError -> {}
            is ResultProfile.ServerError -> {
                Toast.makeText(
                    context, "Server didn't respond", Toast.LENGTH_LONG
                ).show()
            }

            is ResultProfile.UnknownError -> {
                Toast.makeText(
                    context, "Error's occurred", Toast.LENGTH_LONG
                ).show()
            }

            is ResultProfile.LogOut -> {
                navController.navigate(NavigationItem.SignIn.route)
            }
        }
    }
}


