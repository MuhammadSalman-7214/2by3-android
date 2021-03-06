package com.example.a2by3_android.ui.signup.mobilenumber

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.a2by3_android.R
import com.example.a2by3_android.base.BaseFragment
import com.example.a2by3_android.databinding.FragmentMobileNumberBinding
import com.example.a2by3_android.repository.EmptyRepository


class MobileNumberFragment : BaseFragment<FragmentMobileNumberBinding , EmptyRepository>() {
  private var mobileNumberCode: String = "+39"

  override fun getFragmentBinding(
    inflater: LayoutInflater,
    container: ViewGroup?
  ): FragmentMobileNumberBinding {
    return FragmentMobileNumberBinding.inflate(inflater, container, false)
  }

  override fun getRepository(): EmptyRepository {
    return EmptyRepository()
  }

  override fun onPostInit() {

    binding.ccp.setOnCountryChangeListener { selectedCountry ->
      mobileNumberCode = "+" + selectedCountry.phoneCode
    }

    binding.btnContinue.setOnClickListener {
      if (!TextUtils.isEmpty(binding.etPhoneNumber.text.toString())) {
        val phoneNumberEntered = mobileNumberCode + binding.etPhoneNumber.text.toString()
        val action = MobileNumberFragmentDirections.actionMobileNumberFragmentToMobileNumberVerificationFragment(phoneNumberEntered)
        findNavController().navigate(action)
      }
    }

    binding.ivBack.setOnClickListener {
      findNavController().navigateUp()
    }
  }


  override fun onOptionsSelected(item: MenuItem) {
  }

  override fun onActivityCreation() {
  }

}