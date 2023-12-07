package ru.handh.school.igor.ui.screen.signin

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    Scaffold { containerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(containerPadding)
                .padding(AppTheme.offsets.medium), contentAlignment = Alignment.Center
        ) {

            Column {
                BasicText(text = "Вход", style = AppTheme.textStyles.textEnter)
                Spacer(modifier = Modifier.height(30.dp))
                AppTextField("Электронная почта", modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(30.dp))
                AppButton(modifier = Modifier.fillMaxWidth(),
                    label = "Войти",
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
