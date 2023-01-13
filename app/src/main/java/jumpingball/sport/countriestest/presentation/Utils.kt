package jumpingball.sport.countriestest.presentation

import android.content.Context
import jumpingball.sport.countriestest.domain.model.CurrencyDomain


internal fun List<CurrencyDomain>.toCurrencyString(context: Context): String {
    return this.filterNotNull()[0].name
}

internal fun List<String>.toTimeZoneString(): String {
    return this.filterNotNull().toString()
}
