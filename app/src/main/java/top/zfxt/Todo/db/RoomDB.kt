package top.zfxt.Todo.db

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import top.zfxt.Todo.dao.UserDao
import top.zfxt.Todo.entity.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class RoomDB : RoomDatabase() {

    //创建userDao
    abstract fun userDao(): UserDao

    companion object {
        private var INSTANCE: RoomDB? = null

        fun getInstance(context: Context): RoomDB {
            return runBlocking(Dispatchers.IO) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(context, RoomDB::class.java, "todo_db")
                        .allowMainThreadQueries()//允许在主线程操作
                        .addCallback(DbCreateCallBack())//增加回调监听
                        .addMigrations()//增加数据库迁移
                        .build()
                }
                instance
            }
        }

        private fun DbCreateCallBack(): RoomDatabase.Callback {
            return object : RoomDatabase.Callback() {
                //第一次创建数据库时调用
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    Log.d("TAG", "first onCreate db version: " + db.version)
                }
            }
        }

    }
}