package net.mnsam.data.mapper

import net.mnsam.data.domain.TeamDetail
import net.mnsam.data.remote.epl.TeamDetailResponse

fun TeamDetailResponse.toTeamDetail(): TeamDetail {
    return TeamDetail(
        id = idTeam.toInt(),
        name = strTeam,
        home = strStadium,
        location = strStadiumLocation,
        teamDescription = strStadiumLocation,
        badgeUrl = strTeamBadge,
    )
}

fun List<TeamDetailResponse>.toTeamDetails(): List<TeamDetail> {
    val result = mutableListOf<TeamDetail>()
    forEach { result.add(it.toTeamDetail()) }
    return result
}
