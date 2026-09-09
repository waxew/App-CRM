package com.wcrm.feature.customer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class AddCustomerViewModel @Inject constructor(
) : ViewModel() {

    fun save(event: AddCustomerEvent) {
        viewModelScope.launch {
            // UseCase connection will be injected here.
        }
    }
}
