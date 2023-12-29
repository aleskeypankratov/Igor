package ru.handh.school.igor.ui.screen.profile

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import ru.handh.school.igor.domain.model.ProfileInfo

@Composable
fun ProfileScreen(
    vm: ProfileViewModel,
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
}


