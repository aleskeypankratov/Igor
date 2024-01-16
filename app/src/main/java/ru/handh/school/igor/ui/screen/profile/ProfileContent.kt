package ru.handh.school.igor.ui.screen.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.handh.school.igor.R
import ru.handh.school.igor.ui.navigation.NavigationItem
import ru.handh.school.igor.ui.theme.AppTheme

private var DefaultContainerHeight = 56.dp

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileContent(
    navController: NavHostController,
    vm: ProfileViewModel
) {
    val state by vm.state.collectAsState()

    LaunchedEffect(Unit) {
        vm.onAction(ProfileViewAction.GetProfile)
    }

    Scaffold(topBar = {
        TopAppBar(title = {
            Text(
                text = stringResource(R.string.profile),
                style = AppTheme.textStyles.titleText,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth()
            )
        }, navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null
                )
            }
        }, actions = {
            IconButton(onClick = {
                navController.navigate(NavigationItem.About.route)
            }) {
                Icon(
                    imageVector = Icons.Filled.Info,
                    contentDescription = null
                )
            }
        })
    }, bottomBar = {
        BottomAppBar(
            containerColor = AppTheme.colors.background
        ) {
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(
                    bottom = AppTheme.offsets.large,
                    start = AppTheme.offsets.medium,
                    end = AppTheme.offsets.medium
                )
                .height(DefaultContainerHeight),
                content = { Text(text = stringResource(R.string.out)) },
                colors = ButtonDefaults.buttonColors(AppTheme.colors.button),
                shape = (AppTheme.roundings.large),
                onClick = {
                    vm.onAction(ProfileViewAction.ExitClicked)
                })
        }
    }) { containerPadding ->
        Column(
            modifier = Modifier
                .padding(containerPadding)
                .fillMaxSize()
                .background(AppTheme.colors.background)
        ) {
            ProfileInformation(
                state.profile
            )
        }
    }
}
