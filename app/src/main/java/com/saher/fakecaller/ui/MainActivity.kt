package com.saher.fakecaller.ui

import android.app.Application
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.ImagePainter
import com.google.accompanist.imageloading.ImageLoadState
import com.saher.fakecaller.data.RoomViewModel
import com.saher.fakecaller.util.RoomViewModelFactory
import com.saher.fakecaller.util.navigation.NavigationComponent
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
open class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = applicationContext
            val roomViewModel: RoomViewModel = viewModel()
            Column(modifier = Modifier.fillMaxSize()) {
                    NavigationComponent(roomViewModel, context)

                }
        }
    }
}