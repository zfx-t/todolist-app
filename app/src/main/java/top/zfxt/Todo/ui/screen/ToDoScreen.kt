package top.zfxt.Todo.ui.screen

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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import top.zfxt.Todo.R
import top.zfxt.Todo.ui.component.InputBox
import top.zfxt.Todo.ui.component.ToDoList
import top.zfxt.Todo.ui.component.ToolBar
import top.zfxt.Todo.ui.theme.isDarkTheme

@Composable
fun ToDoScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(modifier = Modifier.fillMaxHeight()) {

            Image(
                painter = painterResource(id = if(isDarkTheme) R.drawable.background_night else R.drawable.background_light),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.3f)
                    .drawBehind {

                        // 定义颜色线性渐变的起始颜色和结束颜色
                        var startColor = Color(0XFF5596FF)
                        var endColor = Color(0xFFAC2DEB)
                        if (isDarkTheme) {
                            startColor = Color(0xFF3710BD)
                            endColor = Color(0XFFA42395)
                        }
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
                    .fillMaxSize()
            ) {}
        }

        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 60.dp, start = 40.dp, end = 40.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "TODO", modifier = Modifier, fontSize = 36.sp, color = Color.White
                )
                IconButton(onClick = {
                    isDarkTheme = !isDarkTheme
                }) {
                    Icon(
                        painter = painterResource(id = if(isDarkTheme) R.drawable.sun else R.drawable.moon), contentDescription = null,
                        modifier = Modifier.scale(0.5f), tint = Color.White,
                    )
                }
            }
            Spacer(modifier = Modifier.height(40.dp))

            InputBox()
            Spacer(modifier = Modifier.height(20.dp))
            ToDoList()

        }
        ToolBar(
            Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TodoScreenPreview() {
    ToDoScreen()
}
