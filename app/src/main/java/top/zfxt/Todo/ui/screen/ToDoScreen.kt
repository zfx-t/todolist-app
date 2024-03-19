package top.zfxt.Todo.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import top.zfxt.Todo.R
import top.zfxt.Todo.ui.component.ToDoItem
import top.zfxt.Todo.ui.component.ToDoList
import top.zfxt.Todo.ui.component.ToolBar

@Composable
fun ToDoScreen() {

    Box {
        Column {
            Image(
                painter = painterResource(id = R.drawable.todo_light),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.37f)
            )
            Column(
                modifier = Modifier
                    .weight(0.63f)
                    .background(Color(0xDA31D8EE))
                    .fillMaxSize()
            ) {

            }
        }
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 60.dp, start = 60.dp, end = 60.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "TODO", modifier = Modifier,
                    fontSize = 36.sp, color = Color.White
                )
                Icon(
                    painter = painterResource(id = R.drawable.moon), contentDescription = null,
                    modifier = Modifier, tint = Color.White,
                )
            }
            Spacer(modifier = Modifier.height(180.dp))
            ToDoItem()
            Spacer(modifier = Modifier.height(20.dp))
            ToDoList()
            Spacer(modifier = Modifier.height(100.dp))
            ToolBar()
        }

    }
}

@Preview(showBackground = true)
@Composable
fun TodoScreenPreview() {
    ToDoScreen()
}
