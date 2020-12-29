package net.mnsam.data.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.mnsam.data.BuildConfig
import net.mnsam.data.di.qualifier.AuthOkHttp
import net.mnsam.data.di.qualifier.AuthRetrofit
import net.mnsam.data.di.qualifier.PlainOkHttp
import net.mnsam.data.di.qualifier.PlainRetrofit
import net.mnsam.data.remote.auth.AuthInterceptor
import net.mnsam.data.remote.auth.ChallengeAuthenticator
import okhttp3.Authenticator
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NetworkModule {

    @Binds
    fun provideChallengeAuthenticator(challengeAuthenticator: ChallengeAuthenticator): Authenticator

    @Binds
    fun provideAuthInterceptor(authInterceptor: AuthInterceptor): Interceptor

    companion object {

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
        @AuthOkHttp
        fun provideAuthOkHttpClient(
            challengeAuthenticator: Authenticator,
            authInterceptor: AuthInterceptor
        ): OkHttpClient {
            val builder = OkHttpClient.Builder().apply {
                if (BuildConfig.IS_PRODUCTION) {
                    val logger = HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY)
                    addNetworkInterceptor(logger)
                }
            }
            return builder
                .authenticator(challengeAuthenticator)
                .addInterceptor(authInterceptor)
                .build()
        }

        @Singleton
        @Provides
        @PlainRetrofit
        fun provideRetrofit(@PlainOkHttp okHttpClient: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        }

        @Singleton
        @Provides
        @AuthRetrofit
        fun provideAuthRetrofit(@AuthOkHttp okHttpClient: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        }
    }
}
