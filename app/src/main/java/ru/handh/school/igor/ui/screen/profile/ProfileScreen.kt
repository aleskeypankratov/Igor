package ru.handh.school.igor.ui.screen.profile

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import ru.handh.school.igor.domain.model.ProfileInfo

@Composable
fun ProfileScreen(
    vm: ProfileViewModel,
    navController: NavHostController,
    profileInfo: ProfileInfo
) {
    ProfileContent(
        navController = navController,
        profileInfo
    )
}


