# گزارش پیشرفت کامنت‌گذاری و توسعه W-CRM

## هدف
اضافه کردن توضیحات فارسی استاندارد به بخش‌های مختلف پروژه بدون تغییر منطق برنامه و ثبت وضعیت واقعی توسعه و Build.

## ترتیب بررسی
1. Core Model
2. Domain و UseCaseها
3. Database و Room
4. Repository
5. Dependency Injection
6. Featureها
7. UI و Compose

## وضعیت فعلی توسعه
- لایه‌های اصلی Core برای Customer، Product، Invoice، Inventory، Warranty، Repair و Serial/IMEI ایجاد و به DI متصل شده‌اند.
- ماژول‌های Business Profile و Runtime در Gradle ثبت و پیکربندی شده‌اند.
- ماژول‌های Feature شامل Dashboard، Customer، Product، Inventory، Sales، Invoice، Warranty، Repair، Accounting و Delivery در ساختار پروژه ثبت شده‌اند.
- AndroidManifest ماژول app ایجاد شده است.
- MainActivity اولیه مبتنی بر Jetpack Compose ایجاد شده است.
- GitHub Actions برای اجرای `:app:assembleDebug` فعال است.
- هدف فعلی عبور مرحله‌به‌مرحله از خطاهای واقعی Build بدون حذف یا کوچک‌سازی هیچ ماژول یا قابلیت پروژه است.

## قوانین
- کامنت باید دلیل وجود کلاس یا تابع را توضیح دهد.
- منطق تجاری توضیح داده شود.
- کامنت جایگزین نام‌گذاری صحیح نیست.
- هیچ کدی صرفاً برای اضافه کردن کامنت بازنویسی یا حذف نمی‌شود.
- برای موفق شدن Build هیچ فایل، ماژول یا قابلیت اصلی پروژه حذف یا ساده‌سازی نمی‌شود.
- هر خطای Build در همان بخش واقعی پروژه اصلاح می‌شود و تغییرات مهم با Commit قابل بازیابی ثبت می‌شوند.
