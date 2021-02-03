package com.example.retrofit157_1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit157_1.pojo.MarsTerrain
import kotlinx.coroutines.launch

class MarsViewModel : ViewModel() {

    private val repository: MarsRepository

    init {
        repository = MarsRepository()
         viewModelScope.launch {
            repository.getTerrainWithCoroutines()
        }
    }

    //Voy a observar en las vistas y realizara la solicitud de datos.
    fun getFetchTerrains() :LiveData<List<MarsTerrain>> {
        return repository.fetchMarsTerrainEnqueue()
    }

    fun getFetchTerrainsWithCoroutines() :LiveData<List<MarsTerrain>> {
      return repository.liveDataMarsTerrain
    }

}