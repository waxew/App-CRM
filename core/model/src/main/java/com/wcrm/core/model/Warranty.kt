package com.wcrm.core.model

/**
 * وضعیت ضمانت کالا.
 */
enum class WarrantyStatus {
    ACTIVE,
    EXPIRED,
    VOID,
    CLAIMED
}

/**
 * مدل ضمانت محصول.
 * برای رهگیری تاریخ شروع، پایان و وضعیت خدمات پس از فروش استفاده می‌شود.
 */
data class Warranty(
    val id: Long = 0,
    /** شناسه محصول دارای ضمانت */
    val productId: Long,
    /** شماره سریال ثبت‌شده برای ضمانت */
    val serialNumber: String,
    /** زمان شروع ضمانت */
    val startDate: Long,
    /** زمان پایان ضمانت */
    val endDate: Long,
    /** وضعیت جاری ضمانت */
    val status: WarrantyStatus = WarrantyStatus.ACTIVE,
    val notes: String? = null
)
