# راهنمای Backend / Data Layer در W-CRM

## تعریف Backend در نسخه فعلی
نسخه فعلی W-CRM یک برنامه Local-First است. Backend فعلی در داخل برنامه از Room + Repository + UseCase تشکیل شده و هنوز سرور Remote/API مستقل به پروژه متصل نشده است.

## جریان داده
UI / ViewModel
→ UseCase
→ Repository Interface
→ Repository Implementation
→ Mapper
→ DAO
→ Room Database

این جداسازی باعث می‌شود در آینده Remote API بدون شکستن Core اضافه شود.

## حوزه‌های پیاده‌سازی‌شده
- Customer
- Product
- Inventory
- Invoice
- Warranty
- Repair
- Serial / IMEI

## الگوی استاندارد هر حوزه
1. Domain Model در `core:model`
2. Repository Contract در `core:domain`
3. Room Entity و DAO در `core:database`
4. Mapper و RepositoryImpl در `core:repository`
5. UseCase در `core:domain`
6. ViewModel در Feature
7. Compose Screen در Feature

## مسیر تکمیل Backend
- تکمیل UseCaseهای CRUD و Query برای تمام حوزه‌ها.
- افزودن Transactionهای چندمرحله‌ای برای Sale/Invoice/Inventory.
- افزودن validation و error model مشترک.
- افزودن migration و schema export برای Room.
- افزودن تست DAO و Repository.
- در فاز Cloud: اضافه کردن `core:network` و RemoteDataSource بدون تغییر قراردادهای Domain.

## قانون مهم
UI نباید مستقیماً DAO یا Room را صدا بزند. تمام دسترسی داده باید از مسیر Domain/Repository انجام شود.
