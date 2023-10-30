package com.example.course

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.course.data.DataSource
import com.example.course.model.Topic
import com.example.course.ui.theme.CourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CourseApp()
                }
            }
        }
    }
}


@Composable
fun CourseApp(){
    CourseList(courseList = DataSource.topics)
}

@Preview(showBackground = true)
@Composable
fun CoursePreview() {
    CourseTheme {
        CourseCard(topics = Topic(R.string.architecture, 58, R.drawable.architecture))
    }
}

@Composable
fun CourseCard(topics : Topic,modifier: Modifier = Modifier){
    Card(modifier = Modifier.height(68.dp)) {
        Row {
            Image(
                painter = painterResource(id = topics.imageResource),
                contentDescription = stringResource(id = topics.stringResource),
                 Modifier.fillMaxHeight()
                    .width(68.dp),
                contentScale = ContentScale.Crop
            )

            Column {

                Text(
                    text = LocalContext.current.getString(topics.stringResource),
                    modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 0.dp),
                    fontSize = 12.sp
                )
                Row(modifier = Modifier
                    .padding(16.dp,8.dp,0.dp,0.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null
                    )

                    Text(text = topics.label.toString(),
                        Modifier.padding(start = 8.dp),
                        fontSize = 12.sp)
                }
            }
        }
    }

}
@Composable
fun CourseList(courseList: List<Topic>){
  LazyVerticalGrid(columns = GridCells.Fixed(2),
      verticalArrangement = Arrangement.spacedBy(8.dp),
      horizontalArrangement = Arrangement.spacedBy(4.dp),
      modifier = Modifier.padding(8.dp),content ={
          items(courseList){ topic ->
              CourseCard(topics = topic,modifier = Modifier)

          }
      }  )
}
