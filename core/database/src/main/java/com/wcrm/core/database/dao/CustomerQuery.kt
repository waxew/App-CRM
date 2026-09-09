package com.wcrm.core.database.dao

/**
 * مجموعه Queryهای قابل‌استفاده مجدد برای داده‌های مشتری.
 *
 * نگه‌داری Queryهای مشترک در یک محل، از تکرار رشته‌های SQL جلوگیری می‌کند و تغییرات
 * آینده روی ساختار جست‌وجو را متمرکزتر می‌سازد. این شیء فقط تعریف Query را نگه می‌دارد
 * و هیچ منطق تجاری مربوط به جست‌وجوی مشتری در آن قرار نمی‌گیرد.
 */
object CustomerQuery {
    /** جست‌وجوی مشتری بر اساس نام با الگوی LIKE. */
    const val SEARCH_BY_NAME = "SELECT * FROM customers WHERE name LIKE :query"
}
