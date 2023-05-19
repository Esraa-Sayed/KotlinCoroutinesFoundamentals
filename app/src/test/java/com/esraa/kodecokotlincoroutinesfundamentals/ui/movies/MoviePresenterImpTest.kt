package com.esraa.kodecokotlincoroutinesfundamentals.ui.movies

import android.util.Log
import com.esraa.kodecokotlincoroutinesfundamentals.domain.repository.MovieRepo
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.api.mockito.PowerMockito
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
@PrepareForTest(Log::class)
class MoviePresenterImpTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = TestCoroutineDispatcher()
    @OptIn(ExperimentalCoroutinesApi::class)
    private val testCoroutineScope = TestCoroutineScope(testDispatcher)
    private val repository = mock<MovieRepo>()
    private val view = mock<MoviesView>()

    private val presenter by lazy { MoviePresenterImp(repository) }
    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp(){
        PowerMockito.mockStatic(Log::class.java)
        Dispatchers.setMain(testDispatcher)

        presenter.setView(view)
    }

   @OptIn(ExperimentalCoroutinesApi::class)
   @Test
    fun testGetDataShowResult() = testCoroutineScope.runBlockingTest{
         //arrange
        whenever(repository.getMovies()).thenReturn(listOf())
        //act
       presenter.getData()
       advanceTimeBy(500 )
       //assert
       verify(repository).getMovies()

       verify(view).showMovies(any())
    }
}