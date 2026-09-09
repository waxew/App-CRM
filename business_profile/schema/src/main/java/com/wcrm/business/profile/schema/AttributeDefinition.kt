package com.wcrm.business.profile.schema

enum class AttributeType {
    TEXT,
    NUMBER,
    DECIMAL,
    BOOLEAN,
    DATE,
    ENUM
}

data class AttributeDefinition(
    val id: String,
    val name: String,
    val type: AttributeType,
    val required: Boolean = false,
    val options: List<String> = emptyList()
)
