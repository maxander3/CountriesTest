package jumpingball.sport.countriestest


import jumpingball.sport.countriestest.domain.CountriesRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock


class ExampleUnitTest {

    val repository = mock<CountriesRepository>()


    @Test
    fun shouldReturnCorrectData() {
        repository

        assertEquals(4, 2 + 2)
    }
}