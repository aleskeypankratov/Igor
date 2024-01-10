package ru.handh.school.igor.ui.screen.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.handh.school.igor.R
import ru.handh.school.igor.domain.usecase.result.ResultProject
import ru.handh.school.igor.ui.navigation.NavigationItem
import ru.handh.school.igor.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun ProjectScreen(
    navController: NavHostController,
    vm: ProjectViewModel,
) {
    val state by vm.state.collectAsState()
    val isRefreshing by remember { mutableStateOf(false) }
    val swipeRefreshState = rememberPullRefreshState(
        isRefreshing,
        onRefresh = { vm.onAction(ProjectViewAction.GetProject) })

    LaunchedEffect(Unit) {
        vm.onAction(ProjectViewAction.GetProject)
    }

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
        Box(
            modifier = Modifier
                .pullRefresh(swipeRefreshState)
                .fillMaxSize()
                .padding(containerPadding)
                .background(AppTheme.colors.background)
        ) {
            when (state.result) {
                is ResultProject.Default -> {
                }

                is ResultProject.GotProject -> {
                    LazyColumn {
                        item(1) {
                            SingleProject(
                                modifier = Modifier.padding(AppTheme.offsets.medium),
                                name = "Проект",
                                text = "Измерить длину"
                            )
                        }
                    }
                }

                is ResultProject.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center).size(48.dp),
                        color = Color.Blue,
                    )
                }

                is ResultProject.ServerError ->
                    ProjectError(
                        error = (state.result as ResultProject.ServerError).toString()
                    )

                else -> {}
            }
            PullRefreshIndicator(
                isRefreshing, swipeRefreshState, modifier = Modifier
                    .align(
                        Alignment.TopCenter
                    )
            )
        }
    }
}

