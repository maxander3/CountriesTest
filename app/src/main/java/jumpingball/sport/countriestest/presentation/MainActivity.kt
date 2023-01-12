package jumpingball.sport.countriestest.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import jumpingball.sport.countriestest.R
import jumpingball.sport.countriestest.data.CountriesRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repositoryImpl = CountriesRepositoryImpl()
        CoroutineScope(Dispatchers.IO).launch {
            repositoryImpl.getAllCountries()
        }
    }
}
