package com.piyush.scribeflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.piyush.scribeflow.presentation.navigation.MediScribeNavGraph
import com.piyush.scribeflow.ui.theme.ScribeFlowTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            ScribeFlowTheme {

                MediScribeNavGraph()

            }
        }
    }
}