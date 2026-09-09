package com.wcrm.core.model

/**
 * مدل دامنه محصول در هسته W-CRM.
 *
 * این کلاس مستقل از نوع کسب‌وکار طراحی شده تا تمام Business Profileها بتوانند
 * بدون تغییر در Core از یک ساختار پایه مشترک برای محصول استفاده کنند.
 * ویژگی‌های تخصصی هر کسب‌وکار باید از طریق سیستم Attribute و Business Profile
 * به محصول افزوده شوند و نباید مستقیماً این مدل را برای هر صنف تغییر دهند.
 *
 * @property id شناسه یکتای داخلی محصول.
 * @property name نام نمایشی محصول.
 * @property category دسته‌بندی عمومی محصول؛ در صورت نبود دسته‌بندی می‌تواند null باشد.
 * @property brand برند یا سازنده محصول؛ اختیاری است.
 * @property price قیمت فروش محصول در واحد پول پایه برنامه.
 * @property cost قیمت تمام‌شده یا بهای خرید محصول.
 * @property stock موجودی جاری محصول در سطح مدل پایه.
 * @property createdAt زمان ایجاد رکورد به صورت Unix timestamp میلی‌ثانیه‌ای.
 * @property updatedAt زمان آخرین بروزرسانی رکورد.
 */
data class Product(
    val id: Long = 0,
    val name: String,
    val category: String? = null,
    val brand: String? = null,
    val price: Long = 0,
    val cost: Long = 0,
    val stock: Int = 0,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
