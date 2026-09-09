# W-CRM

## معرفی

W-CRM یک هسته CRM اندرویدی چندکسب‌وکاره و Local-First است که با Kotlin و Jetpack Compose ساخته می‌شود. ماهیت نسخه نهایی توسط توسعه‌دهنده و از طریق `AppConfig` تعیین می‌شود؛ کاربر داخل برنامه Business Profile را انتخاب نمی‌کند.

هدف اصلی پروژه این است که از یک Core مشترک، نسخه‌های مستقل برای صنف‌های مختلف ساخته شوند، بدون کپی‌کردن منطق تجاری و بدون تغییر پراکنده در کد.

## فناوری‌ها

- Kotlin
- Jetpack Compose + Material 3
- Clean Architecture
- Multi Module Architecture
- Hilt
- Room
- Coroutines + Flow
- Navigation Compose
- Gradle Kotlin DSL
- GitHub Actions

## معماری کلان

```text
AppConfig
   ↓
Business Profile Catalog
   ↓
BusinessProfileRegistry
   ↓
ProfileSchemaLoader
   ↓
RuntimeBootstrap / RuntimeContext
   ↓
Feature + Profile-aware UI
   ↓
UseCase / Repository
   ↓
DAO / Room
```

ساختار ماژول‌ها:

```text
app/
core/
  common/
  model/
  domain/
  database/
  repository/
business_profile/
  schema/
  profiles/
  registry/
  validator/
runtime/
feature/
  dashboard/
  customer/
  product/
  inventory/
  sales/
  invoice/
  warranty/
  repair/
  accounting/
  delivery/
```

## AppConfig؛ مرجع تنظیمات محصول

فایل `core/common/.../AppConfig.kt` نقطه مرکزی مشخصات محصول است و شامل این حوزه‌هاست:

- Identity: نام، نسخه، شناسه برنامه و کلید Assetها
- BusinessProfiles: فعال/غیرفعال کردن صنف‌ها
- Ads: روشن/خاموش، Provider و Placementها
- Update: بررسی نسخه جدید و Endpoint
- Startup: Logo Motion و زمان Splash
- Drawer: قابلیت‌های منوی همبرگری
- Company: اطلاعات AS Team و پشتیبانی

قانون: دقیقاً یک Business Profile باید `true` باشد. Registry در Runtime این قانون را اعتبارسنجی می‌کند.

## ۱۰ Business Profile رسمی

1. `mobile_store_001` — فروشگاه موبایل: IMEI، سریال، حافظه، RAM، گارانتی، تعمیرات
2. `boutique_store_001` — بوتیک: سایز، رنگ، جنس، فصل، کالکشن
3. `cosmetics_store_001` — آرایشی: حجم، Shade، Batch، انقضا، کشور سازنده
4. `home_appliance_store_001` — لوازم خانگی: مدل، سریال، رده انرژی، گارانتی، نصب
5. `auto_parts_store_001` — قطعات خودرو: Part Number، OEM، خودروی سازگار، سال مدل
6. `jewelry_store_001` — طلا و جواهر: وزن، عیار، سنگ، اجرت، نوع طلا
7. `book_store_001` — کتاب‌فروشی: ISBN، نویسنده، ناشر، چاپ، دسته‌بندی
8. `grocery_store_001` — خواربار: بارکد، Batch، انقضا، تأمین‌کننده، نگهداری
9. `pet_store_001` — پت‌شاپ: نوع حیوان، برند، گروه سنی، نوع غذا، انقضا
10. `omnichannel_store_001` — چندکاناله: کانال فروش، انبار، شناسه آنلاین، ارسال

هیچ‌کدام از این Profileها صرفاً نام نیستند؛ هر Definition شامل Moduleها، Attribute Schema، Dashboard Widgetها، Theme Key و Terminology است.

## Profile Schema

قرارداد اصلی Profile شامل موارد زیر است:

```text
BusinessProfile
├── id / name / enabled
├── enabledModules
├── attributes
├── dashboardWidgets
├── theme
├── terminology
└── visualKey
```

`BusinessProfileRegistry` موارد زیر را بررسی می‌کند:

