import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ILocalBucketItemDAO {

    @Query("SELECT * FROM bucketitems")
    fun getAllBucketItems()  : LiveData<List<BucketItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(bucketitems: ArrayList<BucketItem>)

    @Delete
    fun delete(bucketitem: BucketItem)

    @Insert
    fun save(bucketitem: BucketItem)
}