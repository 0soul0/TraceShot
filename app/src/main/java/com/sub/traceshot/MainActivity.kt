package com.sub.traceshot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.sub.traceshot.theme.TraceShotTheme
import com.sub.traceshot.nav.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TraceShotTheme {
                App(Modifier)
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp, 8.dp, 16.dp, 0.dp)
            .background(MaterialTheme.colorScheme.background),
        bottomBar = {
            AppTabNavigation(
                allDestinations = viewScreens,
                navController = navController,
                modifier = Modifier)
        },
    ) { innerPadding ->
        AppNavHost(
            allDestinations = viewScreens,
            navController = navController,
            modifier = modifier.padding(innerPadding))
    }

}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    TraceShotTheme {
        App(Modifier)
    }
}