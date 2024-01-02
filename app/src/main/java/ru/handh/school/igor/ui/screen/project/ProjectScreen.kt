package ru.handh.school.igor.ui.screen.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.handh.school.igor.R
import ru.handh.school.igor.domain.usecase.result.ResultProject
import ru.handh.school.igor.ui.navigation.NavigationItem
import ru.handh.school.igor.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectContent(
    navController: NavHostController, vm: ProjectViewModel
) {
    val state by vm.state.collectAsState()

    Scaffold(topBar = {
        TopAppBar(title = {
            Text(
                text = stringResource(R.string.projects),
                style = AppTheme.textStyles.titleText,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = AppTheme.offsets.large)
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )
        }, actions = {
            IconButton(onClick = {
                navController.navigate(NavigationItem.Profile.route)
            }) {
                Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = null)
            }
        })
    }) { containerPadding ->
        Column(
            modifier = Modifier
                .padding(containerPadding)
                .fillMaxSize()
                .background(AppTheme.colors.background)
        ) {}
        when (state.result) {
            is ResultProject.Default -> {
                CircularProgressIndicator(
                    modifier = Modifier.size(48.dp),
                    color = AppTheme.colors.textOnControl,
                    strokeWidth = 48.dp
                )
            }
            is ResultProject.GotProject -> {
                repeat(5) {
                    SingleProject(name = "as", text = "ff", modifier = Modifier.padding(16.dp))
                }
            }
            is ResultProject.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.size(48.dp),
                    color = AppTheme.colors.textOnControl,
                    strokeWidth = 48.dp
                )
            }
            is ResultProject.ServerError -> TODO()
            is ResultProject.UnknownError -> TODO()
        }

    }
}

