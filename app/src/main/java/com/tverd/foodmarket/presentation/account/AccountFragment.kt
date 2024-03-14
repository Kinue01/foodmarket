package com.tverd.foodmarket.presentation.account

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelStore
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.transition.Visibility
import com.tverd.foodmarket.R
import com.tverd.foodmarket.databinding.ActivityMainBinding
import com.tverd.foodmarket.databinding.FragmentAccountBinding
import com.tverd.foodmarket.domain.model.Client
import com.tverd.foodmarket.presentation.MainActivity
import com.tverd.foodmarket.presentation.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AccountFragment : Fragment(R.layout.fragment_account) {

    private val vm by viewModel<AccountViewModel>()
    private val mainVm by activityViewModels<MainViewModel>()

    private var _binding: FragmentAccountBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentAccountBinding.inflate(layoutInflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.client.observe(viewLifecycleOwner) {
            mainVm.currClient.value = it
        }

        vm.checkClient().invokeOnCompletion {
            if (vm.isClient.value == true) {
                binding!!.clientFname.text = vm.client.value!!.clientFirstName
                binding!!.clientLname.text = vm.client.value!!.clientLastName
                binding!!.clientEmail.text = vm.client.value!!.clientEmail
                binding!!.clientPhone.text = vm.client.value!!.clientPhone
                binding!!.clientAddress.text = vm.client.value!!.clientAddress
                binding!!.btnAccLogin.visibility = View.INVISIBLE
                binding!!.btnAccReg.visibility = View.INVISIBLE
                binding!!.btnLogout.visibility = View.VISIBLE
            }
            else {
                binding!!.btnAccLogin.visibility = View.VISIBLE
                binding!!.btnAccReg.visibility = View.VISIBLE
                binding!!.btnLogout.visibility = View.INVISIBLE
            }
        }

        binding!!.btnLogout.setOnClickListener {
            vm.logout().invokeOnCompletion {
                vm.client.value = Client()
                vm.isClient.value = false

                findNavController().navigate(AccountFragmentDirections.actionAccountFragmentToLoginFragment())
            }
        }

        binding!!.btnAccLogin.setOnClickListener {
            findNavController().navigate(AccountFragmentDirections.actionAccountFragmentToLoginFragment())
        }

        binding!!.btnAccReg.setOnClickListener{
            findNavController().navigate(AccountFragmentDirections.actionAccountFragmentToRegistrationFragment())
        }
    }
}