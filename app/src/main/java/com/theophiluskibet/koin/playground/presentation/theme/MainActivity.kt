package com.theophiluskibet.koin.playground.presentation.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.theophiluskibet.koin.playground.ui.theme.KoinplaygroundTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel: UserViewModel by viewModel()

        setContent {
            KoinplaygroundTheme {
                val uiState = viewModel.uiState.collectAsState().value
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    when (uiState) {
                        is UiState.Loading -> CircularProgressIndicator(modifier = Modifier)
                        is UiState.Error -> {
                            Text(text = uiState.message)
                        }

                        is UiState.Success -> {
                            LazyColumn(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                items(uiState.data) { user ->
                                    Text(text = user.name)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KoinplaygroundTheme {
        Greeting("Android")
    }
}
