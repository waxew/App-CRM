# برنامه کامنت‌گذاری فارسی W-CRM

## هدف
افزودن توضیحات فارسی استاندارد به کدهای پروژه بدون کاهش خوانایی و بدون ایجاد کامنت‌های اضافی.

## ترتیب بررسی

1. Core Model
- توضیح مسئولیت Entity ها
- توضیح فیلدهای مهم

2. Domain
- توضیح UseCase ها
- توضیح قرارداد Repository ها

3. Database
- توضیح Entity Mapping
- توضیح DAO ها
- توضیح Migration ها

4. Repository
- توضیح ارتباط Data Layer و Domain

5. Dependency Injection
- توضیح Module های Hilt

6. Feature ها
- توضیح ViewModel
- توضیح State و Event
- توضیح Composable ها

## قوانین
- هیچ فایل برای Build سریع حذف نمی‌شود.
- منطق کد تغییر نمی‌کند مگر برای اصلاح معماری.
- کامنت‌ها فارسی و مرتبط با منطق هستند.
- کدهای ساده با کامنت تکراری شلوغ نمی‌شوند.
