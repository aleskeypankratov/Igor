package ru.handh.school.igor.ui.screen.project

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import ru.handh.school.igor.ui.theme.AppTheme

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectDetailScreen(
    vm: ProjectViewModel,
    navController:NavHostController,
    stateId: String
) {

    LaunchedEffect(Unit) {
        vm.onAction(ProjectViewAction.GetDetailProject(stateId))
    }

    Scaffold(topBar = {
        TopAppBar(title = {
            Text(
                text = requireNotNull(vm.state.value.detailProject.name),
                style = AppTheme.textStyles.titleText,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth()
                    .padding(end = AppTheme.offsets.big)
            )
        }, navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
            }
        })
    }) { containerPadding ->
        Column(
            modifier = Modifier
                .padding(containerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .background(AppTheme.colors.background)
                .padding(AppTheme.offsets.medium)
        ) {
            Column {
                Text(text = requireNotNull(vm.state.value.detailProject.description))
            }
        }
    }
}
