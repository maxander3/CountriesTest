package jumpingball.sport.countriestest.data

import jumpingball.sport.countriestest.data.model.CountryModelDataItem
import jumpingball.sport.countriestest.data.model.CurrencyData
import jumpingball.sport.countriestest.domain.model.CountryModelDomain
import jumpingball.sport.countriestest.domain.model.CurrencyDomain
import jumpingball.sport.countriestest.domain.model.DetailCountryModelDomain

internal fun List<CountryModelDataItem>.toCountryModelDomain(): List<CountryModelDomain> {
    return map {
        it.toCountryModelDomain()
    }
}

internal fun CountryModelDataItem.toCountryModelDomain(): CountryModelDomain {
    return CountryModelDomain(countryName = this.name, countryImage = this.flags.png)
}

internal fun List<CountryModelDataItem>.toDetailCountryModelDomain(): List<DetailCountryModelDomain> {
    return map {
        it.toDetailCountryModelDomain()
    }
}


internal fun CountryModelDataItem.toDetailCountryModelDomain(): DetailCountryModelDomain {
    return DetailCountryModelDomain(countryName = this.name,
        countryImage = this.flags.png,
        countryRegion = this.region,
        countryCapital = this.capital,
        countryCurrency = this.currencies.toDomain(),
        countryTimeZone = this.timezones)
}


internal fun List<CurrencyData>.toDomain(): List<CurrencyDomain> {
    return map {
        it.toDomain()
    }
}

internal fun CurrencyData.toDomain(): CurrencyDomain {
    return CurrencyDomain(code = code, name = name, symbol = symbol)
}
