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
 * Need to add logic for tests to pass, especially fetchBucketListItemFunction!!
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

    //Checking to make sure a GPS coordinate search returns something, once we have data
    //We can change it to search for specific coordinate & result
    /*@Test
   fun searchForHikingAndGPSCoordinates_returnsGreaterThan0(){
       givenAFeedOfBucketListDataAreAvailable()
       // whenSearchForHikingAndGPSCoordinates()
       thenResultIsGreaterThan0()
   }*/


    /* private fun whenSearchForHikingAndGPSCoordinates() {
         mvm.fetchBucketListItem("GPSCoordinates", "Hiking")
     }

     private fun thenResultIsGreaterThan0() {
         var resultIsGreaterThan0 = false;
         mvm.bucketlistitems.observeForever{
             assertNotNull(it)
             if (it.size > 0){
             resultIsGreaterThan0 = true;
         }
         assertTrue(resultIsGreaterThan0)
     }*/

    //Checking to make sure a generic search brings up results
    /*@Test
   fun searchForCincinnati_returnsListContainingBarsAndHiking(){
       givenAFeedOfBucketListDataAreAvailable()
       // whenSearchForCincinnati()
       thenResultContainsBarsAndHiking()
   }*/


    /* private fun whenSearchForCincinnati() {
         mvm.fetchBucketListItem("Cincinnati", "*")
     }

     private fun thenResultContainsBarsAndHiking() {
        var BarsAndHikingFound = false;
        mvm.bucketlistitems.observeForever{
            assertNotNull(it)
            assertTrue(it.size > 0)
            it.forEach{
                if (it.category.contains("Bars") && it.category.contains("Hiking")){
                    BarsAndHikingFound = true;
                }
            }
        }
        assertTrue(BarsAndHikingFound)
    }*/
   /* @Test
    fun searchForGarbage_returnsNothing(){
        givenAFeedOfBucketListDataAreAvailable()
        //whenISearchForGarbage()
        thenIGetZeroResults()
    }

    /*private fun whenISearchForGarbage() {
        mvm.fetchBucketListItem("ksdajhf")
    }*/

    private fun thenIGetZeroResults() {
        mvm.bucketlistitems.observeForever {
            assertEquals(0, it.size)
        }
    }*/
}