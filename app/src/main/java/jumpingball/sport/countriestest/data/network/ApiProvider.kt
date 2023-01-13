package jumpingball.sport.countriestest.data.network

import jumpingball.sport.countriestest.data.network.api.AllCountriesApi
import jumpingball.sport.countriestest.data.network.api.DetailCountryApi
import retrofit2.Retrofit
import javax.inject.Inject

class ApiProvider @Inject constructor(private val retrofit: Retrofit) {

    fun allCountriesApi(): AllCountriesApi = retrofit.create(AllCountriesApi::class.java)

    fun detailCountryApi(): DetailCountryApi = retrofit.create(DetailCountryApi::class.java)
}