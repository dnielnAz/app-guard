package com.dnieln7.appguard.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.ArrowForward
import androidx.compose.material.icons.sharp.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dnieln7.appguard.ui.theme.AppGuardTheme

@ExperimentalMaterialApi
@Preview
@Composable
fun PreviewCard() {
    AppGuardTheme {
        Surface {
            OptionCard(
                title = "Home",
                subtitle = "Go to home",
                icon = Icons.Sharp.Home,
                onClick = {}
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun OptionCard(title: String, subtitle: String, icon: ImageVector, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = 5.dp,
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .height(100.dp)
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            MaterialTheme.colors.secondaryVariant,
                            MaterialTheme.colors.secondary
                        )
                    )
                )
                .padding(vertical = 10.dp, horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(40.dp),
                imageVector = icon,
                contentDescription = title
            )
            HorizontalSeparator(size = 20)
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Normal)
                )
                VerticalSeparator(size = 5)
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.subtitle1.copy(
                        color = MaterialTheme.typography.caption.color
                    )
                )
            }
            HorizontalSeparator(size = 10)
            Icon(
                modifier = Modifier.size(25.dp),
                imageVector = Icons.Sharp.ArrowForward,
                contentDescription = null
            )
        }
    }
}