package com.example.todoapp.room

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.todoapp.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
// This statement means that we are using junit in android component
@RunWith(AndroidJUnit4::class)
@SmallTest
class InstrumentTest {
/*
Test Runs on RAM
and it executes only on one thread that is it doenot support Concurrency

Below is the main code to build a test
 */
//    Basically to tell the junit to execute the function present in this class one after another
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var roomDatabase: TaskDatabase
    private lateinit var dao:TaskDao
    @Before
    fun setUp() {
        roomDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TaskDatabase::class.java
        ).allowMainThreadQueries().build()
        dao=roomDatabase.taskDao()
    }
    @After
    fun tearDown(){
        roomDatabase.close()
    }
    @Test
    fun insertTask()=
          runBlockingTest {
              val task=TaskEntity(id=1,task="Blaall",description = "nothing")
              dao.insertTask(task)
              val list=dao.getAllTask().getOrAwaitValue()
              assertThat(list).contains(task)
          }
    @Test
    fun deleteTask()= runBlockingTest {
        val task=TaskEntity(id=1,task="Blaall",description = "nothing")
        dao.insertTask(task)
        dao.deleteTask(task)
        val list=dao.getAllTask().getOrAwaitValue()
        assertThat(list).doesNotContain(task)
    }

}