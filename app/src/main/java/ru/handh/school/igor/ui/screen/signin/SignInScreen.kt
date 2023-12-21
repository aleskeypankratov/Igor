package ru.handh.school.igor.ui.screen.signin

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import ru.handh.school.igor.domain.usecase.Result
import ru.handh.school.igor.ui.screen.NavigationItem


@Composable
fun SignInScreen(
    vm: SignInViewModel,
    context: Context,
    navController: NavHostController
) {
    val state by vm.state.collectAsState()
    var isShowAddField by remember { mutableStateOf(false) }

    SignInContent(
        state = state, onAction = vm::onAction, isShowAddField = isShowAddField,
        navController = navController
    )

    LaunchedEffect(state.result) {
        when (state.result) {
            is Result.LoggedIn -> {
                Toast.makeText(
                    context, "Email's sent", Toast.LENGTH_LONG
                ).show()
                isShowAddField = true
            }

            is Result.GotSession -> {
                navController.navigate(NavigationItem.Profile.route)
            }

            is Result.UnknownError -> {
                Toast.makeText(
                    context, "Error's occurred", Toast.LENGTH_LONG
                ).show()
            }

            is Result.Default -> {
                state.code = ""
                state.email = ""
                isShowAddField = false
            }
        }
    }
}

