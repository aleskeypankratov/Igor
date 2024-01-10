package ru.handh.school.igor.ui.screen.profile

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun ProfileScreen(
    vm: ProfileViewModel,
    navController: NavHostController,
) {
    ProfileContent(
        navController = navController,
        vm = vm,
    )
}


