package com.saher.fakecaller.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.saher.fakecaller.data.RoomViewModel
import com.saher.fakecaller.util.navigation.NavigationComponent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = applicationContext
            val roomViewModel: RoomViewModel = viewModel()
            val navController = rememberNavController()
            Column(modifier = Modifier.fillMaxSize()) {
                    NavigationComponent(roomViewModel, context, navController)
                }
        }
    }
}