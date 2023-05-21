package com.ironmeddieapps.currencylist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ironmeddieapps.domain.usecase.GetCurrency
import com.ironmeddieapps.models.Currency
import com.ironmeddieapps.utils.DataResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val getCurrencyRepository: GetCurrency): ViewModel() {

    private val _list = MutableStateFlow<DataResource<Currency>>(DataResource.Loading)
    val list = _list.asStateFlow()

    init {
        load()
    }

    fun load(){
        getCurrencyRepository().onEach { data->
            _list.value = data
        }.launchIn(viewModelScope)
    }
}

