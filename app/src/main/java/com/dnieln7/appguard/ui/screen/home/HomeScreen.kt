package com.dnieln7.appguard.ui.screen.home

import androidx.compose.animation.ExperimentalAnimationApi
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
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dnieln7.appguard.ui.animation.FallingWithOpacity
import com.dnieln7.appguard.ui.component.OptionCard
import com.dnieln7.appguard.ui.component.VerticalExpandableSeparator
import com.dnieln7.appguard.ui.component.VerticalSeparator
import com.dnieln7.appguard.ui.theme.AppGuardTheme

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun HomeScreen() {
    var showSecurity by remember { mutableStateOf(false) }
    var showSettings by remember { mutableStateOf(false) }

    Scaffold {
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

            FallingWithOpacity(
                content = {
                    OptionCard(
                        title = "Apps settings",
                        subtitle = "Select protected apps",
                        icon = Icons.Sharp.Android,
                        onClick = {}
                    )
                },
                after = { showSecurity = true }
            )

            VerticalSeparator(size = 20)

            if (showSecurity) {
                FallingWithOpacity(
                    content = {
                        OptionCard(
                            title = "Security",
                            subtitle = "Password and backup options",
                            icon = Icons.Sharp.Security,
                            onClick = {}
                        )
                    },
                    after = { showSettings = true }
                )
            }

            VerticalSeparator(size = 20)

            if (showSettings) {
                FallingWithOpacity(
                    content = {
                        OptionCard(
                            title = "Settings",
                            subtitle = "App customization and other settings",
                            icon = Icons.Sharp.Settings,
                            onClick = {}
                        )
                    },
                    after = {}
                )
            }

            VerticalExpandableSeparator()
        }
    }
}

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Preview
@Composable
fun HomePreview() {
    AppGuardTheme {
        HomeScreen()
    }
}