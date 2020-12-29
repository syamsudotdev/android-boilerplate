package net.mnsam.data.remote.auth

import android.content.SharedPreferences
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class ChallengeAuthenticator @Inject constructor(private val sharedPreferences: SharedPreferences) :
    Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? {
        return null
    }
}
