package edu.iesam.loginexam1eval.features.user.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer

class SignInFragment : Fragment() {

    private lateinit var sigInFactory: UserFactory
    private lateinit var signInViewModel: SignInViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sigInFactory = UserFactory(requireContext())
        signInViewModel = sigInFactory.buildSignInViewModel()
        setUpObserver()
    }

    fun setUpObserver() {
        val observer = Observer<SignInViewModel.UiState> {

        }
        signInViewModel.uiState.observe(viewLifecycleOwner, observer)
    }
}