- یکتا بودن Profile ID
- یکتا بودن Attribute IDها
- یکتا بودن Dashboard Widget IDها
- فعال بودن دقیقاً یک Profile

`ProfileSchemaLoader` تنها مسیر استاندارد بارگذاری Schema برای Runtime است.

## UI Profile-aware

UI به‌صورت ۱۰ کپی مستقل نوشته نمی‌شود. Design System و Compose Componentها مشترک هستند و Profile فقط Configuration تخصصی را تزریق می‌کند:

```text
Shared UI Engine
+ Profile Fields
+ Dashboard Widgets
+ Theme Keys
+ Asset Keys
+ Terminology
```

در نتیجه Dashboard فروشگاه موبایل کارت‌های دستگاه/IMEI/تعمیرات دارد، در حالی که بوتیک کارت‌های سایز/رنگ/کالکشن را نمایش می‌دهد. این تفاوت از Schema می‌آید، نه از شرط‌های پراکنده داخل UI.

## Data / Backend

Backend فعلی Local-First و مبتنی بر Room است:

```text
Compose UI
↓
ViewModel / UseCase
↓
Domain Repository Contract
↓
Repository Implementation
↓
Mapper
↓
DAO
↓
Room Database
```

Entity/DAO/Repository برای Customer، Product، Invoice، Inventory، Warranty، Repair و Serial/IMEI در Core نگه‌داری می‌شوند. Profileها Core را Fork نمی‌کنند و فقط Schema و Capability اضافه می‌کنند.

## Ads و VIP

منطق نمایش تبلیغ در `AdsPolicy` متمرکز است. UI نباید تصمیم VIP را دوباره پیاده کند.

- Ads خاموش → بدون تبلیغ
- مهمان → طبق Config
- کاربر بدون VIP → طبق Config
- VIP فعال → تبلیغ غیرفعال
- پایان VIP → سیاست عادی Ads دوباره اعمال می‌شود

## Update

ساختار Config برای Update Checker وجود دارد. اتصال HTTP/Endpoint و Notification نسخه جدید باید از لایه سرویس مستقل انجام شود و UI فقط State خروجی را نمایش دهد.

## Shell عمومی برنامه

`WCrmApp` مسئول پوسته مشترک است:

- Header سه‌بخشی
- Drawer راست
- نام برنامه از AppConfig
- نام Profile فعال از Runtime
- سیاست Back: خروج از Section به Home، نه بازپخش کل تاریخچه
- صفحات تنظیمات، اعلان، درباره، تماس، اشتراک‌گذاری، Backup/Restore و Update

## قوانین توسعه

- حذف Module یا Feature برای سبز کردن Build ممنوع است.
- Core برای یک صنف خاص Fork نمی‌شود.
- شرط‌های پراکنده `if(profile == ...)` در UI ممنوع‌اند؛ از Schema/Runtime استفاده شود.
- مقادیر عمومی محصول Hard-code نشوند و از AppConfig خوانده شوند.
- تغییرات مهم Commit و قابل بازیابی باشند.
- کامنت‌های فارسی دلیل معماری و منطق مهم را توضیح دهند، نه اینکه هر خط کد را تکرار کنند.
- مستندات فارسی همزمان با کد به‌روزرسانی شوند.

## مستندات

- `docs/ARCHITECTURE_FA.md`
- `docs/ARCHITECTURE_AUDIT_FA.md`
- `docs/BACKEND_DATA_GUIDE_FA.md`
- `docs/BUSINESS_PROFILE_IMPLEMENTATION_PLAN_FA.md`
- `docs/PROFILE_REGISTRY_SCHEMA_FA.md`
- `docs/CODE_COMMENT_PROGRESS_FA.md`

## Build

GitHub Actions با JDK 17 و Gradle 8.9 دستور زیر را اجرا می‌کند:

```text
gradle :app:assembleDebug --stacktrace
```

APK Debug بعد از Build موفق به Artifact با نام `W-CRM-debug` ارسال می‌شود.

## نسخه

- versionName: `1.0.0`
- versionCode: `1`
- minSdk: `26`
- compileSdk/targetSdk: `35`
