package ru.handh.school.igor.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.handh.school.igor.domain.model.ProfileInfo
import ru.handh.school.igor.ui.theme.AppTheme

val defalutSizeImage = 55.dp

@Composable
fun ProfileInformation(
    inputInfo: ProfileInfo
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Image(
            modifier = Modifier
                .padding(AppTheme.offsets.small)
                .size(defalutSizeImage),
            painter = painterResource(id = inputInfo.avatar),
            contentDescription = null
        )
        Column {
            Text(
                text = inputInfo.surname,
                style = AppTheme.textStyles.maxMediumText,
            )
            Text(
                text = inputInfo.name,
                style = AppTheme.textStyles.normalRegularText,
            )
        }
    }
}

@Preview
@Composable
fun Preview() {
    ProfileInformation(ProfileInfo("Смирнов", "Андрей"))
}