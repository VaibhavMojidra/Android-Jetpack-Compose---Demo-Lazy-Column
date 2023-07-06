package com.vaibhavmojidra.androidjetpackcomposedemolazycolumn

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.vaibhavmojidra.androidjetpackcomposedemolazycolumn.ui.theme.AndroidJetpackComposeDemoLazyColumnTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidJetpackComposeDemoLazyColumnTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LazyColumnDemo{
                        Toast.makeText(this,it,Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    @Composable
    fun LazyColumnDemo(selectItem:(String)->(Unit)) {
        LazyColumn{
            items(100){
                Text("List Item $it",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(5.dp).clickable {
                        selectItem("$it item selected")
                    }
                )
                Divider(color = Color.DarkGray, thickness = 1.dp)

            }
        }
    }
}
