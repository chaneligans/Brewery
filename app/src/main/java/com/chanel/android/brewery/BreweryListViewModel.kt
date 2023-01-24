package com.chanel.android.brewery

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chanel.android.brewery.model.Brewery
import com.chanel.android.brewery.network.RetrofitInstance
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

private const val TAG = "BreweryListViewModel"

class BreweryListViewModel: ViewModel() {

    private var _breweries = MutableLiveData<List<Brewery>>()
    val breweries: LiveData<List<Brewery>>
        get() = _breweries

    private val disposables = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    fun getBreweries() {
        RetrofitInstance.breweryAPI.getBreweries()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = { response ->
                    _breweries.postValue(response)
                },
                onError = { error ->
                    Log.d(TAG, "Error getting breweries: ${error.message}")
                }
            )
            .addTo(disposables)
    }

}