package top.zfxt.Todo.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import top.zfxt.Todo.R

@Composable
fun ToDoList() {
    LazyColumn() {
        items(4){
            if(it==0){

                ToDoItem(Modifier.clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)))
            }else {
                ToDoItem()
            }
        }
        item {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .padding(horizontal = 120.dp)
                        .shadow(20.dp)
                        .clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
                        .background(Color.White),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "5 items left", modifier = Modifier.padding(start = 30.dp))
                    Text(text = "Clear Completed", modifier = Modifier.padding(end = 30.dp))
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