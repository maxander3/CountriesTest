package jumpingball.sport.countriestest.presentation.fragments

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jumpingball.sport.countriestest.data.CountriesRepositoryImpl
import jumpingball.sport.countriestest.domain.model.DetailCountryModelDomain
import kotlinx.coroutines.launch

class DetailCountryViewModel() : ViewModel() {

    val repositoryImpl = CountriesRepositoryImpl()
    //TODO

    private val _countryData = MutableLiveData<DetailCountryModelDomain>()
    val countryData: LiveData<DetailCountryModelDomain> get() = _countryData

    private val _error = MutableLiveData<Unit>()
    val error: LiveData<Unit> get() = _error
    fun getCountryByName(name: String) {
        viewModelScope.launch {
            try {
                _countryData.postValue(repositoryImpl.getCountryByName(name)[0])
            } catch (e: Throwable) {
                _error.postValue(Unit)
            }
        }
    }
}


