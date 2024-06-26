package com.example.cryptocurrencyappyt.presentation.coin_list.components

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cryptocurrencyappyt.domain.model.Coin

@Composable
fun CoinListItem(
    coin : Coin,
    onItemClick: (Coin) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .clickable { onItemClick(coin) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Text(text = "${coin.rank}. ${coin.name} (${coin.symbol})",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
            )

        Text(
            text = if(coin.is_active) "active" else "inactive",
            color = if (coin.is_active) Color.Green else Color.Red,
            fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.align(CenterVertically)

        )
    }
}