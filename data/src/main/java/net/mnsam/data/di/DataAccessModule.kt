package net.mnsam.data.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.mnsam.data.BuildConfig

@Module
@InstallIn(SingletonComponent::class)
object DataAccessModule {

    private const val SHARED_PREFERENCES_NAME = "${BuildConfig.LIBRARY_PACKAGE_NAME}.preferences"

    @Provides
    fun provideSharedPreferences(@ApplicationContext application: Application): SharedPreferences {
        return application.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
    }
}
