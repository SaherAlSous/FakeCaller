package com.saher.fakecaller.ui

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.saher.fakecaller.data.RoomViewModel
import com.saher.fakecaller.ui.components.AppBar
import com.saher.fakecaller.util.RoomViewModelFactory
import com.saher.fakecaller.util.navigation.NavigationComponent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

                    val context = applicationContext
                    val roomViewModel: RoomViewModel = viewModel(
                        factory = RoomViewModelFactory(context as Application)
                    )
                Column() {
                    AppBar()
                    NavigationComponent()
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
        Greeting("Android")

}