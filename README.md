# W-CRM

## معرفی پروژه

W-CRM یک نرم‌افزار CRM اندرویدی چندکسب‌وکاره است که با معماری **Business Profile محور** طراحی می‌شود.

هدف پروژه ساخت یک هسته مرکزی قابل توسعه است که بتوان از آن برای چندین نسخه مستقل کسب‌وکاری استفاده کرد.

## فناوری‌ها

- Kotlin
- Jetpack Compose
- Clean Architecture
- Multi Module Architecture
- Hilt Dependency Injection
- Room Database
- Kotlin Coroutines + Flow
- Navigation Compose
- Gradle Kotlin DSL

## معماری کلی

```
app
│
├── core
│   ├── common
│   ├── database
│   ├── domain
│   ├── model
│   └── repository
│
├── business_profile
│   ├── profiles
│   ├── schema
│   ├── registry
│   └── validator
│
├── runtime
│
└── feature
    ├── customer
    ├── product
    ├── inventory
    ├── sales
    ├── invoice
    ├── warranty
    ├── repair
    └── accounting
```

## Business Profile

ماهیت هر نسخه از برنامه توسط توسعه‌دهنده در فایل‌های Profile مشخص می‌شود.

هر Profile شامل:

- فعال یا غیرفعال بودن
- ماژول‌های فعال
- فیلدهای اختصاصی
- داشبورد اختصاصی
- Theme و Assetهای مخصوص

در هر نسخه فقط یک Profile باید فعال باشد.

نمونه Profileها:

- Mobile Store
- Boutique
- Cosmetics
- Home Appliance
- Auto Parts
- Jewelry
- Book Store
- Grocery
- Pet Store
- Omnichannel Store

## App Configuration

اطلاعات عمومی برنامه باید از یک Config مرکزی خوانده شود:

- نام برنامه
- لوگو
- نسخه
- شناسه برنامه
- تنظیمات تبلیغات
- تنظیمات آپدیت
- تنظیمات Branding

هدف: ساخت نسخه‌های مستقل جدید بدون تغییر گسترده در کد اصلی.

## Backend و Data Layer

معماری داده:

```
UI
↓
ViewModel
↓
UseCase
↓
Repository
↓
Room Database
```

Backend فعلی Local First است و برای توسعه آینده آماده اتصال به سرویس Cloud است.

## قوانین توسعه

- حذف ماژول برای گرفتن Build ممنوع است.
- Core پروژه همیشه حفظ می‌شود.
- تغییرات مرحله‌ای و قابل برگشت انجام می‌شوند.
- توضیحات و کامنت‌های فارسی برای بخش‌های اصلی اضافه می‌شوند.
- مستندات فارسی پروژه باید همزمان با توسعه به‌روز شوند.

## مستندات فارسی

- docs/ARCHITECTURE_FA.md

## نسخه فعلی

v1.0.0

versionCode: 1
