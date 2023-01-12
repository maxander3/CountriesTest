package jumpingball.sport.countriestest.data.network.api

import jumpingball.sport.countriestest.data.model.CountryModelDataItem
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailCountryApi {
    @GET("name/{code}")
    suspend fun getDetailCountryByCode(
        @Path("name") name: String,
    ): CountryModelDataItem
}