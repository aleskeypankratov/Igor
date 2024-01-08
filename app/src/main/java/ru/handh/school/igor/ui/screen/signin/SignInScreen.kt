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
import ru.handh.school.igor.domain.usecase.result.ResultSignIn
import ru.handh.school.igor.ui.navigation.NavigationItem



@Composable
fun SignInScreen(
    vm: SignInViewModel, context: Context, navController: NavHostController
) {
    val state by vm.state.collectAsState()
    var isShowAddField by remember { mutableStateOf(false) }

    SignInContent(
        state = state,
        onAction = vm::onAction,
        isShowAddField = isShowAddField,
    )

    LaunchedEffect(state.result) {
        when (state.result) {
            is ResultSignIn.LoggedIn -> {
                Toast.makeText(
                    context, "Email's sent", Toast.LENGTH_LONG
                ).show()
                isShowAddField = true
            }

            is ResultSignIn.GotSession -> {
                navController.navigate(NavigationItem.Project.route) {
                    launchSingleTop = true
                }
            }

            is ResultSignIn.UnknownError -> {
                Toast.makeText(
                    context, "Error's occurred", Toast.LENGTH_LONG
                ).show()
            }

            is ResultSignIn.Default -> {
                state.code = ""
                state.email = ""
                isShowAddField = false
            }

            is ResultSignIn.InvalidEmail -> {
                Toast.makeText(
                    context, "Enter valid email", Toast.LENGTH_LONG
                ).show()
            }

            is ResultSignIn.ServerError -> {
                Toast.makeText(
                    context, "Server didn't respond", Toast.LENGTH_LONG
                ).show()
            }

            is ResultSignIn.InvalidCode -> {
                Toast.makeText(
                    context, "Enter valid code", Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}

