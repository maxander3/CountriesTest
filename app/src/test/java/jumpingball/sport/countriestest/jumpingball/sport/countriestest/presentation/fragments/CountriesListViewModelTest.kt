package jumpingball.sport.countriestest.jumpingball.sport.countriestest.presentation.fragments

import androidx.arch.core.executor.ArchTaskExecutor
import androidx.arch.core.executor.TaskExecutor
import jumpingball.sport.countriestest.domain.CountriesRepository
import jumpingball.sport.countriestest.domain.model.CountryModelDomain
import jumpingball.sport.countriestest.presentation.fragments.CountriesListViewModel
import kotlinx.coroutines.Dispatchers.Unconfined
import kotlinx.coroutines.Runnable
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.mock

class CountriesListViewModelTest {

    private val repository = mock<CountriesRepository>()

    @BeforeEach
    fun beforeEach() {
        Mockito.reset(repository)
        ArchTaskExecutor.getInstance().setDelegate(object : TaskExecutor() {
            override fun executeOnDiskIO(runnable: Runnable) = runnable.run()
            override fun postToMainThread(runnable: Runnable) = runnable.run()
            override fun isMainThread(): Boolean = true
        })
    }

    @AfterEach
    fun afterEach() {
        ArchTaskExecutor.getInstance().setDelegate(null)
    }

    @Test
    fun shouldReturnAllCountries() = runBlocking {
        val listCountries = listOf(CountryModelDomain("countryName", "countryImage"))

        Mockito.`when`(repository.getAllCountries()).thenReturn(listCountries)

        val viewModel = CountriesListViewModel(repository, Unconfined)
        viewModel.getAllCountries()

        val expected = listOf(CountryModelDomain("countryName", "countryImage"))
        val actual = viewModel.listCountries.value
        viewModel.listCountries.observeForever {
            Assertions.assertEquals(expected, actual)
        }
    }

    @Test
    fun shouldReturnError() = runBlocking {
        Mockito.`when`(repository.getAllCountries()).thenReturn(any())

        val viewModel = CountriesListViewModel(repository, Unconfined)
        viewModel.getAllCountries()

        val expected = Unit
        val actual = viewModel.error.value
        viewModel.listCountries.observeForever {
            Assertions.assertEquals(expected, actual)
        }
    }
}