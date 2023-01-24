package com.chanel.android.brewery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chanel.android.brewery.databinding.BreweryItemBinding
import com.chanel.android.brewery.model.Brewery

class BreweryListAdapter(
    private val breweries: List<Brewery>
) : RecyclerView.Adapter<BreweryHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreweryHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = BreweryItemBinding.inflate(inflater, parent, false)
        return BreweryHolder(binding)
    }

    override fun onBindViewHolder(holder: BreweryHolder, position: Int) {
        val brewery = breweries[position]
        holder.bind(brewery)
    }

    override fun getItemCount(): Int {
        return breweries.size
    }

}