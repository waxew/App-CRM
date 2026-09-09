package com.wcrm.business.profile.profiles

import com.wcrm.business.profile.schema.AttributeDefinition
import com.wcrm.business.profile.schema.AttributeType
import com.wcrm.business.profile.schema.BusinessModule
import com.wcrm.business.profile.schema.BusinessProfile
import com.wcrm.core.common.config.AppConfig

/** فهرست رسمی پروفایل‌های قابل استفاده در محصولات مبتنی بر W-CRM. */
object AppBusinessProfiles {
    val all: List<BusinessProfile> = listOf(
        BusinessProfile(
            id = "mobile_store_001",
            name = "فروشگاه موبایل",
            enabled = AppConfig.BusinessProfiles.mobileStore,
            visualKey = "mobile",
            enabledModules = setOf(
                BusinessModule.CUSTOMER, BusinessModule.PRODUCT, BusinessModule.INVENTORY,
                BusinessModule.SALES, BusinessModule.INVOICE, BusinessModule.WARRANTY,
                BusinessModule.REPAIR, BusinessModule.ACCOUNTING, BusinessModule.DELIVERY,
                BusinessModule.SERIAL_MANAGEMENT
            ),
            attributes = listOf(
                AttributeDefinition("brand", "برند", AttributeType.TEXT, true),
                AttributeDefinition("model", "مدل", AttributeType.TEXT, true),
                AttributeDefinition("imei", "IMEI", AttributeType.TEXT),
                AttributeDefinition("storage", "حافظه", AttributeType.TEXT),
                AttributeDefinition("ram", "رم", AttributeType.TEXT),
                AttributeDefinition("color", "رنگ", AttributeType.TEXT)
            )
        ),
        simple("boutique_store_001", "بوتیک", AppConfig.BusinessProfiles.boutiqueStore, "boutique", listOf("size" to "سایز", "color" to "رنگ", "material" to "جنس", "season" to "فصل")),
        simple("cosmetics_store_001", "فروشگاه آرایشی", AppConfig.BusinessProfiles.cosmeticsStore, "cosmetics", listOf("volume" to "حجم", "shade" to "رنگ/شماره", "expiration" to "تاریخ انقضا")),
        simple("home_appliance_store_001", "لوازم خانگی", AppConfig.BusinessProfiles.homeApplianceStore, "home_appliance", listOf("model" to "مدل", "serial" to "سریال", "energy" to "رده انرژی")),
        simple("auto_parts_store_001", "لوازم یدکی", AppConfig.BusinessProfiles.autoPartsStore, "auto_parts", listOf("part_number" to "شماره قطعه", "vehicle" to "خودروی سازگار")),
        simple("jewelry_store_001", "طلا و جواهر", AppConfig.BusinessProfiles.jewelryStore, "jewelry", listOf("weight" to "وزن", "gold_type" to "نوع طلا", "stone" to "سنگ")),
        simple("book_store_001", "کتاب‌فروشی", AppConfig.BusinessProfiles.bookStore, "book", listOf("author" to "نویسنده", "isbn" to "ISBN", "publisher" to "ناشر")),
        simple("grocery_store_001", "سوپرمارکت", AppConfig.BusinessProfiles.groceryStore, "grocery", listOf("barcode" to "بارکد", "expiration" to "تاریخ انقضا")),
        simple("pet_store_001", "پت‌شاپ", AppConfig.BusinessProfiles.petStore, "pet", listOf("pet_type" to "نوع حیوان", "brand" to "برند")),
        simple("omnichannel_store_001", "فروشگاه چندکاناله", AppConfig.BusinessProfiles.omnichannelStore, "omnichannel", emptyList())
    )

    private fun simple(
        id: String,
        name: String,
        enabled: Boolean,
        visualKey: String,
        attributes: List<Pair<String, String>>
    ): BusinessProfile = BusinessProfile(
        id = id,
        name = name,
        enabled = enabled,
        visualKey = visualKey,
        enabledModules = setOf(
            BusinessModule.CUSTOMER, BusinessModule.PRODUCT, BusinessModule.INVENTORY,
            BusinessModule.SALES, BusinessModule.INVOICE, BusinessModule.ACCOUNTING,
            BusinessModule.DELIVERY
        ),
        attributes = attributes.map { (key, label) ->
            AttributeDefinition(key, label, AttributeType.TEXT)
        }
    )
}
