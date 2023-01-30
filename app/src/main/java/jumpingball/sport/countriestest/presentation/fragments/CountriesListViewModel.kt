package jumpingball.sport.countriestest.presentation.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jumpingball.sport.countriestest.domain.CountriesRepository
import jumpingball.sport.countriestest.domain.model.CountryModelDomain
import kotlinx.coroutines.CloseableCoroutineDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class CountriesListViewModel @Inject constructor(
    private val repository: CountriesRepository,
    private val dispatcher: CoroutineContext
    ) : ViewModel() {

    private val _listCountries = MutableLiveData<List<CountryModelDomain>>()
    val listCountries: LiveData<List<CountryModelDomain>> get() = _listCountries

    private val _error = MutableLiveData<Unit>()
    val error: LiveData<Unit> get() = _error

    init {
        getAllCountries()
    }

    fun getAllCountries() {
        viewModelScope.launch(dispatcher) {
            try {
                _listCountries.postValue(repository.getAllCountries())
            } catch (e: Throwable) {
                _error.postValue(Unit)
            }
        }
    }
}