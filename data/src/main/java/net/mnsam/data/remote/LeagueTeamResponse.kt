package net.mnsam.data.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LeagueTeamResponse(@Json(name = "teams") val teams: List<TeamDetailResponse>)
