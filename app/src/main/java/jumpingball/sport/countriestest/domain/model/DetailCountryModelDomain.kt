package jumpingball.sport.countriestest.domain.model

data class DetailCountryModelDomain(
    val countryName: String,
    val countryImage: String,
    val countryRegion: String,
    val countryCapital: String,
    val countryCurrency: List<CurrencyDomain>,
    val countryTimeZone: List<String>,
)