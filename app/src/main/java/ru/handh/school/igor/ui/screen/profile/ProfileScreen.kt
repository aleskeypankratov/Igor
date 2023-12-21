package ru.handh.school.igor.ui.screen.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ru.handh.school.igor.R
import ru.handh.school.igor.ui.screen.NavigationItem
import ru.handh.school.igor.ui.theme.AppTheme

private var DefaultContainerHeight = 56.dp
private var fontSize = 100.sp

@Composable
fun ProfileScreen(
    onAction: (ProfileAction) -> Unit = {},
    navController: NavHostController
) {
    Column(modifier = Modifier.padding((AppTheme.offsets.medium))) {
        Text(
            text = "Profile", fontSize = fontSize, modifier = Modifier.weight(1f)
        )
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = AppTheme.offsets.large)
            .height(DefaultContainerHeight),
            content = { Text(text = "О приложении") },
            shape = (AppTheme.roundings.large),
            onClick = {
                navController.navigate(NavigationItem.About.route)
            })
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = AppTheme.offsets.large)
            .height(DefaultContainerHeight),
            content = { Text(text = stringResource(R.string.out)) },
            shape = (AppTheme.roundings.large),
            onClick = {
                onAction(ProfileAction.SubmitClicked)
                navController.navigate(NavigationItem.SignIn.route)
            })
    }
}