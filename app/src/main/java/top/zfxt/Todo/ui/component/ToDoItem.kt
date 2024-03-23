package top.zfxt.Todo.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import top.zfxt.Todo.R

@Composable
fun ToDoItem(
    modifier: Modifier = Modifier,
    isEditing: Boolean = false,
    completed: Boolean = false,
    id: Int = 0,
    text: String = "",
    onTextChange: (String) -> Unit = {},
    onAdd: () -> Unit = {},
    onFinish: (Int) -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(horizontal = 40.dp)
            .shadow(5.dp)
            .then(modifier)
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 10.dp)
        ) {
            Icon(
                painter = painterResource(id = if (completed) R.drawable.oval_do else R.drawable.oval),
                contentDescription = null,
                tint = if(completed) Color.White else Color.Gray,
                modifier = Modifier
                    .scale(0.8f)
                    .clickable {
                        if (!isEditing) {
                            onFinish(id)
                        }
                    }
                    .then(
                        if (completed) Modifier.scale(1.2f).background(
                            // 创建颜色线性渐变Brush对象
                            brush = Brush.linearGradient(
                                colors = listOf(Color(0XFF5596FF), Color(0xFFAC2DEB)),
                                start = Offset(Float.POSITIVE_INFINITY, 0f),
                                end = Offset(0f, Float.POSITIVE_INFINITY),
                            ), shape = CircleShape
                        ) else Modifier.background(Color.White)
                    ))




            Spacer(modifier = Modifier.width(10.dp))
            if (isEditing) {
                BasicTextField(value = text, onValueChange = onTextChange, singleLine = true,

                    decorationBox = { innerTextField ->

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(modifier = Modifier.scale(1.1f)) {
                                if (text.isEmpty()) Text(
                                    text = "Create a new todo...", color = Color.Gray
                                )
                                innerTextField()
                            }
                            if (text.isNotEmpty()) {
                                Icon(painter = painterResource(id = R.drawable.add),
                                    contentDescription = null,
                                    tint = Color.Gray,
                                    modifier = Modifier
                                        .scale(0.4f)
                                        .clickable { onAdd() })
                            }

                        }

                    })
            } else {
                Text(
                    text,
                    fontSize = 13.sp,
                    textDecoration = if (completed) TextDecoration.LineThrough else TextDecoration.None,

                )
            }

        }
    }

}


@Preview
@Composable
fun ToDoItemPreview() {
    ToDoItem(isEditing = true)
}