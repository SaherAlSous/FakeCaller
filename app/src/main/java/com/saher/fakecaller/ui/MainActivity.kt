package com.saher.fakecaller.ui

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.saher.fakecaller.data.RoomViewModel
import com.saher.fakecaller.qualifier.Navigation
import com.saher.fakecaller.util.navigation.NavigationComponent
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@AndroidEntryPoint
open class MainActivity : ComponentActivity() {

    @Inject @ApplicationContext lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Composables can't be injected?
            val roomViewModel: RoomViewModel = viewModel()
            val navController = rememberNavController()

            Column(modifier = Modifier.fillMaxSize()) {
                NavigationComponent(
                    roomViewModel = roomViewModel,
                    context = context,
                    navController = navController)
            }
        }
    }
}