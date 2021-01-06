package net.mnsam.data.repository.premierleague

import kotlinx.coroutines.withContext
import net.mnsam.core.CoroutineDispatchers
import net.mnsam.data.di.qualifier.PlainRetrofit
import net.mnsam.data.domain.TeamDetail
import net.mnsam.data.mapper.toTeamDetails
import net.mnsam.data.remote.epl.EplApiService
import net.mnsam.data.repository.premierleague.EplTeamRepository
import retrofit2.Retrofit
import javax.inject.Inject

class EplTeamRepositoryImpl @Inject constructor(
    private val coroutineDispatchers: CoroutineDispatchers,
    @PlainRetrofit private val retrofit: Retrofit
) : EplTeamRepository {

    private var cacheTeamList: List<TeamDetail> = listOf()

    override suspend fun getTeamList(): List<TeamDetail> {
        val response = retrofit.create(EplApiService::class.java)
            .getTeamsInLeague("1", "English Premier League")
        return withContext(coroutineDispatchers.default()) {
            cacheTeamList = response.teams.toTeamDetails()
            cacheTeamList
        }
    }

    override suspend fun searchTeamByName(query: String): List<TeamDetail> {
        return withContext(coroutineDispatchers.default()) {
            cacheTeamList.filter { teamDetail -> teamDetail.name.contains(query) }
        }
    }
}
