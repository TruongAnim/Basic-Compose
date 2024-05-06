package com.example.basiccompose.pages

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basiccompose.R
import com.example.basiccompose.ui.theme.BasicComposeTheme

class InfoPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicComposeTheme {
                InfoPageUI()
            }
        }
    }
}

@Composable
fun Info() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            color = colorResource(id = R.color.info_dark_bg),
            modifier = Modifier
                .width(120.dp)
                .height(120.dp)
        ) {
            val logo = painterResource(id = R.drawable.android_logo)
            Image(
                modifier = Modifier.padding(all = 8.dp),
                painter = logo, contentDescription = "Logo"
            )
        }
        Text(
            text = "Jennifer Doe",
            style = MaterialTheme.typography.titleLarge.copy(fontSize = 36.sp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.android_developer),
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Bold, color = colorResource(
                    id = R.color.info_primary
                )
            )
        )
    }
}

@Composable
fun ContactItem(icon: ImageVector, title: String) {
    Row(
        modifier = Modifier.padding(vertical = 6.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier
                .width(24.dp)
                .height(24.dp),
            tint = colorResource(id = R.color.info_primary)
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = title, style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
fun Contact() {
    Column {
        ContactItem(icon = Icons.Default.Phone, title = "+0987654321")
        ContactItem(icon = Icons.Default.Share, title = "@AndroidDev")
        ContactItem(icon = Icons.Default.Mail, title = "jen.doe@gmail.com")
    }
}

@Composable
fun InfoPageUI() {
    Surface(
        color = colorResource(id = R.color.info_bg).copy(alpha = 0.2f),
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Spacer(modifier = Modifier.weight(1f))
            Info()
            Spacer(modifier = Modifier.weight(1f))
            Contact()
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 480)
@Composable
fun PreviewInfoPageUI() {
    BasicComposeTheme {
        InfoPageUI()
    }
}