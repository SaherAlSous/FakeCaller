package com.saher.fakecaller.ui.components.contactpage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.saher.fakecaller.R
import com.saher.fakecaller.util.navigation.NavGraph

@Composable
fun ContactPageBar(navController: NavController) {
    TopAppBar(
        title = { Text(text = "Contact") },
        backgroundColor = Color.LightGray,
        modifier = Modifier.layoutId("contactBar"),
        navigationIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_back_24),
                contentDescription = "Settings",
                modifier =
                Modifier
                    .padding(start = 15.dp)
                    .clickable { navController.navigate(NavGraph.Destinations.home) }
            )
        }
    )
}