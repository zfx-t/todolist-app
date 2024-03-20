package top.zfxt.Todo.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_item")
data class ToDoItem(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val title:String="",
    val date:String=System.currentTimeMillis().toString(),
    var completed:Boolean=false
)
