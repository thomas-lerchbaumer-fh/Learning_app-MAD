package com.example.learning_app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.learning_app.navigation.MovieNav
import com.example.learning_app.screens.movies.MovieScreen
import com.example.learning_app.ui.theme.Learning_appTheme

class MainActivity : ComponentActivity() {
    override fun onStop() {
        super.onStop()
        Log.i("stateTag", "onStop");
    }

    override fun onPause(){
        super.onPause()
        Log.i("stateTag", "onPause")
    }

    override  fun onStart(){
        super.onStart()
        Log.i("stateTag", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("stateTage", "onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("stateTag", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("stateTag","onRestart")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("stateTag", "onCreate")
        setContent {
            MovieNav()
        }
    }
}

