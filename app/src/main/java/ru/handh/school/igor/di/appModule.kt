package ru.handh.school.igor.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.handh.school.igor.data.DeviceIdProvider
import ru.handh.school.igor.data.IgorRepositoryImp
import ru.handh.school.igor.data.KeyValueStorage
import ru.handh.school.igor.domain.usecase.GetProfileUseCase
import ru.handh.school.igor.domain.usecase.GetSessionUseCase
import ru.handh.school.igor.domain.usecase.SignInUseCase
import ru.handh.school.igor.domain.usecase.SignOutUseCase
import ru.handh.school.igor.ui.screen.profile.ProfileViewModel
import ru.handh.school.igor.ui.screen.signin.SignInViewModel

val appModule = module {
    single {
        KeyValueStorage(get())
    }
    single {
        DeviceIdProvider(get())
    }
    single {
        IgorRepositoryImp(get())
    }
    single {
        GetSessionUseCase(get(), get())
    }
    single {
        SignOutUseCase(get(), get())
    }
    single {
        SignInUseCase(get(), get())
    }
    single {
        GetProfileUseCase(get(), get())
    }
    viewModel {
        SignInViewModel(get(), get())
    }
    viewModel {
        ProfileViewModel(get())
    }
}