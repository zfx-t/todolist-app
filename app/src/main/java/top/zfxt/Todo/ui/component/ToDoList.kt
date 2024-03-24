package top.zfxt.Todo.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.MutableSharedFlow
import org.koin.androidx.compose.koinViewModel
import top.zfxt.Todo.R
import top.zfxt.Todo.ui.viewmodel.InputBoxViewModel
import top.zfxt.Todo.ui.viewmodel.ToDoListViewModel

@Composable
fun ToDoList(
    vm: ToDoListViewModel = koinViewModel(),
    sharedFlow: MutableSharedFlow<Boolean> = koinViewModel<InputBoxViewModel>().shareFlow
) {
    LaunchedEffect(key1 = null) {
        sharedFlow.collect {
            if (it) {
                vm.refresh()
            }
        }
    }
    LazyColumn() {
        itemsIndexed(vm.todoList.sortedBy { it.completed }.filter { !it.archived }) { index, item ->
            if (index == 0) {

                ToDoItem(
                    Modifier.clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)),
                    text = item.title,
                    completed = item.completed,
                    onFinish = vm::onFinish,
                    id = item.id
                )
            } else {
                ToDoItem(
                    text = item.title,
                    completed = item.completed,
                    onFinish = vm::onFinish,
                    id = item.id
                )
            }
        }
        item {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 40.dp)
                    .shadow(5.dp)
                    .clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
                    .background(MaterialTheme.colorScheme.onBackground),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "${vm.todoSize} items",
                    modifier = Modifier.padding(start = 10.dp),
                    color = MaterialTheme.colorScheme.onTertiary
                )
                Text(
                    text = "Clear Completed",
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .clickable {
                                   vm.archive()
                        },
                    color = MaterialTheme.colorScheme.onTertiary
                )
            }


        }
        item {
            Spacer(modifier = Modifier.height(100.dp))
        }

    }
}

@Preview
@Composable
fun ToDoListPreview() {
    ToDoList()
}