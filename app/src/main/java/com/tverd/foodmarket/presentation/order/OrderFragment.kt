package com.tverd.foodmarket.presentation.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.tverd.foodmarket.R
import com.tverd.foodmarket.databinding.FragmentLoginBinding
import com.tverd.foodmarket.databinding.FragmentOrderBinding
import com.tverd.foodmarket.domain.model.Client
import com.tverd.foodmarket.domain.model.Paytype
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.E

class OrderFragment : Fragment(R.layout.fragment_order) {

    private val vm by viewModel<OrderViewModel>()
    private val args by navArgs<OrderFragmentArgs>()

    private var _binding: FragmentOrderBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentOrderBinding.inflate(layoutInflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.getTypes().invokeOnCompletion {
            val types = mutableListOf<String>()
            vm.paytypes.value!!.map {
                types.add(it.typeName)
            }
            binding!!.orderPaytypeId.apply {
                adapter = ArrayAdapter(this.context, android.R.layout.simple_spinner_item, types)
                onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        vm.paytype.value = vm.paytypes.value!![position]
                    }
                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }
                }
            }
        }

        vm.checkClient().invokeOnCompletion {
            if (vm.isClient.value!!) {
                binding!!.orderFirstname.apply {
                    setText(vm.client.value!!.clientFirstName)
                    isEnabled = false
                }
                binding!!.orderLastname.apply {
                    setText(vm.client.value!!.clientLastName)
                    isEnabled = false
                }
                binding!!.orderMiddlename.apply {
                    setText(vm.client.value!!.clientMiddleName)
                    isEnabled = false
                }
                binding!!.orderPhone.apply {
                    setText(vm.client.value!!.clientPhone)
                    isEnabled = false
                }
                binding!!.orderAddress.apply {
                    setText(vm.client.value!!.clientAddress)
                }
            }
        }

        binding!!.btnAdd.setOnClickListener {
            if (args.from == 0) {
                if (vm.isClient.value!!) {
                    vm.addOrders().invokeOnCompletion {
                        Toast.makeText(context, "Заказ успешно составлен", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(OrderFragmentDirections.actionOrderFragmentToHomeFragment())
                    }
                }
                else {
                    vm.client.value = Client(
                        0,
                        "",
                        "",
                        binding!!.orderFirstname.text.toString(),
                        binding!!.orderLastname.text.toString(),
                        binding!!.orderMiddlename.text.toString(),
                        binding!!.orderPhone.text.toString(),
                        binding!!.orderAddress.text.toString()
                    )
                    vm.addOrders().invokeOnCompletion {
                        Toast.makeText(context, "Заказ успешно составлен", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(OrderFragmentDirections.actionOrderFragmentToHomeFragment())
                    }
                }
            }
            else {
                if (vm.isClient.value!!) {
                    vm.addOrder(args.id).invokeOnCompletion {
                        Toast.makeText(context, "Заказ успешно составлен", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(OrderFragmentDirections.actionOrderFragmentToHomeFragment())
                    }
                }
                else {
                    vm.client.value = Client(
                        0,
                        "",
                        "",
                        binding!!.orderFirstname.text.toString(),
                        binding!!.orderLastname.text.toString(),
                        binding!!.orderMiddlename.text.toString(),
                        binding!!.orderPhone.text.toString(),
                        binding!!.orderAddress.text.toString()
                    )
                    vm.addOrder(args.id).invokeOnCompletion {
                        Toast.makeText(context, "Заказ успешно составлен", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(OrderFragmentDirections.actionOrderFragmentToHomeFragment())
                    }
                }
            }
        }

    }

}