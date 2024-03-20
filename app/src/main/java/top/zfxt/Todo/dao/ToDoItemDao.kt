package top.zfxt.Todo.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.MutableSharedFlow
import top.zfxt.Todo.entity.ToDoItem

@Dao
interface ToDoItemDao {


    @Query("SELECT * FROM todo_item ORDER BY id DESC")
    fun getAll(): List<ToDoItem>
    @Insert
    suspend fun insert(toDoItem: ToDoItem):Long
}