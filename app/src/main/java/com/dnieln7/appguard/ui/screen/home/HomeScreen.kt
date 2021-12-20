package com.dnieln7.appguard.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Android
import androidx.compose.material.icons.sharp.Security
import androidx.compose.material.icons.sharp.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dnieln7.appguard.ui.component.OptionCard
import com.dnieln7.appguard.ui.component.VerticalExpandableSeparator
import com.dnieln7.appguard.ui.component.VerticalSeparator
import com.dnieln7.appguard.ui.theme.AppGuardTheme

@ExperimentalMaterialApi
@Composable
fun HomeScreen() {
    Scaffold(bottomBar = {

    }) {
        Column(
            modifier = Modifier
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colors.primary,
                            MaterialTheme.colors.primaryVariant
                        )
                    )
                )
                .padding(it)
                .padding(20.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Welcome",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h5.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            )

            VerticalSeparator(size = 10)

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "What do you want to do?",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h6.copy(color = Color.White)
            )

            VerticalExpandableSeparator()

            OptionCard(
                title = "Apps settings",
                subtitle = "Select protected apps",
                icon = Icons.Sharp.Android,
                onClick = {}
            )

            VerticalSeparator(size = 20)

            OptionCard(
                title = "Security",
                subtitle = "Password and backup options",
                icon = Icons.Sharp.Security,
                onClick = {}
            )

            VerticalSeparator(size = 20)

            OptionCard(
                title = "Settings",
                subtitle = "App customization and other settings",
                icon = Icons.Sharp.Settings,
                onClick = {}
            )

            VerticalExpandableSeparator()
        }
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun HomePreview() {
    AppGuardTheme {
        HomeScreen()
    }
}