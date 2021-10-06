package com.vchichvarin.cloudnotesbsc.domain.di

import com.vchichvarin.cloudnotesbsc.domain.di.modules.DispatchersModule
import com.vchichvarin.cloudnotesbsc.domain.di.modules.RepositoriesModule
import com.vchichvarin.cloudnotesbsc.domain.di.modules.ViewModelModule
import com.vchichvarin.cloudnotesbsc.ui.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    DispatchersModule::class,
    RepositoriesModule::class,
    ViewModelModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)

}