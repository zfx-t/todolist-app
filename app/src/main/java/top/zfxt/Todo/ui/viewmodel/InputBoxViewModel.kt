package top.zfxt.Todo.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import top.zfxt.Todo.dao.ToDoItemDao

import top.zfxt.Todo.entity.ToDoItem


class InputBoxViewModel(val db: ToDoItemDao) : ViewModel() {
    val shareFlow: MutableSharedFlow<Boolean> = MutableSharedFlow()


    var text by mutableStateOf("")
        private set

    fun onChangeText(text: String) {
        this.text = text
    }

    fun addToList() {
        viewModelScope.launch {
            val id = db.insert(ToDoItem(title = text))
            shareFlow.emit(true)
            Log.i("db", "插入成功，id为$id")
            text=""
        }
    }


}