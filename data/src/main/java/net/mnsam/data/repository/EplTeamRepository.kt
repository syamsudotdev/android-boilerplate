package net.mnsam.data.repository

import net.mnsam.data.domain.TeamDetail

interface EplTeamRepository {

    suspend fun getTeamList(): List<TeamDetail>
}
