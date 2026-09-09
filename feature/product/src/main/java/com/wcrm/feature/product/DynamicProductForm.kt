package com.wcrm.feature.product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wcrm.business.profile.schema.AttributeDefinition
import com.wcrm.business.profile.schema.AttributeType
import com.wcrm.business.profile.schema.BusinessProfile

/**
 * فرم عمومی ثبت محصول که فیلدهای تخصصی آن از BusinessProfile فعال ساخته می‌شوند.
 * این کلاس هیچ شناخت مستقیمی از موبایل، بوتیک، طلا یا سایر صنف‌ها ندارد.
 */
@Composable
fun DynamicProductForm(
    profile: BusinessProfile,
    onSubmit: (Map<String, String>) -> Unit = {}
) {
    val values = remember(profile.id) { mutableStateMapOf<String, String>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "ثبت ${profile.terminology.productLabel}",
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = "فرم تخصصی ${profile.name}",
            style = MaterialTheme.typography.bodyMedium
        )

        BaseTextField(
            label = "نام ${profile.terminology.productLabel}",
            value = values["name"].orEmpty(),
            onValueChange = { values["name"] = it },
            required = true
        )

        profile.attributes.forEach { attribute ->
            ProfileAttributeField(
                attribute = attribute,
                value = values[attribute.id].orEmpty(),
                onValueChange = { values[attribute.id] = it }
            )
        }

        Spacer(Modifier.height(4.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { onSubmit(values.toMap()) }
        ) {
            Text("ثبت")
        }
    }
}

/**
 * Renderer ساده فیلدهای Schema. در گام‌های بعد ENUM/DATE/BOOLEAN می‌توانند Renderer تخصصی خود را داشته باشند.
 */
@Composable
private fun ProfileAttributeField(
    attribute: AttributeDefinition,
    value: String,
    onValueChange: (String) -> Unit
) {
    when (attribute.type) {
        AttributeType.TEXT,
        AttributeType.NUMBER,
        AttributeType.DECIMAL,
        AttributeType.DATE,
        AttributeType.ENUM,
        AttributeType.BOOLEAN -> BaseTextField(
            label = attribute.name,
            value = value,
            onValueChange = onValueChange,
            required = attribute.required
        )
    }
}

@Composable
private fun BaseTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    required: Boolean
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        label = { Text(if (required) "$label *" else label) }
    )
}
