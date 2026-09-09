package com.wcrm.feature.customer

object CustomerValidation {
    fun isValidName(name: String): Boolean {
        return name.trim().isNotEmpty()
    }

    fun isValidPhone(phone: String): Boolean {
        return phone.length >= 7
    }
}
