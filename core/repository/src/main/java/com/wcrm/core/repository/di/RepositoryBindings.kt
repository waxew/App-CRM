package com.wcrm.core.repository.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryBindings {
    // Repository bindings will be added when implementations are connected.
}
