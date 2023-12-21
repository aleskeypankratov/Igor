package ru.handh.school.igor.ui.screen.signin

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.handh.school.igor.R
import ru.handh.school.igor.ui.components.AppButton
import ru.handh.school.igor.ui.components.AppTextField
import ru.handh.school.igor.ui.theme.AppTheme

private val mediumHeight = 24.dp
private val maxSize = 70.dp
private val minSize = 0.dp
private val minWeight = 0.25f
private val maxWeight = 1f

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInContent(
    state: SignInState,
    navController: NavHostController,
    onAction: (SignInViewAction) -> Unit = {},
    isShowAddField: Boolean = false,
) {
    Scaffold { containerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(minWeight)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(maxWeight)
                    .padding(containerPadding)
                    .padding(AppTheme.offsets.medium)
            ) {
                Column {
                    BasicText(
                        text = stringResource(R.string.enter),
                        style = AppTheme.textStyles.maxMediumText
                    )
                    Spacer(modifier = Modifier.height(mediumHeight))
                    AppTextField(
                        modifier = Modifier.fillMaxWidth(),
                        onValueChange = { newEmail -> onAction(SignInViewAction.UpdateEmail(newEmail)) },
                        hint = stringResource(R.string.email),
                        value = state.email,
                    )
                    AppTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height((if (isShowAddField) maxSize else minSize))
                            .padding(top = AppTheme.offsets.medium),
                        onValueChange = { newCode -> onAction(SignInViewAction.AddCode(newCode)) },
                        value = state.code,
                        hint = stringResource(R.string.enter_code)
                    )
                    Spacer(modifier = Modifier.height(mediumHeight))
                    AppButton(modifier = Modifier.fillMaxWidth(),
                        label = stringResource(R.string.button_enter),
                        loading = state.signInLoading,
                        enabled = true,
                        onClick = {
                            onAction(SignInViewAction.SubmitClicked)
                        })
                }
            }
        }
    }
}

@Preview
@Composable
private fun SignInContentPreview() {
}