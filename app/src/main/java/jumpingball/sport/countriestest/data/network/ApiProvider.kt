package jumpingball.sport.countriestest.data.network

import jumpingball.sport.countriestest.data.network.api.AllCountriesApi
import jumpingball.sport.countriestest.data.network.api.DetailCountryApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiProvider {
    private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun allCountriesApi(): AllCountriesApi = retrofit.create(AllCountriesApi::class.java)

    fun detailCountryApi(): DetailCountryApi = retrofit.create(DetailCountryApi::class.java)

    companion object {
        private const val BASE_URL = "https://restcountries.com/v2/"
    }
}