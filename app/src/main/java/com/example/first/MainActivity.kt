@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.first

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.first.ui.theme.FirstTheme
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstTheme (darkTheme = true, dynamicColor = true){
                App()
            }
        }
    }
}

@Preview
@Composable
fun App(modifier: Modifier = Modifier) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val config = LocalConfiguration.current
    val screenWidth = config.screenWidthDp.dp
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("MessyApp", modifier = Modifier.padding(16.dp))
                Divider()
                NavigationDrawerItem(
                    icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                    label = { Text(text = "Home") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                NavigationDrawerItem(
                    icon = { Icon(Icons.Filled.ShoppingCart, contentDescription = "Buy") },
                    label = { Text(text = "Buy") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
            }
        },
        gesturesEnabled = true
    ) {
        Scaffold (
            topBar = {
                TopAppBar(modifier = Modifier.fillMaxWidth(), title = { Text(text = "MessyApp", textAlign = TextAlign.Center)  }, colors = topAppBarColors(titleContentColor = MaterialTheme.colorScheme.primary))},
            content = { padding ->
                val newPadd = PaddingValues(top = padding.calculateTopPadding() + 15.dp, start = 15.dp, end = 15.dp, bottom = 15.dp)
                RenderHome(newPadd = newPadd, screenWidth = screenWidth)
            },
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    text = { Text("Show drawer") },
                    icon = { Icon(Icons.Filled.Add, contentDescription = "") },
                    onClick = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    }
                )
            }
        )
    }
}
