package dev.mkao.tut

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.mkao.tut.ui.theme.TUTTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TUTTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DemoScreen()
                }
            }
        }
    }

    @Composable
    fun DemoScreen() {
        val modifier = Modifier
            .border(width = 2.dp, color = Color.Yellow)
            .padding(all = 10.dp)
        val modifier2 = Modifier
            .border(width = 4.dp, color = Color.Green)
            .padding(20.dp)
        Column(
            Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "Hello Mkao Mwakuni",
                modifier= modifier,
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraLight
            )
              Spacer(Modifier.height(12.dp))
            Text(
                "Men from Mars",
                modifier.then(modifier2)
            )
            
            Spacer(Modifier.height(16.dp))
            CustomImage(R.drawable.nhif)
        }
    }


    @Composable
    fun CustomText(name: String, fontWeight: FontWeight, color: Color) {
        Text(text = name, fontWeight = fontWeight, color = color)
    }


    @Composable
    fun SwitchNow() {
        //states checked and unchecked
        val checked = remember {
            mutableStateOf(true)
        }
        Column {
            Switch(checked = checked.value, onCheckedChange = {
                checked.value = it
            })
            if (checked.value) {
                Text("Switch No")
            } else {
                Text("Switch Off")
            }

        }
    }

    //Adding modifier support to a composable
    @Composable
    fun CustomImage(image: Int, modifier: Modifier = Modifier) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun CustomTextPreview() {
        CustomText(name = "Mkao can Code", fontWeight = FontWeight.Bold, color = Color.Magenta)
    }

    //Demoscreen
    @Preview
    @Composable
    fun DemoscreenPreview(showBackground: Boolean = true) {

        DemoScreen()
    }

    //Working With Lists
    @Composable
    fun ColumList(items: List<String>) {
        Column {
            for (item in items) {
                Text(item)
                Divider(color = Color.Green)
            }
        }
    }

    @Preview
    @Composable
    fun CustomList() {
        ColumList(listOf("Mark", "Annet", "Janet", "Lazarus"))
    }

}
//CHAPTER 25. Annotated Strings and BrusHStyles
/*Annotated strings allow a text to be divided into multiple sections,
each with its own style.
 */
