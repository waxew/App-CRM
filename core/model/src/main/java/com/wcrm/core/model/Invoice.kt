package com.wcrm.core.model

/**
 * یک ردیف از اقلام فاکتور.
 *
 * قیمت، تخفیف و مالیات در سطح ردیف نگهداری می‌شوند تا محاسبات فاکتور
 * شفاف، قابل تست و مستقل از UI باشند.
 *
 * @property productId شناسه محصول فروخته‌شده.
 * @property productName نام محصول در زمان صدور فاکتور؛ برای حفظ تاریخچه فروش نگهداری می‌شود.
 * @property quantity تعداد واحد فروخته‌شده.
 * @property unitPrice قیمت واحد در زمان فروش.
 * @property discountAmount مبلغ تخفیف اعمال‌شده روی این ردیف.
 * @property taxAmount مبلغ مالیات این ردیف.
 */
data class InvoiceItem(
    val productId: Long,
    val productName: String,
    val quantity: Int,
    val unitPrice: Long,
    val discountAmount: Long = 0,
    val taxAmount: Long = 0
) {
    /**
     * مبلغ نهایی ردیف پس از اعمال تخفیف و مالیات.
     */
    val lineTotal: Long
        get() = (unitPrice * quantity) - discountAmount + taxAmount
}

/**
 * وضعیت پرداخت فاکتور را در چرخه مالی مشخص می‌کند.
 */
enum class PaymentStatus {
    /** هیچ مبلغی پرداخت نشده است. */
    UNPAID,

    /** بخشی از مبلغ فاکتور پرداخت شده است. */
    PARTIALLY_PAID,

    /** مبلغ فاکتور به طور کامل تسویه شده است. */
    PAID,

    /** مبلغ پرداختی به مشتری بازگردانده شده است. */
    REFUNDED
}

/**
 * مدل دامنه فاکتور در هسته CRM.
 *
 * این مدل رابطه فروش با مشتری و اقلام فروخته‌شده را در سطح Core نگهداری می‌کند.
 * قوانین تخصصی صورتحساب برای هر کسب‌وکار باید در Feature یا Business Profile
 * پیاده‌سازی شوند و نباید مدل پایه فاکتور را وابسته به یک صنف خاص کنند.
 *
 * @property id شناسه یکتای فاکتور.
 * @property customerId شناسه مشتری؛ برای فروش ناشناس می‌تواند null باشد.
 * @property items اقلام ثبت‌شده در فاکتور.
 * @property totalAmount مبلغ نهایی فاکتور؛ به طور پیش‌فرض از جمع ردیف‌ها محاسبه می‌شود.
 * @property paymentStatus وضعیت فعلی پرداخت.
 * @property createdAt زمان ایجاد فاکتور.
 * @property updatedAt زمان آخرین بروزرسانی فاکتور.
 */
data class Invoice(
    val id: Long = 0,
    val customerId: Long? = null,
    val items: List<InvoiceItem> = emptyList(),
    val totalAmount: Long = items.sumOf { it.lineTotal },
    val paymentStatus: PaymentStatus = PaymentStatus.UNPAID,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
