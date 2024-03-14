package com.tverd.foodmarket.presentation.prodview

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.NumberPicker
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import coil.size.Scale
import com.tverd.foodmarket.R
import com.tverd.foodmarket.databinding.FragmentOrderBinding
import com.tverd.foodmarket.databinding.FragmentProdViewBinding
import com.tverd.foodmarket.remote.utils.Constants
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProdViewFragment : Fragment(R.layout.fragment_prod_view) {

    private val vm by viewModel<ProdViewViewModel>()
    private val args: ProdViewFragmentArgs by navArgs()

    private var _binding: FragmentProdViewBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentProdViewBinding.inflate(layoutInflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.getProd(args.prodId).invokeOnCompletion {
            binding!!.prodName.text = vm.currProd.value!!.prod_title
            binding!!.prodPrice.text = vm.currProd.value!!.prod_price.toString()
            binding!!.prodDesc.text = vm.currProd.value!!.prod_description
            binding!!.prodImg.load(Constants.IMG_URL + vm.currProd.value!!.prod_image) {
                crossfade(true)
                scale(Scale.FILL)
            }
        }

        view.findViewById<Button>(R.id.btnAddToCart).setOnClickListener {
            vm.count.value = binding!!.prodCount.value
            vm.addToCart().invokeOnCompletion {
                Toast.makeText(context, "В корзине", Toast.LENGTH_SHORT).show()
            }
        }

        view.findViewById<Button>(R.id.btnBuy).setOnClickListener {
            vm.count.value = binding!!.prodCount.value
            vm.addToCart().invokeOnCompletion {
                findNavController().navigate(ProdViewFragmentDirections.actionProdViewFragmentToOrderFragment(1, vm.currProd.value!!.prod_id))
            }
        }
    }
}