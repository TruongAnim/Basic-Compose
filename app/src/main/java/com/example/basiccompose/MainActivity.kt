package com.example.basiccompose

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
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
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight

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
    var isExpanded by rememberSaveable { mutableStateOf(false) }
    val extraPadding by animateDpAsState(
        targetValue = if (isExpanded) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioHighBouncy,
            stiffness = Spring.StiffnessLow
        )
    )
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
        modifier = Modifier.padding(all = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(24.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )

        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = 12.dp)
            ) {
                Text(
                    text = "Hello",
                    modifier = modifier
                )
                Text(
                    text = name,
                    modifier = modifier,
                    style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold)
                )
                if (isExpanded)
                    Text(
                        text = ("Hello hello ").repeat(30),
                        style = MaterialTheme.typography.bodySmall
                    )
            }
            IconButton(onClick = { /*TODO*/
                isExpanded = !isExpanded
            }) {
                Icon(
                    imageVector = if (isExpanded) Filled.ExpandLess else Filled.ExpandMore,
                    contentDescription = if (isExpanded) stringResource(id = R.string.show_less)
                    else stringResource(id = R.string.show_more)
                )
            }
        }
    }
}

@Composable
fun Greetings(modifier: Modifier) {
    val names = List(1000) { "$it" }
    Surface(
        modifier = modifier
    ) {
        Surface(
            modifier = Modifier.padding(all = 4.dp)
        ) {
            LazyColumn() {
                items(items = names) { name ->
                    Greeting(name = name)
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
            Text("Welcome", style = MaterialTheme.typography.headlineMedium)
            Spacer(Modifier.padding(all = 4.dp))
            ElevatedButton(onClick = { callback() }) {
                Text("Continue")
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    var isWelcome by rememberSaveable {
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

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun GreetingPreview() {
    BasicComposeTheme {
        Greeting(name = "1")
    }
}