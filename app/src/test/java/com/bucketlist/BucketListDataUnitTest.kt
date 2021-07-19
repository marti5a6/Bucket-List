package com.bucketlist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bucketlist.ui.main.MainViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.rules.TestRule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class BucketListDataUnitTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    lateinit var mvm:MainViewModel




    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    /*@Test
    fun searchForCincinnatiAndHiking_returnsMtAiry(){
        givenAFeedOfBucketListDataAreAvailable()
       // whenSearchForHikingInCincinnati()
        thenResultContainsMtAiry()
    }
*/
    private fun givenAFeedOfBucketListDataAreAvailable() {
        mvm = MainViewModel()
    }

   /* private fun whenSearchForHikingInCincinnati() {
        mvm.fetchBucketListItem("Cincinnati", "Hiking")
    }

    private fun thenResultContainsMtAiry() {
        var mtAiryFound = false;
        mvm.bucketlistitems.observeForever{
            assertNotNull(it)
            assertTrue(it.size > 0)
            it.forEach{
                if (it.location == "cincinnati" && it.name.contains("Mt. Airy")){
                    mtAiryFound = true;
                }
            }
        }
        assertTrue(mtAiryFound)
    }*/


}