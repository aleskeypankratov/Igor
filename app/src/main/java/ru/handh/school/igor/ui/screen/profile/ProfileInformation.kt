package ru.handh.school.igor.ui.screen.profile

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.handh.school.igor.domain.model.db.ProfileInfo
import ru.handh.school.igor.ui.theme.AppTheme

val defalutSizeImage = 55.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfileInformation(
    profileInfo: ProfileInfo
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .padding(AppTheme.offsets.small)
                .clip(CircleShape)
                .size(defalutSizeImage)
                .background(AppTheme.colors.projectDescription)
        )
        Column {
            Text(
                text = requireNotNull(profileInfo.surname),
                style = AppTheme.textStyles.maxMediumText,
                maxLines = 1,
                modifier = Modifier.basicMarquee()
            )
            Text(
                text = requireNotNull(profileInfo.name),
                style = AppTheme.textStyles.normalRegularText,
            )
        }
    }
}

@Preview
@Composable
fun Preview() {
    ProfileInformation(ProfileInfo(surname = "Смирнов-Милованов", name = "Андрей"))
}