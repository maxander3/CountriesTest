package jumpingball.sport.countriestest.presentation.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import jumpingball.sport.countriestest.R
import jumpingball.sport.countriestest.data.CountriesRepositoryImpl
import jumpingball.sport.countriestest.databinding.FragmentCountriesListBinding
import jumpingball.sport.countriestest.domain.model.CountryModelDomain
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CountriesListFragment : Fragment() {

    private var _binding:FragmentCountriesListBinding? = null
    private val binding get() = _binding!!
    lateinit var adapter: CountriesListAdapter

    private val viewModel:CountriesListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentCountriesListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = CountriesListAdapter()
        binding.countriesRv.adapter = adapter
        viewModel.listCountries.observe(viewLifecycleOwner){
            adapter.submitList(it)
            adapter.onItemClickListener = {countryName->
                findNavController().navigate(R.id.detailCountryFragment,Bundle().apply{
                    putString(DetailCountryFragment.COUNTRY_NAME_KEY,countryName)
                })
            }
        }
        viewModel.error.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), R.string.error_message,Toast.LENGTH_LONG).show()
        }
        binding.updateCountriesBtn.setOnClickListener {
            viewModel.getAllCountries()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}