package com.lyst.cat.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyst.cat.databinding.ActivityCatDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatDetailActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityCatDetailBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = ActivityCatDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}