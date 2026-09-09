package com.wcrm.core.database.dao

object CustomerQuery {
    const val SEARCH_BY_NAME = "SELECT * FROM customers WHERE name LIKE :query"
}
