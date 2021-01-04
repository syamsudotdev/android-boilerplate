package net.mnsam.applicationboilerplate.feature.premierleague

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import net.mnsam.applicationboilerplate.databinding.ListTeamFragmentBinding

@AndroidEntryPoint
class ListPremierTeamFragment : Fragment() {

    private var _listTeamFragmentBinding: ListTeamFragmentBinding? = null
    private val listTeamFragmentBinding: ListTeamFragmentBinding
        get() = _listTeamFragmentBinding!!
    private val listPremierTeamViewModel: ListPremierTeamViewModel by activityViewModels()
    private lateinit var premierTeamAdapter: PremierTeamAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        premierTeamAdapter = PremierTeamAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _listTeamFragmentBinding = ListTeamFragmentBinding.inflate(inflater, container, false)
        listTeamFragmentBinding.rvListTeam.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = premierTeamAdapter
        }
        return listTeamFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listPremierTeamViewModel.listTeamState.observe(viewLifecycleOwner) { teamDetails ->
            if (teamDetails != null) premierTeamAdapter.setList(teamDetails)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _listTeamFragmentBinding = null
    }
}
