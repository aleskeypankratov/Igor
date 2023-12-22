package ru.handh.school.igor.ui.screen.signin

import android.content.Context
import android.widget.Toast
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.handh.school.igor.R
import ru.handh.school.igor.domain.usecase.Result
import ru.handh.school.igor.ui.components.AppButton
import ru.handh.school.igor.ui.components.AppTextField
import ru.handh.school.igor.ui.navigation.NavigationItem
import ru.handh.school.igor.ui.theme.AppTheme

private val mediumHeight = 24.dp
private val maxSize = 70.dp
private val minSize = 0.dp
private val minWeight = 0.25f
private val maxWeight = 1f

@Composable
fun SignInScreen(
    vm: SignInViewModel, context: Context, navController: NavHostController
) {
    val state by vm.state.collectAsState()
    var isShowAddField by remember { mutableStateOf(false) }

    SignInContent(
        state = state,
        onAction = vm::onAction,
        isShowAddField = isShowAddField,
        navController = navController
    )

    LaunchedEffect(state.result) {
        when (state.result) {
            is Result.LoggedIn -> {
                Toast.makeText(
                    context, "Email's sent", Toast.LENGTH_LONG
                ).show()
                isShowAddField = true
            }

            is Result.GotSession -> {
                navController.navigate(NavigationItem.Profile.route)
            }

            is Result.UnknownError -> {
                Toast.makeText(
                    context, "Error's occurred", Toast.LENGTH_LONG
                ).show()
            }

            is Result.Default -> {
                state.code = ""
                state.email = ""
                isShowAddField = false
            }
        }
    }
}

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

