package ru.handh.school.igor.ui.screen.profile

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ru.handh.school.igor.R
import ru.handh.school.igor.domain.usecase.result.ResultProfile
import ru.handh.school.igor.ui.navigation.NavigationItem
import ru.handh.school.igor.ui.theme.AppTheme

private var DefaultContainerHeight = 56.dp
private var fontSize = 100.sp

@Composable
fun ProfileScreen(
    vm: ProfileViewModel, context: Context, navController: NavHostController
) {
    val state by vm.state.collectAsState()
    ProfileContent(state = state, navController = navController, onAction = vm::onAction)

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

@Composable
fun ProfileContent(
    state: ProfileState, navController: NavHostController, onAction: (ProfileAction) -> Unit = {},
) {
    Column(modifier = Modifier.padding((AppTheme.offsets.medium))) {
        Text(
            text = "Profile", fontSize = fontSize, modifier = Modifier.weight(1f)
        )
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = AppTheme.offsets.large)
            .height(DefaultContainerHeight),
            content = { Text(text = stringResource(R.string.about)) },
            shape = (AppTheme.roundings.large),
            onClick = {
                navController.navigate(NavigationItem.About.route)
            })
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = AppTheme.offsets.large)
                .height(DefaultContainerHeight),
            content = { Text(text = stringResource(R.string.out)) },
            shape = (AppTheme.roundings.large),
            onClick = {
                onAction(ProfileAction.SubmitClicked)
            })
    }
}
