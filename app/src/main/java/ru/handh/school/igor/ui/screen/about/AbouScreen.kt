package ru.handh.school.igor.ui.screen.about

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.handh.school.igor.R
import ru.handh.school.igor.ui.theme.AppTheme

@Preview
@Composable
fun AboutContent() {
    Column {
        Text(
            text = stringResource(R.string.about),
            modifier = Modifier.padding(16.dp),
            style = AppTheme.textStyles.textEnter
        )
        Box(
            modifier = Modifier
                .background(AppTheme.colors.background)
                .alpha(0.5f)
        ) {
            Icon(
                modifier = Modifier.size(48.dp),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null
            )
            Text(text = "Версия 1.13")
            Text(text = "Номер сборки 42")
        }
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(AppTheme.colors.button),
            onClick = { /*TODO*/ }) {
        }
    }
}

@Preview
@Composable
fun preview() {
    AboutContent()
}