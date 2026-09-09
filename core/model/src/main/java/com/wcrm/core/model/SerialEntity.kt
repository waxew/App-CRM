package com.wcrm.core.model

/**
 * مدل مدیریت شماره سریال و IMEI کالاهای سریالی.
 * برای کسب‌وکارهایی مانند موبایل‌فروشی که نیاز به رهگیری دقیق کالا دارند استفاده می‌شود.
 */
data class SerialEntity(
    /** شناسه رکورد */
    val id: Long = 0,
    /** شناسه محصول مرتبط */
    val productId: Long,
    /** شماره IMEI در کالاهای الکترونیکی */
    val imei: String? = null,
    /** شماره سریال عمومی کالا */
    val serialNumber: String? = null,
    val createdAt: Long = System.currentTimeMillis()
)
