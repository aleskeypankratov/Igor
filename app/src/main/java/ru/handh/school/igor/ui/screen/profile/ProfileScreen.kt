package ru.handh.school.igor.ui.screen.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.handh.school.igor.R
import ru.handh.school.igor.ui.theme.AppTheme

private var DefaultContainerHeight = 56.dp

@Composable
fun ProfileScreen() {
    Column {
        Text(text = "Profile",  fontSize = 100.sp)
        Box(
            Modifier
                .padding(AppTheme.offsets.medium)
                .align(Alignment.End)
                .padding(bottom = 24.dp)
        ) {
            Button(modifier = Modifier
                .fillMaxWidth()
                .height(DefaultContainerHeight),
                content = { Text(text = stringResource(R.string.out)) },
                shape = (AppTheme.roundings.large),
                onClick = { })
        }
    }
}