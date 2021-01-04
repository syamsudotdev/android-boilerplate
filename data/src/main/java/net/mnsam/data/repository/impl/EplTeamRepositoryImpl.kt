package net.mnsam.data.repository.impl

import kotlinx.coroutines.withContext
import net.mnsam.data.di.core.CoroutineDispatchers
import net.mnsam.data.di.qualifier.PlainRetrofit
import net.mnsam.data.domain.TeamDetail
import net.mnsam.data.mapper.toTeamDetails
import net.mnsam.data.remote.EplApiService
import net.mnsam.data.repository.EplTeamRepository
import retrofit2.Retrofit
import javax.inject.Inject

class EplTeamRepositoryImpl @Inject constructor(
    private val coroutineDispatchers: CoroutineDispatchers,
    @PlainRetrofit private val retrofit: Retrofit
) : EplTeamRepository {

    override suspend fun getTeamList(): List<TeamDetail> {
        val response = retrofit.create(EplApiService::class.java)
            .getTeamsInLeague("1", "English Premier League")
        return withContext(coroutineDispatchers.default()) {
            response.teams.toTeamDetails()
        }
    }
}
