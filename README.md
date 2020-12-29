# Android Boilerplate

## Configuration Boilerplate
- Archive name
- Centralized library version definitions in gradle root project
- Crash reporter only enabled on development and staging build variant
- Environment configuration: development, staging, production
- Hilt dependency injection setup
- Jetpack navigation setup
- Leak canary only enabled on development and staging build variant
- OkHttp & Retrofit setup in dependency injection
  - Plain (unauthorized) - instance without authorization & authenticator
    - `@PlainOkHttp` qualifier
    - `@PlainRetrofit` qualifier
  - Authorization & Authentication - instances with authorization & authenticator
    - `@AuthOkHttp` qualifier
    - `@AuthRetrofit` qualifier
    - OkHttp empty authenticator
    - OkHttp empty auth interceptor
- R8 enabled
- SharedPreferences setup in dependency injection
- Single activity application

## TODO
- Bottom navigation with Jetpack navigation boilerplate
- MVP architecture pattern boilerplate
- Navigation drawer with Jetpack navigation boilerplate
- MVP unit testing complete sample
- MVVM unit testing complete sample

## Libraries
### Android officials
- [Hilt dependency injection](https://developer.android.com/training/dependency-injection/hilt-jetpack)
- [Jetpack navigation](https://developer.android.com/guide/navigation)
- [RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview)
- [View binding](https://developer.android.com/topic/libraries/view-binding)
- [View model](https://developer.android.com/topic/libraries/architecture/viewmodel)

### Third parties
- [Crash reporter](https://github.com/MindorksOpenSource/CrashReporter)
- [Glide image loader](https://bumptech.github.io/glide/)
- [JUnit4 framework](https://junit.org/junit4/)
- [Leak canary](https://github.com/square/leakcanary/)
- [MockK mocking kotlin library](https://mockk.io/)
- [Moshi JSON processor](https://github.com/square/moshi)
- [Retrofit](https://github.com/square/retrofit)
- [SDP dimension collection](https://github.com/intuit/sdp)
- [SSP dimension collection](https://github.com/intuit/ssp)
