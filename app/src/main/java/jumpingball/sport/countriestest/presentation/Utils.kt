package jumpingball.sport.countriestest.presentation

import jumpingball.sport.countriestest.domain.model.CurrencyDomain


internal fun List<CurrencyDomain>.toCurrencyString(): String {
    var string = ""
    this.map {
        string += "${it.name}, ${it.symbol}"
    }
    return string
}

internal fun List<String>.toTimeZoneString() = this.filterNotNull().joinToString(", ")

