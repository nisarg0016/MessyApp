package com.example.first

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RenderHome(newPadd: PaddingValues, screenWidth: Dp) {
    Row(modifier = Modifier.padding(newPadd), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier.size(width = (screenWidth - 40.dp) / 2, height = 200.dp),
            onClick = {/*TODO*/ },
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Row(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.AccountCircle,
                        contentDescription = "Account"
                    )
                    Text(text = "Account", textAlign = TextAlign.Center)
                }
            }
        }
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier.size(width = (screenWidth - 40.dp) / 2, height = 200.dp),
            onClick = {/*TODO*/ },
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Row(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.ShoppingCart,
                        contentDescription = "Buy"
                    )
                    Text(text = "Buy", textAlign = TextAlign.Center)
                }
            }
        }
    }
}