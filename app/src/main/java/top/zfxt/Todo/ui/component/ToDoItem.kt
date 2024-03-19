package top.zfxt.Todo.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
fun ToDoItem(modifier: Modifier=Modifier,isEditing: Boolean = false) {


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 120.dp)
                .shadow(20.dp)
                .then(modifier)
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 30.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.oval),
                    contentDescription = null,
                    tint = Color.Cyan,
                    modifier = Modifier.scale(1.2f)
                )
                Spacer(modifier = Modifier.width(10.dp))
                if (isEditing) {
                    TextField(value = "", onValueChange = {})
                } else {
                    Text("Create a new todo…")
                }

            }
        }

}


@Preview
@Composable
fun ToDoItemPreview() {
    ToDoItem()
}