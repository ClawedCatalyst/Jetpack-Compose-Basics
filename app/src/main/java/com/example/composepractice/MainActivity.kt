package com.example.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EnterText()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, widthDp = 200, heightDp = 300)
@Composable
private fun PreviewFunction() {
    Column {
        ListViewItem(R.drawable.test_img, "Suhail", "Software Developer")
        ListViewItem(R.drawable.test_img, "Suhail", "Software Developer")
        ListViewItem(R.drawable.test_img, "Suhail", "Software Developer")
        ListViewItem(R.drawable.test_img, "Suhail", "Software Developer")
    }
}

@Composable
fun ListViewItem(imgId: Int, name: String, occupation: String) {
    Row(Modifier.padding(8.dp)) {
        Image(
            painter = painterResource(id = imgId),
            contentDescription = "This is a test image",
            Modifier.size(40.dp)
        )

        Column {
            Text(text = name, fontWeight = FontWeight.Bold)
            Text(text = occupation, fontWeight = FontWeight.Thin, fontSize = 12.sp)
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterText() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(100.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val state = remember { mutableStateOf("") }
        TextField(value = state.value, onValueChange = {
            state.value = it
        }, label = { Text(text = "Enter some text") })

        Text(text = "Hello this is a text", fontSize = 22.sp)

        Box(Modifier.size(300.dp, 300.dp), contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(
                    id = R.drawable.test_img
                ), contentDescription = "this is a test image"
            )
            Text(text = "This is text over test image")
        }
    }
}

