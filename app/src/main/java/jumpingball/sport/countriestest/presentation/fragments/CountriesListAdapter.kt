package jumpingball.sport.countriestest.presentation.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import jumpingball.sport.countriestest.databinding.CountryItemBinding
import jumpingball.sport.countriestest.domain.model.CountryModelDomain

class CountriesListAdapter: ListAdapter<CountryModelDomain, CountriesListAdapter.CountryViewHolder>(
    object : DiffUtil.ItemCallback<CountryModelDomain>() {
    override fun areItemsTheSame(oldItem: CountryModelDomain, newItem: CountryModelDomain): Boolean {
        return ((oldItem.countryName ==newItem.countryName) && (oldItem.countryImage == newItem.countryImage))
    }

    override fun areContentsTheSame(oldItem: CountryModelDomain, newItem: CountryModelDomain): Boolean {
        return (oldItem == newItem)
    }
}) {

    var onItemClickListener:((String)->Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(CountryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            onItemClickListener?.invoke(getItem(position).countryName)
        }
        holder.apply {
            name.text = getItem(position).countryName
            Glide.with(img).load(getItem(position).countryImage).into(img)
        }
    }

    inner class CountryViewHolder(binding: CountryItemBinding):RecyclerView.ViewHolder(binding.root){
        val img = binding.countryImg
        val name = binding.countryName
    }
}

