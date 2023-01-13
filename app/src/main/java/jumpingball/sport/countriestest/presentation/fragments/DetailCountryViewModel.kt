package jumpingball.sport.countriestest.presentation.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jumpingball.sport.countriestest.data.CountriesRepositoryImpl
import jumpingball.sport.countriestest.domain.model.DetailCountryModelDomain
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailCountryViewModel @Inject constructor(private val repository: CountriesRepositoryImpl) :
    ViewModel() {

    private val _countryData = MutableLiveData<DetailCountryModelDomain>()
    val countryData: LiveData<DetailCountryModelDomain> get() = _countryData

    private val _error = MutableLiveData<Unit>()
    val error: LiveData<Unit> get() = _error

    fun getCountryByName(name: String) {
        viewModelScope.launch {
            try {
                _countryData.postValue(repository.getCountryByName(name)[0])
            } catch (e: Throwable) {
                _error.postValue(Unit)
            }
        }
    }
}


