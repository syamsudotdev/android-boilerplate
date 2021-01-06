package net.mnsam.applicationboilerplate.feature.premierleague

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.mnsam.core.CoroutineDispatchers
import net.mnsam.data.domain.TeamDetail
import net.mnsam.data.repository.premierleague.EplTeamRepository

class ListPremierTeamViewModel @ViewModelInject constructor(
    private val coroutineDispatchers: CoroutineDispatchers,
    private val eplTeamRepository: EplTeamRepository
) : ViewModel() {

    init {
        viewModelScope.launch(coroutineDispatchers.io()) {
            cacheTeamDetails = eplTeamRepository.getTeamList()
            _listTeamState.postValue(cacheTeamDetails)
        }
    }

    private var cacheTeamDetails = listOf<TeamDetail>()
    private val _listTeamState = MutableLiveData<List<TeamDetail>>(listOf())
    val listTeamState: LiveData<List<TeamDetail>>
        get() = _listTeamState

    fun searchTeamName(query: String?) {
        if (!query.isNullOrBlank()) {
            viewModelScope.launch(coroutineDispatchers.default()) {
                _listTeamState.postValue(eplTeamRepository.searchTeamByName(query))
            }
        } else {
            _listTeamState.value = cacheTeamDetails
        }
    }
}
