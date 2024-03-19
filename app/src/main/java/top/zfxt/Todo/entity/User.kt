package top.zfxt.Todo.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey
    var id:Int=1,
    var name:String="test"
)
