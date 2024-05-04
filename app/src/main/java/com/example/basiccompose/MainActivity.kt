package com.example.basiccompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basiccompose.ui.theme.BasicComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicComposeTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var isExpanded by remember { mutableStateOf(false) }
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(all = 4.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = if (isExpanded) 48.dp else 0.dp)
            ) {
                Text(
                    text = "Hello",
                    modifier = modifier
                )
                Text(
                    text = name,
                    modifier = modifier
                )
            }
            ElevatedButton(onClick = { /*TODO*/
                isExpanded = !isExpanded
            }) {
                Text(if (isExpanded) "Show less" else "Show more")
            }
        }
    }
}

@Composable
fun Greetings(modifier: Modifier) {
    val names = arrayOf("Trường", "Anim")
    Surface(
        modifier = modifier
    ) {
        Surface(
            modifier = Modifier.padding(all = 4.dp)
        ) {
            Column {
                for (i in names) {
                    Greeting(name = i)
                }
            }
        }

    }
}

@Composable
fun Welcome(modifier: Modifier = Modifier, callback: () -> Unit) {
    Surface(modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Welcome")
            Spacer(Modifier.padding(all = 4.dp))
            ElevatedButton(onClick = { callback() }) {
                Text("Continue")
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    var isWelcome by remember {
        mutableStateOf(true)
    }
    if (isWelcome) {
        Welcome(modifier, callback = {
            isWelcome = false
        })
    } else {
        Greetings(modifier)
    }

}

@Preview(showBackground = true, widthDp = 320, heightDp = 480)
@Composable
fun MyAppPreview() {
    BasicComposeTheme {
        MyApp()
    }
}