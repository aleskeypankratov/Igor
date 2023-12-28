package ru.handh.school.igor.ui.screen.signin

import androidx.compose.foundation.background
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
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.handh.school.igor.R
import ru.handh.school.igor.ui.components.AppButton
import ru.handh.school.igor.ui.components.AppTextField
import ru.handh.school.igor.ui.theme.AppTheme

private val mediumHeight = 24.dp
private val maxSize = 72.dp
private val minSize = 0.dp
private val minWeight = 0.25f
private val maxWeight = 1f
@Composable
fun SignInContent(
    state: SignInState,
    onAction: (SignInViewAction) -> Unit = {},
    isShowAddField: Boolean = false,
) {
    Scaffold { containerPadding ->
        Box(modifier = Modifier.background(AppTheme.colors.background)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(containerPadding)
                    .padding(AppTheme.offsets.medium)
            ) {
                Spacer(modifier = Modifier.weight(minWeight))
                Column(modifier = Modifier.weight(maxWeight)) {
                    BasicText(
                        text = stringResource(R.string.enter),
                        style = AppTheme.textStyles.maxMediumText
                    )
                    Spacer(
                        modifier = Modifier
                            .height(mediumHeight)
                            .background(AppTheme.colors.textOnControl)
                    )
                    AppTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
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
                    AppButton(modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = AppTheme.offsets.large),
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
    SignInContent(
        state = InitialSignInState, isShowAddField = true
    )
}
