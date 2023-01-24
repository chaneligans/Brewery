package com.chanel.android.brewery

import androidx.recyclerview.widget.RecyclerView
import com.chanel.android.brewery.databinding.BreweryItemBinding
import com.chanel.android.brewery.model.Brewery

class BreweryHolder(
    private val binding: BreweryItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(brewery: Brewery) {
        binding.name.text = brewery.name
        binding.address.text = getFormattedAddressText(brewery)
        binding.phone.text = brewery.phone
        binding.website.text = brewery.website_url
    }

    private fun getFormattedAddressText(brewery: Brewery) : String {
        return "${brewery.street} ${brewery.address_2} ${brewery.address_3}" +
                "\n${brewery.city}, ${brewery.state}" +
                "\n${brewery.country}"
    }

}