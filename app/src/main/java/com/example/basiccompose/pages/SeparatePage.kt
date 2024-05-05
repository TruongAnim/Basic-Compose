package com.example.basiccompose.pages

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basiccompose.R
import com.example.basiccompose.ui.theme.BasicComposeTheme
import com.example.basiccompose.ui.theme.FirstColor
import com.example.basiccompose.ui.theme.FourthColor
import com.example.basiccompose.ui.theme.SecondColor
import com.example.basiccompose.ui.theme.ThirdColor

class SeparatePage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicComposeTheme {
                SeparatePageUI()
            }
        }
    }
}

@Composable
fun Item(modifier: Modifier, color: Color, title: String, content: String) {
    Surface(
        color = color,
        modifier = modifier.fillMaxHeight(),
    ) {
        Column(
            modifier = Modifier.padding(all = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = content,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 16.sp,
                )
            )
        }
    }
}

@Composable
fun SeparatePageUI() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.weight(1f)
            ) {
                Item(
                    color = FirstColor,
                    title = stringResource(R.string.text_composable),
                    content = stringResource(
                        R.string.separate_content
                    ),
                    modifier = Modifier.weight(1f),
                )
                Item(
                    color = SecondColor,
                    title = stringResource(R.string.text_composable),
                    content = stringResource(
                        R.string.separate_content
                    ),
                    modifier = Modifier.weight(1f),
                )
            }
            Row(
                modifier = Modifier.weight(1f)
            ) {
                Item(
                    color = ThirdColor,
                    title = stringResource(R.string.text_composable),
                    content = stringResource(
                        R.string.separate_content
                    ),
                    modifier = Modifier.weight(1f),
                )
                Item(
                    color = FourthColor,
                    title = stringResource(R.string.text_composable),
                    content = stringResource(
                        R.string.separate_content
                    ),
                    modifier = Modifier.weight(1f),
                )
            }
        }

    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 480)
@Composable
fun PreviewSeparatePageUI() {
    BasicComposeTheme {
        SeparatePageUI()
    }
}

@Preview(showBackground = true, widthDp = 320 / 2, heightDp = 480 / 2)
@Composable
fun PreviewItem() {
    BasicComposeTheme {
        Item(color = FirstColor, title = "Title", content = "Content", modifier = Modifier)
    }
}