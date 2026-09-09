package com.wcrm.core.common.config

/**
 * تنها نقطه تنظیم مشخصات عمومی برنامه.
 * برای ساخت یک محصول مستقل جدید، ابتدا مقادیر این فایل تغییر می‌کنند و سایر لایه‌ها
 * باید فقط از این تنظیمات استفاده کنند؛ از پراکنده کردن مقادیر ثابت در کد خودداری شود.
 */
object AppConfig {
    object Identity {
        const val appName = "W-CRM"
        const val applicationId = "com.wcrm.app"
        const val versionName = "1.0.0"
        const val versionCode = 1
        const val appLogoAsset = "app_logo"
        const val companyLogoAsset = "as_team_logo"
        const val showLogoInTopBar = false
    }

    /**
     * فقط یک پروفایل باید true باشد. انتخاب پروفایل توسط کاربر انجام نمی‌شود.
     */
    object BusinessProfiles {
        const val mobileStore = true
        const val boutiqueStore = false
        const val cosmeticsStore = false
        const val homeApplianceStore = false
        const val autoPartsStore = false
        const val jewelryStore = false
        const val bookStore = false
        const val groceryStore = false
        const val petStore = false
        const val omnichannelStore = false
    }

    object Ads {
        const val moduleEnabled = false
        const val showForGuest = true
        const val showForNonVip = true
        const val hideForActiveVip = true
        const val providerCode = ""
        const val bannerPlacementCode = ""
        const val interstitialPlacementCode = ""
    }

    object Update {
        const val enabled = true
        const val checkOnEveryLaunch = true
        const val endpointUrl = ""
        const val storeUrl = ""
    }

    object Startup {
        const val logoMotionEnabled = true
        const val minimumSplashMillis = 900L
    }

    object Drawer {
        const val profileImageEnabled = true
        const val backupRestoreEnabled = true
        const val shareEnabled = true
        const val updateEnabled = true
        const val aboutEnabled = true
        const val contactEnabled = true
    }

    object Company {
        const val displayName = "آکادمی آموزشی AS Team"
        const val supportEmail = "AS.Developers.Support@Gmail.Com"
        const val aboutText = "توسعه و پشتیبانی نرم‌افزار توسط آکادمی آموزشی AS Team انجام می‌شود."
        const val contactText = "برای پشتیبانی، پیشنهادها و گزارش مشکلات با تیم AS Team در ارتباط باشید."
    }
}

/** وضعیت حساب برای تصمیم‌گیری نمایش تبلیغات. */
data class UserAccessState(
    val isGuest: Boolean,
    val isVip: Boolean,
    val vipExpiresAtMillis: Long? = null
) {
    fun hasActiveVip(nowMillis: Long = System.currentTimeMillis()): Boolean =
        isVip && (vipExpiresAtMillis == null || vipExpiresAtMillis > nowMillis)
}

/** سیاست واحد نمایش تبلیغات؛ UI نباید منطق VIP را دوباره پیاده‌سازی کند. */
object AdsPolicy {
    fun shouldShowAds(state: UserAccessState, nowMillis: Long = System.currentTimeMillis()): Boolean {
        if (!AppConfig.Ads.moduleEnabled) return false
        if (AppConfig.Ads.hideForActiveVip && state.hasActiveVip(nowMillis)) return false
        if (state.isGuest) return AppConfig.Ads.showForGuest
        return AppConfig.Ads.showForNonVip
    }
}
