package jumpingball.sport.countriestest.data

import jumpingball.sport.countriestest.data.network.ApiProvider
import jumpingball.sport.countriestest.domain.CountriesRepository
import jumpingball.sport.countriestest.domain.model.CountryModelDomain
import jumpingball.sport.countriestest.domain.model.DetailCountryModelDomain
import javax.inject.Inject

class CountriesRepositoryImpl @Inject constructor(private val apiProvider: ApiProvider) :
    CountriesRepository {

    override suspend fun getAllCountries(): List<CountryModelDomain> {
        return apiProvider.allCountriesApi().getAllCountries().toCountryModelDomain()
    }

    override suspend fun getCountryByName(name: String): List<DetailCountryModelDomain> {
        return apiProvider.detailCountryApi().getDetailCountryByCode(name)
            .toDetailCountryModelDomain()
    }

}



