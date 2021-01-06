package net.mnsam.data.remote.epl

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LeagueTeamResponse(@Json(name = "teams") val teams: List<TeamDetailResponse>)
