package com.lyst.cat.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.lyst.cat.common.SwipeAdapter
import com.lyst.cat.databinding.FragmentCatdetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatDetailFragment : Fragment()
{
    private var catId: String? = null
    private lateinit var vm: CatDetailViewModel
    private lateinit var binding: FragmentCatdetailBinding
    lateinit var pagerAdapter: SwipeAdapter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        vm = ViewModelProvider(this).get(CatDetailViewModel::class.java)

        vm.state.observe(this, Observer(::observeObject))

        catId = activity?.intent?.extras?.getString("catid")

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {
        binding = FragmentCatdetailBinding.inflate(inflater, container, false)
        val root = binding.root
        return root
    }

    override fun onStart() {
        super.onStart()
        catId?.let { vm.getCatDetail(it) }
    }

    private fun observeObject(catDetail: CatDetailState?) {
        when (catDetail?.status)
        {
            0 ->
            {
                // I have time restrictions developing this demo....show a loading spinner here
                // but for this demo ...nothing
            }
            1 ->
            {
                // Setup a view pager with cat images in it
                initImagePagerView(catDetail.urls)

                binding.textviewCatName.text = catDetail.cat?.name
                binding.textviewCatDetails.text = catDetail.cat?.description
                binding.textviewCat1.progress = catDetail.cat?.child_friendly?.times(20) ?: 0
                binding.textviewCat2.progress = catDetail.cat?.energy_level?.times(20) ?: 0
            }
            2 ->
            {
                // I have time restrictions developing this demo....show an error - auto retry or manual retry etc

                //for now, just close
                activity?.finish()
            }
        }
    }

    // Note - I was trying to pass this a list of cat url images to display in a viewpager but got bogged down with the api call - so just one image will do for now
    private fun initImagePagerView(imagesArray: List<String>)
    {
        if ( imagesArray.isEmpty() ) return
        val typed = imagesArray.toTypedArray()
        pagerAdapter = SwipeAdapter(requireContext(), typed)

        binding.textviewCatCount.text = "1 of ${imagesArray.count()}"
        binding.viewPager.adapter = pagerAdapter
        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener
        {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int)
            {
            }

            override fun onPageSelected(position: Int)
            {
                binding.textviewCatCount.text = "${(position + 1)} of ${imagesArray.count()}"
            }

            override fun onPageScrollStateChanged(state: Int)
            {
            }
        })
    }
}