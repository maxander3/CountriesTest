package jumpingball.sport.countriestest.data.network.api

import jumpingball.sport.countriestest.data.model.CountryModelDataItem
import retrofit2.http.GET

interface AllCountriesApi {
    @GET("all")
    suspend fun getAllCountries(): List<CountryModelDataItem>
}