import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities=arrayOf(BucketItem::class), version = 1)
abstract  class BucketDatabase : RoomDatabase() {
    abstract fun localBucketDAO() : ILocalBucketDAO
}