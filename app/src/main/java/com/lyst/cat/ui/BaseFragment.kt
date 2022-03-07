package com.lyst.cat.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.disposables.CompositeDisposable

@AndroidEntryPoint
abstract class BaseFragment : Fragment()
{
    // for rx - not used on cats
    val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart()
    {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
        compositeDisposable.clear()
    }
}