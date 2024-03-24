package top.zfxt.Todo.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import top.zfxt.Todo.dao.ToDoItemDao
import top.zfxt.Todo.entity.ToDoItem

class ToDoListViewModel(val db: ToDoItemDao) : ViewModel() {
    var todoList: List<ToDoItem> by mutableStateOf(db.getAll())
        private set


    var todoSize by mutableIntStateOf(todoList.size)
        private set

    fun refresh() {
        todoList = db.getAll()
        todoSize = todoList.size
    }

    fun onFinish(id: Int) {
        viewModelScope.launch {
            todoList = todoList.map {
                if (it.id == id) it.copy(completed = !it.completed).also {
                    db.update(it)
                } else it
            }
        }

    }

    fun archive() {
        viewModelScope.launch {
            todoList.forEach { item ->
                if (item.completed) {
                    db.update(item.copy(archived = true))
                }
            }
            refresh()
        }
    }


}