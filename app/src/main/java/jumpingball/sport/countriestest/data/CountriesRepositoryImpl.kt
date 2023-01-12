package jumpingball.sport.countriestest.data

import jumpingball.sport.countriestest.data.mappers.toCountryModelDomain
import jumpingball.sport.countriestest.data.mappers.toDetailCountryModelDomain
import jumpingball.sport.countriestest.data.network.ApiProvider
import jumpingball.sport.countriestest.domain.CountriesRepository
import jumpingball.sport.countriestest.domain.model.CountryModelDomain
import jumpingball.sport.countriestest.domain.model.DetailCountryModelDomain

class CountriesRepositoryImpl : CountriesRepository {
    val apiProvider = ApiProvider()
    override suspend fun getAllCountries(): List<CountryModelDomain> {
        return apiProvider.allCountriesApi().getAllCountries().toCountryModelDomain()
    }

    override suspend fun getCountryByName(name: String): DetailCountryModelDomain {
        return apiProvider.detailCountryApi().getDetailCountryByCode(name)
            .toDetailCountryModelDomain()
    }

}


