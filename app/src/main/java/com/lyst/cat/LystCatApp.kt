package com.lyst.cat

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class LystCatApp @Inject constructor() : Application()
{
    override fun onCreate()
    {
        super.onCreate()
    }
}