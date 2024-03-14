package com.tverd.foodmarket.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tverd.foodmarket.R
import com.tverd.foodmarket.databinding.FragmentLoginBinding
import com.tverd.foodmarket.domain.model.ClientLogin
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val vm by viewModel<LoginViewModel>()

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding!!.btnLogin.setOnClickListener {
            vm.clientLog.value = ClientLogin(
                binding!!.emailInp.text.toString(),
                binding!!.passInp.text.toString()
            )

            vm.getClient().invokeOnCompletion {
                
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToAccountFragment())
            }
        }

        binding!!.btnRegister.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegistrationFragment())
        }
    }
}