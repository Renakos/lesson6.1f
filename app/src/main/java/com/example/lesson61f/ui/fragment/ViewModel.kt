package com.example.lesson61f.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lesson61f.data.model.ExampleModel
import com.example.lesson61f.data.repo.Repository
class ViewModel:ViewModel() {
    private val repositories = Repository()
    private val _animeLiveData = MutableLiveData<List<ExampleModel>>()
    val animeLiveData:LiveData<List<ExampleModel>> = _animeLiveData

    init {
        _animeLiveData.value = repositories.list
    }

}