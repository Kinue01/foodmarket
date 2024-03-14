package com.tverd.foodmarket.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.*
import com.tverd.foodmarket.R
import com.tverd.foodmarket.adapter.ProductAdapter
import com.tverd.foodmarket.databinding.ActivityMainBinding
import com.tverd.foodmarket.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val vm by viewModel<HomeViewModel>()
    private val productAdapter by lazy { ProductAdapter(findNavController()) }

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lm = FlexboxLayoutManager(context, FlexDirection.ROW)
        lm.justifyContent = JustifyContent.CENTER
        lm.alignItems = AlignItems.CENTER

        binding!!.rvProduct.apply {
            layoutManager = lm
            adapter = productAdapter
        }

        vm.getProds().invokeOnCompletion {
            productAdapter.differ.submitList(vm.list.value)
        }
    }
}