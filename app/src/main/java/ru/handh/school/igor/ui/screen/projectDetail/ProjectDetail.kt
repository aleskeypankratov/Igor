package ru.handh.school.igor.ui.screen.projectDetail

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import ru.handh.school.igor.ui.screen.project.ProjectViewModel
import ru.handh.school.igor.ui.theme.AppTheme

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectDetailScreen(
    vm: ProjectViewModel
) {
    val state by vm.state.collectAsState()

    Scaffold(topBar = {
        TopAppBar(title = {
            Text(
                text = state.projects.toString(),
                style = AppTheme.textStyles.titleText,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth()
                    .padding(end = AppTheme.offsets.big)
            )
        }, navigationIcon = {
            IconButton(onClick = {
                //navController.popBackStack()
            }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
            }
        })
    }) { containerPadding ->
        Column(
            modifier = Modifier
                .padding(containerPadding)
                .fillMaxSize()
                .background(AppTheme.colors.background)
                .padding(AppTheme.offsets.medium)
        ) {
            Column {
                Text(text = state.projects.toString(), maxLines = 2, overflow = TextOverflow.Ellipsis)
                SingleTask(name = "Создать проект", priority = "2")
                SingleTask(name = "Создать проект", priority = "1")
                SingleTask(name = "Создать проект", priority = "3")
            }
        }
    }
}

@Preview
@Composable
fun PreviewDetailProject() {
    //ProjectDetailScreen()
}