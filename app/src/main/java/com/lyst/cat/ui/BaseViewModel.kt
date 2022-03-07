package com.lyst.cat.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

open class BaseViewModel(val app: Application) : AndroidViewModel(app)
{
}