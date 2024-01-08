package ru.handh.school.igor.ui.screen.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.handh.school.igor.R
import ru.handh.school.igor.domain.usecase.result.ResultProject
import ru.handh.school.igor.ui.navigation.NavigationItem
import ru.handh.school.igor.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun ProjectContent(
    navController: NavHostController,
    vm: ProjectViewModel,
) {
    val state by vm.state.collectAsState()

    var isRefreshing by remember { mutableStateOf(false) }
    var swipeRefreshState = rememberPullRefreshState(isRefreshing,
        onRefresh = { vm.onAction(ProjectViewAction.ProjectClicked) })

    LaunchedEffect(Unit) {
        vm.onAction(ProjectViewAction.ProjectClicked)
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

        when (state.result) {
            is ResultProject.Default -> {
            }

            is ResultProject.GotProject -> {
                val projects = (state.result as ResultProject.GotProject)
                Box(modifier = Modifier.pullRefresh(swipeRefreshState)) {
                    LazyColumn(
                        modifier = Modifier
                            .padding(containerPadding)
                            .fillMaxSize()
                            .background(AppTheme.colors.background)
                    ) {
                        item(1) {
                            SingleProject(
                                modifier = Modifier.padding(AppTheme.offsets.medium),
                                name = "11111111",
                                text = "222222222"
                            )
                            SingleProject(
                                modifier = Modifier.padding(AppTheme.offsets.medium),
                                name = "11111111",
                                text = "222222222"
                            )
                            SingleProject(
                                modifier = Modifier.padding(AppTheme.offsets.medium),
                                name = "11111111",
                                text = "222222222"
                            )
                            SingleProject(
                                modifier = Modifier.padding(AppTheme.offsets.medium),
                                name = "11111111",
                                text = "222222222"
                            )
                        }
                    }
                    PullRefreshIndicator(
                        isRefreshing, swipeRefreshState, modifier = Modifier.align(
                            Alignment.TopCenter
                        )
                    )
                }
            }

            is ResultProject.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier, color = AppTheme.colors.textOnControl, strokeWidth = 48.dp
                )
            }

            is ResultProject.ServerError -> ProjectError(error = (state.result as ResultProject.ServerError).toString())
            else -> {}
        }
    }
}

