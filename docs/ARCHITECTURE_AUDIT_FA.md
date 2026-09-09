# گزارش بررسی معماری W-CRM

## وضعیت فعلی
معماری پروژه در مسیر درست Clean Architecture + Multi Module قرار دارد و Build نسخه Debug در Run #13 با موفقیت کامل شده است.

## لایه‌ها
- `core:model`: مدل‌های خالص دامنه.
- `core:domain`: قرارداد Repository و UseCaseها.
- `core:database`: Room Entity، DAO و AppDatabase.
- `core:repository`: Mapper و پیاده‌سازی Repositoryها.
- `business_profile:*`: Schema، Registry، Profiles و Validator برای فعال‌سازی قابلیت‌های صنفی بدون تغییر Core.
- `runtime`: لایه راه‌اندازی و اتصال Profile/Database/Moduleها.
- `feature:*`: UI و منطق هر قابلیت مستقل.
- `app`: Composition Root، Activity و Navigation.

## نقاط صحیح معماری
- Core به Business Profile وابسته نشده است.
- Entityهای Room از مدل Domain جدا هستند.
- Repository interface در Domain و implementation در Data/Repository قرار دارد.
- Featureها به‌صورت ماژول مستقل ثبت شده‌اند.
- نسخه فعلی با JDK/JVM 17 یکسان‌سازی شده است.

## نواقص معماری باقی‌مانده
1. Navigation هنوز کامل نشده و فقط foundation دارد.
2. Dashboard تا پیش از این placeholder بود؛ اکنون UI واقعی اولیه اضافه شده است.
3. ViewModelهای Featureها باید به UseCase/Repository واقعی متصل شوند.
4. Business Profile registry و profile implementations باید برای ۱۰ پروفایل هدف تکمیل شوند.
5. RuntimeBootstrap/RuntimeInitializer باید به راه‌اندازی واقعی Profile و Database متصل شوند.
6. تست‌های Unit/Room/Repository/Navigation هنوز باید تکمیل شوند.
7. Room schema export باید استاندارد شود.
8. CI باید Debug APK را به‌عنوان Artifact نگه دارد؛ این مورد اکنون به workflow اضافه شده است.

## اصل توسعه
هیچ Feature یا ماژولی برای عبور از Build حذف یا کوچک نمی‌شود. خطاها در همان لایه واقعی معماری اصلاح می‌شوند.
