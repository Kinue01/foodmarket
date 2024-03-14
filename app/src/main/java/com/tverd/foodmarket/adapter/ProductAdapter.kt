package com.tverd.foodmarket.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.tverd.foodmarket.databinding.ProductRowBinding
import com.tverd.foodmarket.domain.model.Product
import com.tverd.foodmarket.presentation.home.HomeFragmentDirections
import com.tverd.foodmarket.remote.utils.Constants

class ProductAdapter(
    private val controller: NavController
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private lateinit var binding: ProductRowBinding

    inner class ViewHolder(private val controller: NavController) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Product) {
            binding.apply {
                tvTitle.text = item.prod_title
                tvPrice.text = item.prod_price.toString()
                imgProd.load(Constants.IMG_URL + item.prod_image) {
                    scale(Scale.FILL)
                    crossfade(true)
                }
                imgService.load(Constants.IMG_URL + item.prod_service.service_image) {
                    scale(Scale.FILL)
                    crossfade(true)
                }
                binding.root.setOnClickListener {
                    controller.navigate(HomeFragmentDirections.actionHomeFragmentToProdViewFragment(item.prod_id))
                }
            }
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ProductAdapter.ViewHolder {
        val view = LayoutInflater.from(p0.context)
        binding = ProductRowBinding.inflate(view, p0, false)
        return ViewHolder(controller)
    }

    override fun onBindViewHolder(p0: ProductAdapter.ViewHolder, p1: Int) {
        p0.bind(differ.currentList[p1])
    }

    override fun getItemCount(): Int = differ.currentList.size

    private val differCallback = object : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(p0: Product, p1: Product): Boolean {
            return p0.prod_id == p1.prod_id
        }

        override fun areContentsTheSame(p0: Product, p1: Product): Boolean {
            return p0.prod_id == p1.prod_id
        }
    }

    val differ = AsyncListDiffer(this, differCallback)
}