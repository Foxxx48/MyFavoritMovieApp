package com.fox.myfavoritmovieapp.presentation.dbitemfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.fox.myfavoritmovieapp.databinding.FragmentDbItemBinding
import com.fox.myfavoritmovieapp.domain.model.top.movie.TopItem
import com.fox.myfavoritmovieapp.presentation.main.MainActivity
import com.fox.myfavoritmovieapp.utils.GlideApp

private const val MOVIE_ITEM = "movie_item"

class DbItemFragment : Fragment() {

    private var _binding: FragmentDbItemBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("FragmentDbItemBinding = null")

    private var topItem: TopItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
           topItem = it.getParcelable(MOVIE_ITEM)
            MainActivity.myLog("Fragment onCreate $topItem")

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDbItemBinding.inflate(layoutInflater, container, false )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val urlImage = topItem?.posterUrl
        MainActivity.myLog(urlImage)
        GlideApp.with(requireContext())
            .load(urlImage)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
//            .placeholder(R.drawable.ic_action_point)
            .into(binding.ivPoster)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(topItem: TopItem) =
            DbItemFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(MOVIE_ITEM, topItem)
                }
            }
    }
}