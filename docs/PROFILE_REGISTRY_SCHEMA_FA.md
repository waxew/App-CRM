# Profile Registry + Schema Loader

## هدف
این لایه مسئول مدیریت تمام Business Profile های W-CRM است. اضافه کردن پروفایل جدید نباید نیازمند تغییر در Core برنامه باشد.

## معماری

```
Profile Definition
        |
        v
Profile Registry
        |
        v
Schema Loader
        |
        v
Runtime Context
        |
        v
UI / Modules / Fields
```

## قانون فعال سازی

هر نسخه از برنامه فقط یک Business Profile فعال دارد.

نمونه:

```
mobile_store_001 = true
boutique_store_001 = false
```

در زمان ساخت نسخه بوتیک فقط مقدار فعال تغییر می کند.

## پروفایل های استاندارد

1. mobile_store_001
2. boutique_store_001
3. cosmetics_store_001
4. home_appliance_store_001
5. auto_parts_store_001
6. jewelry_store_001
7. book_store_001
8. grocery_store_001
9. pet_store_001
10. omnichannel_store_001

## اجزای هر Profile

- Metadata
- Theme
- Assets
- Modules
- Fields Schema
- Dashboard Widgets
- Terminology
- Permissions

## اصول توسعه

- عدم استفاده از شرط های پراکنده برای تشخیص صنف
- تمام رفتارها از Profile Definition خوانده می شوند
- Core مستقل از نوع کسب و کار باقی می ماند
- اضافه کردن پروفایل یازدهم فقط با اضافه کردن Definition جدید انجام می شود
