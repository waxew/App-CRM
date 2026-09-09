# راهنمای معماری W-CRM

## هدف پروژه
W-CRM یک هسته CRM چند کسب‌وکاره است که با معماری Profile محور ساخته می‌شود.

## اصل Business Profile
نوع کسب‌وکار توسط توسعه‌دهنده در Profile Configuration تعیین می‌شود.

هر Profile شامل موارد زیر است:

- فعال یا غیرفعال بودن (true/false)
- ماژول‌های فعال
- فیلدهای اختصاصی
- داشبورد اختصاصی
- Asset و Theme اختصاصی

در هر نسخه فقط یک Business Profile باید فعال باشد.

## معماری لایه‌ای

App
↓
Feature UI
↓
Domain UseCase
↓
Repository Contract
↓
Repository Implementation
↓
Database / Room

## قوانین توسعه

- حذف ماژول برای Build ممنوع است.
- Config مرکزی باید منبع اطلاعات برنامه باشد.
- کدهای عمومی در Core قرار می‌گیرند.
- تفاوت کسب‌وکارها در Profile تعریف می‌شود.
