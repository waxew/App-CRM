package com.wcrm.core.repository.customer

import com.wcrm.core.domain.repository.CustomerRepository

/**
 * پیاده‌سازی Repository مشتری در لایه داده.
 *
 * این کلاس باید مرز بین قرارداد Domain و منبع داده محلی Room باشد و مسئول
 * تبدیل CustomerEntity به مدل دامنه Customer و برعکس شود.
 *
 * در وضعیت فعلی اتصال عملیاتی به CustomerDao هنوز تکمیل نشده است؛ بنابراین
 * این فایل عمداً به‌عنوان نقطه اتصال اصلی نگه داشته می‌شود و نباید با دسترسی
 * مستقیم Featureها به Room دور زده شود.
 */
class CustomerRepositoryImpl : CustomerRepository
