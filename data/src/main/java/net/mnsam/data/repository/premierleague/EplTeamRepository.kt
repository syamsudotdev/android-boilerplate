package net.mnsam.data.repository.premierleague

import net.mnsam.data.domain.TeamDetail

interface EplTeamRepository {

    suspend fun getTeamList(): List<TeamDetail>

    suspend fun searchTeamByName(query: String): List<TeamDetail>
}
