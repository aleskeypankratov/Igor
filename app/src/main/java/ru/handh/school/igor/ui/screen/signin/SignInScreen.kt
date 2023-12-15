package ru.handh.school.igor.ui.screen.signin

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.handh.school.igor.R
import ru.handh.school.igor.domain.usecase.Result
import ru.handh.school.igor.ui.components.AppButton
import ru.handh.school.igor.ui.components.AppTextField
import ru.handh.school.igor.ui.screen.about.AboutContent
import ru.handh.school.igor.ui.theme.AppTheme

private val mediumHeight = 24.dp
private const val weightOfBox = 0.7f

@Composable
fun SignInScreen(
    vm: SignInViewModel
) {
    val state by vm.state.collectAsState()
    val context = LocalContext.current
    var showAddField by remember { mutableStateOf(false) }

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationItem.SignIn.route) {
        composable(route = NavigationItem.SignIn.route) {
            SignInContent(
                state = state, onAction = vm::onAction, showAddField = showAddField
            )
        }
        composable(route = NavigationItem.About.route) {
            AboutContent()
        }
    }

    LaunchedEffect(vm, context) {
        vm.logResult.collect { result ->
            when (result) {
                is Result.LoggedIn -> {
                    Toast.makeText(
                        context, "Email's sent", Toast.LENGTH_LONG
                    ).show()
                    showAddField = true
                }
                is Result.GotSession -> {
                    Toast.makeText(
                        context, "You're loggedIn", Toast.LENGTH_LONG
                    ).show()
                    navController.navigate(NavigationItem.About.route)
                }
                is Result.UnknownError -> {
                    Toast.makeText(
                        context, "Error's occurred", Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SignInContent(
    state: SignInState,
    onAction: (SignInViewAction) -> Unit = {},
    showAddField: Boolean = false,
) {
    Scaffold { containerPadding ->
        Box(
            modifier = Modifier
                .fillMaxHeight(weightOfBox)
                .padding(containerPadding)
                .verticalScroll(rememberScrollState())
                .padding(AppTheme.offsets.medium),
            contentAlignment = Alignment.Center
        ) {
            Column {
                BasicText(
                    text = stringResource(R.string.enter), style = AppTheme.textStyles.maxMediumText
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
                        .height((if (showAddField) 68.dp else 0.dp))
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

@Preview
@Composable
private fun SignInContentPreview() {
    SignInContent(
        state = InitialSignInState, showAddField = true
    )
}
