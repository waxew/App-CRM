package com.wcrm.core.model

/**
 * نوع حرکت موجودی را مشخص می‌کند.
 *
 * این enum به جای استفاده از رشته‌های آزاد تعریف شده تا تاریخچه موجودی
 * قابل اعتبارسنجی، جست‌وجو و گزارش‌گیری باشد.
 */
enum class InventoryMovementType {
    /** ورود کالا به موجودی. */
    STOCK_IN,

    /** خروج کالا از موجودی خارج از فرآیند فروش. */
    STOCK_OUT,

    /** اصلاح دستی موجودی برای تطبیق با مقدار واقعی. */
    ADJUSTMENT,

    /** کاهش موجودی ناشی از ثبت فروش. */
    SALE,

    /** بازگشت کالا و افزایش مجدد موجودی. */
    RETURN
}

/**
 * یک رویداد تغییر موجودی برای یک محصول.
 *
 * نگهداری Movement به صورت رکورد مستقل باعث می‌شود تاریخچه تغییرات موجودی
 * قابل رهگیری باشد و موجودی فقط به یک عدد نهایی وابسته نباشد.
 *
 * @property id شناسه یکتای حرکت موجودی.
 * @property productId شناسه محصول مرتبط.
 * @property type نوع حرکت موجودی.
 * @property quantity تعداد واحدهای درگیر در این حرکت.
 * @property note توضیح اختیاری درباره علت یا منبع تغییر موجودی.
 * @property createdAt زمان ثبت حرکت.
 */
data class InventoryMovement(
    val id: Long = 0,
    val productId: Long,
    val type: InventoryMovementType,
    val quantity: Int,
    val note: String? = null,
    val createdAt: Long = System.currentTimeMillis()
)

/**
 * نمای خلاصه از موجودی فعلی یک محصول.
 *
 * این مدل برای نمایش سریع موجودی و تشخیص وضعیت کمبود کالا استفاده می‌شود.
 * مقدار آستانه می‌تواند در آینده از Business Profile یا تنظیمات محصول تأمین شود.
 *
 * @property productId شناسه محصول.
 * @property stock موجودی فعلی.
 * @property lowStockThreshold حدی که در آن محصول کم‌موجودی محسوب می‌شود.
 */
data class InventorySnapshot(
    val productId: Long,
    val stock: Int,
    val lowStockThreshold: Int = 0
) {
    /**
     * مشخص می‌کند آیا موجودی به حد هشدار یا پایین‌تر رسیده است.
     */
    val isLowStock: Boolean
        get() = stock <= lowStockThreshold
}
