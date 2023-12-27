package ru.handh.school.igor.ui.screen.profile

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ru.handh.school.igor.R
import ru.handh.school.igor.domain.usecase.result.ResultProfile
import ru.handh.school.igor.ui.navigation.NavigationItem
import ru.handh.school.igor.ui.theme.AppTheme

private var DefaultContainerHeight = 56.dp
private var fontSize = 24.sp

@Composable
fun ProfileScreen(
    vm: ProfileViewModel, context: Context, navController: NavHostController
) {
    val state by vm.state.collectAsState()
    //ProfileContent(state = state, navController = navController, onAction = vm::onAction)

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

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ProfileContent(
    //state: ProfileState, navController: NavHostController, onAction: (ProfileAction) -> Unit = {},
) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = stringResource(R.string.profile),
                    fontSize = fontSize,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth()
                )
            },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Filled.Info, contentDescription = null)
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            bottom = AppTheme.offsets.large,
                            start = AppTheme.offsets.medium,
                            end = AppTheme.offsets.medium
                        )
                        .height(DefaultContainerHeight),
                    content = { Text(text = stringResource(R.string.out)) },
                    shape = (AppTheme.roundings.large),
                    onClick = {
                        //onAction(ProfileAction.SubmitClicked)
                    })
            }
        }
    ) { containerPadding ->

        Column(
            modifier = Modifier
                .padding(AppTheme.offsets.medium)
                .padding(containerPadding)
        )
        {
/*            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = AppTheme.offsets.large)
                .height(DefaultContainerHeight),
                content = { Text(text = stringResource(R.string.about)) },
                shape = (AppTheme.roundings.large),
                onClick = {
                    //navController.navigate(NavigationItem.About.route)
                })*/

        }
    }
}
