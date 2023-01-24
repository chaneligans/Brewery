package com.chanel.android.brewery

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.chanel.android.brewery.databinding.FragmentBreweryListBinding

/**
 * Fragment which shows the list of Breweries
 */
class BreweryListFragment : Fragment() {

    private var _binding: FragmentBreweryListBinding? = null
    val binding
        get() = checkNotNull(_binding) {
            "Cannot access FragmentBreweryListBinding because it is null. Is the view visible?"
        }

    private val viewModel: BreweryListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBreweryListBinding.inflate(inflater, container, false)
        binding.breweryListRecyclerView.layoutManager = LinearLayoutManager(context)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getBreweries()

        viewModel.breweries.observe(viewLifecycleOwner) { breweries ->
            binding.breweryListRecyclerView.adapter = BreweryListAdapter(breweries)
            Log.d("chanelz", "got brewerires ${breweries}")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}