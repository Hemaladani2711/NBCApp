package com.hemaladani.nbcapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hemaladani.nbcapp.R
import com.hemaladani.nbcapp.databinding.FragmentHomeBinding
import com.hemaladani.nbcapp.utils.RecyclerViewSpaceItemDecoration


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var recyclerViewTrendingNow: RecyclerView
    private lateinit var recyclerViewLatestEpisodes: RecyclerView
    private lateinit var recyclerViewContinueWatching: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        recyclerViewTrendingNow = root.findViewById(R.id.recyclerview_trending_now)
        recyclerViewLatestEpisodes = root.findViewById(R.id.recyclerview_latest_episodes)
        recyclerViewContinueWatching = root.findViewById(R.id.recyclerview_continue_watching)

        recyclerViewTrendingNow.let{
            it.layoutManager=LinearLayoutManager(requireContext(), LinearLayoutManager
                .HORIZONTAL, false)
            it.setHasFixedSize(true)
            it.addItemDecoration(RecyclerViewSpaceItemDecoration(20))
        }
        recyclerViewLatestEpisodes.let{
            it.layoutManager=LinearLayoutManager(requireContext(), LinearLayoutManager
                .HORIZONTAL, false)
            it.setHasFixedSize(true)
            it.addItemDecoration(RecyclerViewSpaceItemDecoration(20))
        }
        recyclerViewContinueWatching.let{
            it.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager
                .HORIZONTAL, false)
            it.setHasFixedSize(true)
            it.addItemDecoration(RecyclerViewSpaceItemDecoration(20))
        }
        homeViewModel.getTrendingNowShelf().observe(viewLifecycleOwner) {
            it?.let {
                val trendingNowAdapter = TrendingNowAdapter(requireContext(), it)
                binding.recyclerviewTrendingNow.adapter = trendingNowAdapter
            }

        }
        homeViewModel.getLatestEpisodesShelf().observe(viewLifecycleOwner) {
            it?.let {
                val trendingNowAdapter = TrendingNowAdapter(requireContext(), it)
                binding.recyclerviewLatestEpisodes.adapter = trendingNowAdapter
            }
        }
        homeViewModel.getContinueWatchingShelf().observe(viewLifecycleOwner) {
            it?.let {
                val trendingNowAdapter = TrendingNowAdapter(requireContext(), it)
                binding.recyclerviewContinueWatching.adapter = trendingNowAdapter
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}