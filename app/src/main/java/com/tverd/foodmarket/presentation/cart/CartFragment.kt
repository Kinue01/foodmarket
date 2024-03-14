package com.tverd.foodmarket.presentation.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tverd.foodmarket.R
import com.tverd.foodmarket.adapter.CartAdapter
import com.tverd.foodmarket.databinding.FragmentAccountBinding
import com.tverd.foodmarket.databinding.FragmentCartBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CartFragment : Fragment(R.layout.fragment_cart) {

    private val vm by viewModel<CartViewModel>()
    private val cartAdapter by lazy { CartAdapter(findNavController(), vm) }

    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentCartBinding.inflate(layoutInflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding!!.rvCart.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = cartAdapter
        }

        vm.getCartItems().invokeOnCompletion {
            cartAdapter.differ.submitList(vm.prods.value)
        }

        binding!!.btnCart.setOnClickListener {
            if (vm.prods.value!!.isNotEmpty())
                findNavController().navigate(CartFragmentDirections.actionCartFragmentToOrderFragment(0, 0))
            else
                Toast.makeText(context, "Добавьте товар в корзину", Toast.LENGTH_SHORT).show()
        }
    }

}