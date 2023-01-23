package com.chanel.android.brewery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.chanel.android.brewery.databinding.FragmentBreweryListBinding

/**
 * Fragment which shows the list of Breweries
 */
class BreweryListFragment : Fragment() {

    private var _binding: FragmentBreweryListBinding? = null
    val binding: FragmentBreweryListBinding
        get() = checkNotNull(_binding) {
            "Cannot access FragmentBreweryListBinding because it is null. Is the view visible?"
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBreweryListBinding.inflate(inflater)
        binding.breweryListRecyclerView.layoutManager = LinearLayoutManager(context)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}