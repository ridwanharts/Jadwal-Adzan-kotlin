package com.ridwanharts.jadwaladzan.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ridwanharts.jadwaladzan.data.repository.AdzanRepository

@Suppress("UNCHECKED_CAST")
class TestViewModelFactory(
    private val repository: AdzanRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun<T: ViewModel?> create(modelClass: Class<T>): T{
        return TestViewModel(repository) as T
    }
}