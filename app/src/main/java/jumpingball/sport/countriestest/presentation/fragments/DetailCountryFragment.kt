package jumpingball.sport.countriestest.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import jumpingball.sport.countriestest.R
import jumpingball.sport.countriestest.databinding.FragmentDetailCountryBinding
import jumpingball.sport.countriestest.presentation.toCurrencyString
import jumpingball.sport.countriestest.presentation.toTimeZoneString

@AndroidEntryPoint
class DetailCountryFragment : Fragment() {

    private val viewModel: DetailCountryViewModel by viewModels()

    private var _binding: FragmentDetailCountryBinding? = null
    private val binding get() = _binding!!
    private var countryNameArgs: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        countryNameArgs = arguments?.getString(COUNTRY_NAME_KEY).toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentDetailCountryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCountryByName(countryNameArgs)
        binding.detailBtnBack.setOnClickListener {
            findNavController().navigate(R.id.countriesListFragment)
        }
        viewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), R.string.error_message, Toast.LENGTH_LONG).show()
        }
        viewModel.countryData.observe(viewLifecycleOwner) {
            binding.apply {
                detailCountryNameTv.text =
                    String.format(requireContext().getString(R.string.country_name),
                        countryNameArgs)
                Glide.with(requireContext()).load(it.countryImage).into(detailCountryImg)
                detailCountryCapitalTv.text =
                    String.format(requireContext().getString(R.string.country_capital),
                        it.countryCapital)
                detailCountryRegionTv.text =
                    String.format(requireContext().getString(R.string.country_region),
                        it.countryRegion)
                detailCountryCurrencyTv.text =
                    String.format(requireContext().getString(R.string.country_currency),
                        it.countryCurrency.toCurrencyString())
                detailCountryTimezoneTv.text =
                    String.format(requireContext().getString(R.string.country_timezone),
                        it.countryTimeZone.toTimeZoneString())
            }
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    companion object {
        const val COUNTRY_NAME_KEY = "country_name"
    }

}