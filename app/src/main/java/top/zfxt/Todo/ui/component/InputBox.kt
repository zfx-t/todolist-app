package top.zfxt.Todo.ui.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import top.zfxt.Todo.ui.viewmodel.InputBoxViewModel

@Composable
fun InputBox(vm:InputBoxViewModel= koinViewModel()) {
    ToDoItem(Modifier.clip(RoundedCornerShape(10.dp)),true, text = vm.text,vm::onChangeText, vm::addToList)
}