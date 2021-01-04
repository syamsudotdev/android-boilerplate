package net.mnsam.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.mnsam.data.BuildConfig
import net.mnsam.data.di.qualifier.PlainOkHttp
import net.mnsam.data.di.qualifier.PlainRetrofit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    @PlainOkHttp
    fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder().apply {
            if (BuildConfig.IS_PRODUCTION) {
                val logger = HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
                addNetworkInterceptor(logger)
            }
        }
        return builder.build()
    }

    @Singleton
    @Provides
    @PlainRetrofit
    fun provideRetrofit(@PlainOkHttp okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}
