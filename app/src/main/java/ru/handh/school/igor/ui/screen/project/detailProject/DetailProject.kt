package ru.handh.school.igor.ui.screen.project.detailProject

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import ru.handh.school.igor.ui.screen.project.SingleTask
import ru.handh.school.igor.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailProject(name: String, description: String) {
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(
                text = name,
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
                Text(text = description, maxLines = 2, overflow = TextOverflow.Ellipsis)
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
    DetailProject("Проект 1", "Многие думают, что Lorem Ipsum - взятый с потолка псевдо-латинский набор слов, но это не совсем так. Его корни уходят в один фрагмент классической латыни 45 года н.э., то есть более двух тысячелетий назад. Ричард МакКлинток, профессор латыни из колледжа Hampden-Sydney, штат Вирджиния, взял одно из самых странных слов в Lorem Ipsum, \"consectetur\", и занялся его поисками в классической латинской литературе. В результате он нашёл неоспоримый первоисточник Lorem Ipsum в разделах 1.10.32 и 1.10.33 книги \"de Finibus Bonorum et Malorum\"")
}