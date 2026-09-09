package com.wcrm.core.model

/**
 * وضعیت چرخه تعمیرات یک درخواست.
 * این وضعیت‌ها برای مدیریت فرآیند دریافت، بررسی، تعمیر و تحویل دستگاه استفاده می‌شوند.
 */
enum class RepairStatus {
    RECEIVED,
    DIAGNOSING,
    WAITING_FOR_PART,
    IN_PROGRESS,
    COMPLETED,
    DELIVERED,
    CANCELLED
}

/**
 * مدل تیکت تعمیرات در هسته CRM.
 * این مدل مستقل از نوع کسب‌وکار است و می‌تواند برای موبایل، لوازم خانگی
 * یا هر سرویس تعمیراتی دیگر استفاده شود.
 */
data class RepairTicket(
    /** شناسه یکتا درخواست تعمیر */
    val id: Long = 0,
    /** شناسه مشتری مرتبط با تعمیر */
    val customerId: Long,
    /** نام یا مشخصات دستگاه */
    val device: String,
    /** شرح مشکل گزارش‌شده */
    val problem: String,
    /** وضعیت فعلی تعمیر */
    val status: RepairStatus = RepairStatus.RECEIVED,
    /** هزینه تعمیر */
    val cost: Long = 0,
    /** توضیحات تکمیلی */
    val notes: String? = null,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
