package net.mnsam.data.remote.epl

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TeamDetailResponse(
    @Json(name = "idTeam")
    val idTeam: String,
    @Json(name = "strTeam")
    val strTeam: String,
    @Json(name = "strTeamBadge")
    val strTeamBadge: String,
    @Json(name = "strStadium")
    val strStadium: String,
    @Json(name = "strStadiumLocation")
    val strStadiumLocation: String,
    @Json(name = "strDescriptionEN")
    val strDescriptionEn: String,
)
