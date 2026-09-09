package com.wcrm.core.domain.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * ماژول Dependency Injection مربوط به لایه Domain.
 *
 * این لایه محل تعریف وابستگی‌های مربوط به UseCaseها است.
 * Domain نباید به UI یا Database وابسته باشد و فقط قراردادهای
 * مورد نیاز برای اجرای منطق کسب‌وکار را نگه می‌دارد.
 *
 * با رشد پروژه، Provider یا Bindingهای مربوط به UseCaseها
 * در این Module اضافه می‌شوند.
 */
@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    // Providerهای UseCase در زمان اضافه شدن سرویس‌های Domain قرار می‌گیرند.
}
