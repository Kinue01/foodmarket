package com.tverd.foodmarket.presentation.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.tverd.foodmarket.R
import com.tverd.foodmarket.databinding.FragmentProdViewBinding
import com.tverd.foodmarket.databinding.FragmentRegistrationBinding
import com.tverd.foodmarket.domain.model.ClientRegistration
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegistrationFragment : Fragment(R.layout.fragment_registration) {

    private val vm by viewModel<RegistrationViewModel>()

    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentRegistrationBinding.inflate(layoutInflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding!!.btnRegister.setOnClickListener {

            vm.client.value = ClientRegistration(
                binding!!.clientFname.text.toString(),
                binding!!.clientLname.text.toString(),
                binding!!.clientPassword.text.toString(),
                binding!!.clientMname.text.toString(),
                binding!!.clientPhone.text.toString(),
                binding!!.clientAddress.text.toString(),
                binding!!.clientEmail.text.toString()
            )

            vm.addClient().invokeOnCompletion {
                findNavController().navigate(RegistrationFragmentDirections.actionRegistrationFragmentToLoginFragment())
            }
        }
    }
}