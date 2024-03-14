package com.tverd.foodmarket.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.tverd.foodmarket.databinding.CartRowBinding
import com.tverd.foodmarket.domain.model.Cart
import com.tverd.foodmarket.domain.model.Product
import com.tverd.foodmarket.presentation.cart.CartFragmentDirections
import com.tverd.foodmarket.presentation.cart.CartViewModel
import com.tverd.foodmarket.presentation.home.HomeFragmentDirections
import com.tverd.foodmarket.remote.utils.Constants

class CartAdapter(
    private val navController: NavController,
    private val vm: CartViewModel
) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    private lateinit var binding: CartRowBinding

    inner class ViewHolder(private val navController: NavController, private val vm: CartViewModel) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Cart) {
            binding.apply {
                cartProdTitle.text = item.prod_title
                cartProdPrice.text = item.prod_price.toString() + " Р"
                cartProdWeight.text = item.prod_weight.toString() + " г."
                cartProdImg.load(Constants.IMG_URL + item.prod_image) {
                    crossfade(true)
                    scale(Scale.FILL)
                }
                cartProdService.load(Constants.IMG_URL + item.prod_service.service_image) {
                    crossfade(true)
                    scale(Scale.FILL)
                }
                cartCount.text = item.prodCount.toString() + "шт"
                root.setOnClickListener{
                    navController.navigate(CartFragmentDirections.actionCartFragmentToProdViewFragment(item.prodId))
                }
                btnCancel.setOnClickListener {
                    vm.deleteCartItem(item.prodId).invokeOnCompletion {
                        vm.getCartItems().invokeOnCompletion {
                            differ.submitList(vm.prods.value)
                        }
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CartAdapter.ViewHolder {
        val view = LayoutInflater.from(p0.context)
        binding = CartRowBinding.inflate(view, p0, false)
        return ViewHolder(navController, vm)
    }

    override fun onBindViewHolder(p0: CartAdapter.ViewHolder, p1: Int) {
        p0.bind(differ.currentList[p1])
    }

    override fun getItemCount(): Int = differ.currentList.size

    private val differCallback = object : DiffUtil.ItemCallback<Cart>() {
        override fun areItemsTheSame(p0: Cart, p1: Cart): Boolean {
            return p0.prodId == p1.prodId
        }

        override fun areContentsTheSame(p0: Cart, p1: Cart): Boolean {
            return p0.prodId == p1.prodId
        }
    }

    val differ = AsyncListDiffer(this, differCallback)
}