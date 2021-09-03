package com.saher.fakecaller.ui

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.saher.fakecaller.data.RoomViewModel
import com.saher.fakecaller.ui.theme.FakeCallerTheme
import com.saher.fakecaller.util.RoomViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FakeCallerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val context = applicationContext
                    val roomViewModel: RoomViewModel = viewModel(
                        factory = RoomViewModelFactory(context as Application)
                    )
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
      Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FakeCallerTheme {
        Greeting("Android")
    }
}