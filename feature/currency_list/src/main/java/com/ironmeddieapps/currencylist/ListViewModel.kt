package com.ironmeddieapps.currencylist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ironmeddieapps.analitics.Analitics
import com.ironmeddieapps.domain.usecase.DeleteValuteFromFavorites
import com.ironmeddieapps.domain.usecase.GetCurrency
import com.ironmeddieapps.domain.usecase.SaveValuteToFavorite
import com.ironmeddieapps.models.CurencyItem
import com.ironmeddieapps.models.Currency
import com.ironmeddieapps.utils.DataResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val getCurrency: GetCurrency, private val save: SaveValuteToFavorite): ViewModel() {

    private val _list = MutableStateFlow<DataResource<Currency>>(DataResource.Loading)
    val list = _list.asStateFlow()

    init {
        Analitics.reportListOpen()
        load()
    }

    fun load(){
        getCurrency().onEach { data->
            _list.value = data
            Analitics.reportDataLoaded()
        }.launchIn(viewModelScope)
    }

    fun saveValute(item: CurencyItem){
        CoroutineScope(Dispatchers.IO).launch {
            save(item)
        }
    }




}

