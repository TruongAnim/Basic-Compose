package com.example.basiccompose.pages

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basiccompose.R
import com.example.basiccompose.ui.theme.BasicComposeTheme

class NewsPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicComposeTheme {
                NewsPageUI()
            }
        }
    }
}

@Composable
fun NewsPageUI() {
    val banner = painterResource(id = R.drawable.bg_compose_background)
    Surface {
        Column {
            Image(painter = banner, contentDescription = null)
            Text(
                text = stringResource(id = R.string.news_page_title),
                modifier = Modifier.padding(all = 16.dp),
                style = MaterialTheme.typography.headlineMedium.copy(fontSize = 24.sp)
            )
            Text(
                text = stringResource(R.string.news_page_content_1),
                modifier = Modifier.padding(horizontal =  16.dp),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Justify
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.news_page_content_2),
                modifier = Modifier.padding(horizontal =  16.dp),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 480)
@Composable
fun PreviewNewsPageUI() {
    BasicComposeTheme {
        NewsPageUI()
    }
}