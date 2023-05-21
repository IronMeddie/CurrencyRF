package com.ironmeddieapps.main_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ironmeddieapps.domain.usecase.GetFavoriteValutes
import com.ironmeddieapps.models.Currency
import com.ironmeddieapps.utils.DataResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(private val getFavoriteValutes: GetFavoriteValutes): ViewModel() {

    private val _list = MutableStateFlow<DataResource<Currency>>(DataResource.Loading)
    val list = _list.asStateFlow()

    init {
        getList()
    }

    fun getList(){
        getFavoriteValutes().onEach {
            _list.value = it
        }.launchIn(viewModelScope)
    }


}