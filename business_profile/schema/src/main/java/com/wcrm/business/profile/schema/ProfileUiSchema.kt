package com.wcrm.business.profile.schema

/** نوع ویجت قابل نمایش روی داشبورد. */
enum class DashboardWidgetType { METRIC, ALERT, QUICK_ACTION, STATUS }

/** تعریف یک ویجت داشبورد بدون وابستگی به Compose. */
data class DashboardWidgetDefinition(
    val id: String,
    val title: String,
    val type: DashboardWidgetType,
    val iconKey: String,
    val order: Int,
    val requiredModule: BusinessModule? = null
)

/** کلیدهای بصری هر صنف؛ Asset واقعی در لایه UI resolve می‌شود. */
data class ProfileThemeDefinition(
    val themeKey: String,
    val heroAssetKey: String,
    val primaryIconKey: String
)

/** واژگان قابل تغییر بر اساس نوع کسب‌وکار. */
data class ProfileTerminology(
    val productLabel: String = "محصول",
    val customerLabel: String = "مشتری",
    val inventoryLabel: String = "موجودی",
    val saleLabel: String = "فروش"
)
