package com.kakaboc.roomdemo.dagger.modules

import com.kakaboc.roomdemo.activities.main.MainView
import dagger.Module
import dagger.Provides

@Module
class ViewModule(
        private val view: MainView
) {

    @Provides
    fun providesView(): MainView {
        return view
    }
}