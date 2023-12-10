package ru.handh.school.igor.ui.screen.signin

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.handh.school.igor.R
import ru.handh.school.igor.ui.components.AppButton
import ru.handh.school.igor.ui.components.AppTextField
import ru.handh.school.igor.ui.theme.AppTheme

@Composable
fun SignInScreen(
    vm: SignInViewModel
) {
    val state by vm.state.collectAsState()
    SignInContent(
        state = state, onAction = vm::onAction
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable


private fun SignInContent(

    state: SignInState, onAction: (SignInViewAction) -> Unit = {}
) {

    var email by remember { mutableStateOf(String()) }

    Scaffold { containerPadding ->
        Box(
            modifier = Modifier
                .fillMaxHeight(0.7f)
                .padding(containerPadding)
                .padding(AppTheme.offsets.medium), contentAlignment = Alignment.Center
        ) {
            Column {
                BasicText(
                    text = stringResource(R.string.enter), style = AppTheme.textStyles.textEnter
                )
                Spacer(modifier = Modifier.height(24.dp))
                AppTextField(
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = { email = it },
                    hint = stringResource(R.string.email),
                    value = email,
                )
                Spacer(modifier = Modifier.height(24.dp))
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

@Preview
@Composable
private fun SignInContentPreview() {
    SignInContent(
        state = InitialSignInState
    )
}