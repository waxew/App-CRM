package com.wcrm.business.profile.profiles

import com.wcrm.business.profile.schema.*
import com.wcrm.core.common.config.AppConfig

/**
 * کاتالوگ رسمی ده Business Profile پروژه.
 * هر Profile تعریف مستقل ماژول، فیلد، داشبورد، Theme و واژگان خود را دارد.
 */
object AppBusinessProfiles {
    private val commonModules = setOf(
        BusinessModule.CUSTOMER, BusinessModule.PRODUCT, BusinessModule.INVENTORY,
        BusinessModule.SALES, BusinessModule.INVOICE, BusinessModule.ACCOUNTING,
        BusinessModule.DELIVERY
    )

    val all: List<BusinessProfile> = listOf(
        profile(
            id = "mobile_store_001", name = "فروشگاه موبایل", enabled = AppConfig.BusinessProfiles.mobileStore,
            visualKey = "mobile", modules = commonModules + setOf(BusinessModule.WARRANTY, BusinessModule.REPAIR, BusinessModule.SERIAL_MANAGEMENT),
            fields = fields(
                "brand" to "برند", "model" to "مدل", "storage" to "حافظه", "ram" to "رم",
                "color" to "رنگ", "imei" to "IMEI", "serial" to "سریال", "warranty_date" to "تاریخ گارانتی"
            ),
            widgets = widgets(
                "today_sales" to "فروش امروز", "device_stock" to "دستگاه‌های موجود",
                "open_repairs" to "تعمیرات باز", "active_warranties" to "گارانتی‌های فعال"
            ),
            terminology = ProfileTerminology(productLabel = "دستگاه")
        ),
        profile(
            id = "boutique_store_001", name = "بوتیک و پوشاک", enabled = AppConfig.BusinessProfiles.boutiqueStore,
            visualKey = "boutique", fields = fields(
                "brand" to "برند", "size" to "سایز", "color" to "رنگ", "material" to "جنس",
                "season" to "فصل", "collection" to "کالکشن"
            ), widgets = widgets(
                "today_sales" to "فروش امروز", "size_stock" to "موجودی سایزها",
                "popular_colors" to "رنگ‌های پرفروش", "low_stock" to "کمبود موجودی"
            ), terminology = ProfileTerminology(productLabel = "پوشاک")
        ),
        profile(
            id = "cosmetics_store_001", name = "آرایشی و بهداشتی", enabled = AppConfig.BusinessProfiles.cosmeticsStore,
            visualKey = "cosmetics", fields = fields(
                "brand" to "برند", "category" to "دسته‌بندی", "volume" to "حجم",
                "shade" to "رنگ/شماره", "batch" to "بچ نامبر", "expiration" to "تاریخ انقضا", "country" to "کشور سازنده"
            ), widgets = widgets(
                "today_sales" to "فروش امروز", "expiring" to "نزدیک انقضا",
                "top_brand" to "برند پرفروش", "stock" to "موجودی"
            )
        ),
        profile(
            id = "home_appliance_store_001", name = "لوازم خانگی", enabled = AppConfig.BusinessProfiles.homeApplianceStore,
            visualKey = "home_appliance", modules = commonModules + BusinessModule.WARRANTY,
            fields = fields(
                "brand" to "برند", "model" to "مدل", "serial" to "سریال", "energy_class" to "رده انرژی",
                "warranty" to "گارانتی", "installation" to "نصب"
            ), widgets = widgets(
                "today_sales" to "فروش امروز", "serial_stock" to "کالاهای سریال‌دار",
                "warranty" to "گارانتی‌ها", "installation" to "نصب‌های در انتظار"
            ), terminology = ProfileTerminology(productLabel = "کالا")
        ),
        profile(
            id = "auto_parts_store_001", name = "قطعات خودرو", enabled = AppConfig.BusinessProfiles.autoPartsStore,
            visualKey = "auto_parts", fields = fields(
                "brand" to "برند", "part_number" to "شماره قطعه", "oem_code" to "کد OEM",
                "vehicle" to "خودروی سازگار", "model_year" to "سال مدل"
            ), widgets = widgets(
                "today_sales" to "فروش امروز", "parts_stock" to "موجودی قطعات",
                "low_stock" to "قطعات کم‌موجودی", "top_vehicle" to "خودروی پرتکرار"
            ), terminology = ProfileTerminology(productLabel = "قطعه")
        ),
        profile(
            id = "jewelry_store_001", name = "طلا و جواهر", enabled = AppConfig.BusinessProfiles.jewelryStore,
            visualKey = "jewelry", fields = listOf(
                AttributeDefinition("weight", "وزن", AttributeType.DECIMAL, true),
                AttributeDefinition("karat", "عیار", AttributeType.TEXT, true),
                AttributeDefinition("stone", "نوع سنگ", AttributeType.TEXT),
                AttributeDefinition("labor_cost", "اجرت", AttributeType.DECIMAL),
                AttributeDefinition("gold_type", "نوع طلا", AttributeType.TEXT)
            ), widgets = widgets(
                "today_sales" to "فروش امروز", "gold_weight" to "وزن موجودی",
                "labor" to "میانگین اجرت", "stock" to "تعداد اقلام"
            ), terminology = ProfileTerminology(productLabel = "قطعه طلا")
        ),
        profile(
            id = "book_store_001", name = "کتاب‌فروشی", enabled = AppConfig.BusinessProfiles.bookStore,
            visualKey = "book", fields = fields(
                "isbn" to "ISBN", "author" to "نویسنده", "publisher" to "ناشر",
                "edition" to "نوبت چاپ", "category" to "دسته‌بندی"
            ), widgets = widgets(
                "today_sales" to "فروش امروز", "book_stock" to "موجودی کتاب",
                "top_author" to "نویسنده پرفروش", "low_stock" to "کتاب‌های کم‌موجودی"
            ), terminology = ProfileTerminology(productLabel = "کتاب")
        ),
        profile(
            id = "grocery_store_001", name = "سوپرمارکت و خواربار", enabled = AppConfig.BusinessProfiles.groceryStore,
            visualKey = "grocery", fields = fields(
                "barcode" to "بارکد", "expiration" to "تاریخ انقضا", "batch" to "بچ",
                "supplier" to "تأمین‌کننده", "storage" to "شرایط نگهداری"
            ), widgets = widgets(
                "today_sales" to "فروش امروز", "expiring" to "نزدیک انقضا",
                "low_stock" to "کمبود موجودی", "supplier" to "تأمین‌کنندگان"
            ), terminology = ProfileTerminology(productLabel = "کالا")
        ),
        profile(
            id = "pet_store_001", name = "پت‌شاپ", enabled = AppConfig.BusinessProfiles.petStore,
            visualKey = "pet", fields = fields(
                "animal_type" to "نوع حیوان", "brand" to "برند", "age_group" to "گروه سنی",
                "food_type" to "نوع غذا", "expiration" to "تاریخ انقضا"
            ), widgets = widgets(
                "today_sales" to "فروش امروز", "food_stock" to "موجودی غذا",
                "expiring" to "نزدیک انقضا", "animal_groups" to "گروه‌های حیوان"
            )
        ),
        profile(
            id = "omnichannel_store_001", name = "فروشگاه چندکاناله", enabled = AppConfig.BusinessProfiles.omnichannelStore,
            visualKey = "omnichannel", fields = fields(
                "channel" to "کانال فروش", "warehouse" to "انبار", "online_sku" to "شناسه آنلاین",
                "delivery_method" to "روش ارسال"
            ), widgets = widgets(
                "today_sales" to "فروش کل امروز", "online_orders" to "سفارش آنلاین",
                "offline_sales" to "فروش حضوری", "pending_delivery" to "ارسال‌های در انتظار"
            ), terminology = ProfileTerminology(productLabel = "کالا", saleLabel = "سفارش/فروش")
        )
    )

    private fun profile(
        id: String,
        name: String,
        enabled: Boolean,
        visualKey: String,
        modules: Set<BusinessModule> = commonModules,
        fields: List<AttributeDefinition>,
        widgets: List<DashboardWidgetDefinition>,
        terminology: ProfileTerminology = ProfileTerminology()
    ) = BusinessProfile(
        id = id,
        name = name,
        enabled = enabled,
        visualKey = visualKey,
        enabledModules = modules,
        attributes = fields,
        dashboardWidgets = widgets,
        theme = ProfileThemeDefinition(
            themeKey = "theme_$visualKey",
            heroAssetKey = "hero_$visualKey",
            primaryIconKey = "icon_$visualKey"
        ),
        terminology = terminology
    )

    private fun fields(vararg values: Pair<String, String>) = values.mapIndexed { index, (key, label) ->
        AttributeDefinition(key, label, AttributeType.TEXT, required = index == 0)
    }

    private fun widgets(vararg values: Pair<String, String>) = values.mapIndexed { index, (id, title) ->
        DashboardWidgetDefinition(
            id = id,
            title = title,
            type = DashboardWidgetType.METRIC,
            iconKey = "widget_$id",
            order = index
        )
    }
}
