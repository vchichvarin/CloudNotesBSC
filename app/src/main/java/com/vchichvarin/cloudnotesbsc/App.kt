package com.vchichvarin.cloudnotesbsc

import android.app.Application
import com.vchichvarin.cloudnotesbsc.domain.di.AppComponent
import com.vchichvarin.cloudnotesbsc.domain.di.DaggerAppComponent

class App : Application() {
   override fun onCreate() {
       super.onCreate()
       appComponent = DaggerAppComponent
           .builder()
           .build()
   }

   companion object{
       lateinit var appComponent: AppComponent
   }
}