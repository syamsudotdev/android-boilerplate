package net.mnsam.applicationboilerplate.feature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import net.mnsam.applicationboilerplate.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {

    private var _homeFragmentBinding: HomeFragmentBinding? = null
    private val homeFragmentBinding: HomeFragmentBinding
        get() = _homeFragmentBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _homeFragmentBinding = HomeFragmentBinding.inflate(inflater, container, false)
        return homeFragmentBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _homeFragmentBinding = null
    }
}
