package net.mnsam.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EplApiService {

    @GET("{API_KEY}/search_all_teams.php")
    suspend fun getTeamsInLeague(
        @Path("API_KEY") apiKey: String,
        @Query("l", encoded = false) leagueName: String
    ): LeagueTeamResponse
}
