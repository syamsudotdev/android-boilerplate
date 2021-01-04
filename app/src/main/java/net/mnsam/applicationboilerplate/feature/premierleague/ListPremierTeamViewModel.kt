package net.mnsam.applicationboilerplate.feature.premierleague

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.mnsam.data.di.core.CoroutineDispatchers
import net.mnsam.data.domain.TeamDetail
import net.mnsam.data.repository.EplTeamRepository

class ListPremierTeamViewModel @ViewModelInject constructor(
    coroutineDispatchers: CoroutineDispatchers,
    private val eplTeamRepository: EplTeamRepository
) : ViewModel() {

    init {
        viewModelScope.launch(coroutineDispatchers.io()) {
            _listTeamState.postValue(eplTeamRepository.getTeamList())
        }
    }

    private val _listTeamState = MutableLiveData<List<TeamDetail>>(listOf())
    val listTeamState: LiveData<List<TeamDetail>>
        get() = _listTeamState
}
