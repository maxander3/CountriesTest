package jumpingball.sport.countriestest.presentation.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jumpingball.sport.countriestest.data.CountriesRepositoryImpl
import jumpingball.sport.countriestest.domain.model.CountryModelDomain
import kotlinx.coroutines.launch

class CountriesListViewModel(): ViewModel() {

    val repository:CountriesRepositoryImpl = CountriesRepositoryImpl()
    //TODO

    private val _listCountries = MutableLiveData<List<CountryModelDomain>>()
    val listCountries:LiveData<List<CountryModelDomain>> get() = _listCountries

    private val _error = MutableLiveData<Unit>()
    val error:LiveData<Unit> get() = _error
    init {
        getAllCountries()
    }

    fun getAllCountries(){
        viewModelScope.launch {
            try{
                _listCountries.postValue(repository.getAllCountries())
            }catch (e:Throwable){
                _error.postValue(Unit)
            }
        }
    }
}