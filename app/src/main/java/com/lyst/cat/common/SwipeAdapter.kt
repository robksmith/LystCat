package com.lyst.cat.common

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.lyst.cat.R
import com.lyst.cat.databinding.ObjectImagePagerItemBinding

class SwipeAdapter(var context: Context, var images: Array<String>) : PagerAdapter()
{
    private var layoutInflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    private lateinit var binding: ObjectImagePagerItemBinding

    override fun getCount(): Int
    {
        return images.size
    }

    override fun isViewFromObject(view: View, item: Any): Boolean
    {
        return view == item
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any
    {
        binding = ObjectImagePagerItemBinding.inflate(layoutInflater, container, false)
        Glide.with(context).load(images[position]).placeholder(R.drawable.vector_cat_placeholder).into(binding.imageviewMain)
        container.addView(binding.root)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, item: Any)
    {
        container.removeView(item as ConstraintLayout?)
    }
}