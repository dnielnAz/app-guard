package com.dnieln7.appguard.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.material.icons.sharp.ArrowForward
import androidx.compose.material.icons.sharp.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dnieln7.appguard.ui.theme.AppGuardTheme
import com.dnieln7.appguard.ui.theme.textDark
import com.dnieln7.appguard.ui.theme.textDark2

@ExperimentalMaterialApi
@Preview
@Composable
fun PreviewCard() {
    AppGuardTheme(darkTheme = true) {
        Surface {
            BackwardOptionCard(
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
fun ForwardOptionCard(
    title: String,
    subtitle: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
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
                contentDescription = title,
                tint = textDark
            )
            HorizontalSeparator(size = 20)
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h6.copy(
                        fontWeight = FontWeight.Normal,
                        color = textDark
                    )
                )
                VerticalSeparator(size = 5)
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.subtitle1.copy(
                        color = textDark2
                    )
                )
            }
            HorizontalSeparator(size = 10)
            Icon(
                modifier = Modifier.size(25.dp),
                imageVector = Icons.Sharp.ArrowForward,
                contentDescription = null,
                tint = textDark
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun BackwardOptionCard(
    title: String,
    subtitle: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
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
                modifier = Modifier.size(25.dp),
                imageVector = Icons.Sharp.ArrowBack,
                contentDescription = null,
                tint = textDark
            )
            HorizontalSeparator(size = 10)
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = title,
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.h6.copy(
                        fontWeight = FontWeight.Normal,
                        color = textDark
                    )
                )
                VerticalSeparator(size = 5)
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = subtitle,
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.subtitle1.copy(
                        color = textDark2
                    )
                )
            }
            HorizontalSeparator(size = 20)
            Icon(
                modifier = Modifier.size(40.dp),
                imageVector = icon,
                contentDescription = title,
                tint = textDark
            )
        }
    }
}