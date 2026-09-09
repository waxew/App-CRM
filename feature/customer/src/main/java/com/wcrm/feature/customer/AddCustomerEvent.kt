package com.wcrm.feature.customer

sealed interface AddCustomerEvent {
    data class NameChanged(val value: String) : AddCustomerEvent
    data class PhoneChanged(val value: String) : AddCustomerEvent
    data class EmailChanged(val value: String) : AddCustomerEvent
    data object SaveClicked : AddCustomerEvent
}
