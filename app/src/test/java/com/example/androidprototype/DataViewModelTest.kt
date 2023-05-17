package com.example.androidprototype

import com.example.androidprototype.repos.MainRepo
import com.example.androidprototype.viewmodels.DataViewModel
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class DataViewModelTest {
    @Mock
    private lateinit var repo: MainRepo
    private lateinit var viewModel: DataViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        viewModel = DataViewModel(repo)
    }

    @Test
    fun `Test Validate Input Method For Empty Input`() {
        assertEquals(false, viewModel.validateInput(""))
    }

    @Test
    fun `Test Validate Input Method For Valid Input`() {
        assertEquals(true, viewModel.validateInput("Cat"))
    }

    @Test
    fun `Test Validate Input Method For Valid Input But Longer than 15 Characters`() {
        assertEquals(false, viewModel.validateInput("ABCDFGHIJKLMNOPQ"))
    }
}