package top.zfxt.Todo.ui.screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
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
        Column(modifier = Modifier.fillMaxHeight()) {
                Image(
                    painter = painterResource(id = R.drawable.todo_light),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(0.3f)
                        .drawBehind {
                            // 定义颜色线性渐变的起始颜色和结束颜色
                            val startColor = Color(0XFF5596FF)
                            val endColor = Color(0xFFAC2DEB)
                            // 创建颜色线性渐变Brush对象
                            val linearGradientBrush = Brush.linearGradient(
                                colors = listOf(startColor, endColor),
                                start = Offset(Float.POSITIVE_INFINITY, 0f),
                                end = Offset(0f, Float.POSITIVE_INFINITY),

                                )
                            drawRect(
                                brush = linearGradientBrush,
                                size = size,
                            )
                        }
                        .alpha(0.4f),
                    contentScale = ContentScale.Crop,
                    )
            Column(
                modifier = Modifier
                    .weight(0.63f)
                    .background(Color(0XFFF7F7F8))
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

            ToDoItem(Modifier.clip(RoundedCornerShape(10.dp)))
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
