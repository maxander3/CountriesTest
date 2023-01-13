package jumpingball.sport.countriestest.domain

import jumpingball.sport.countriestest.domain.model.CountryModelDomain
import jumpingball.sport.countriestest.domain.model.DetailCountryModelDomain

interface CountriesRepository {
    suspend fun getAllCountries(): List<CountryModelDomain>

    suspend fun getCountryByName(name: String): List<DetailCountryModelDomain>
}