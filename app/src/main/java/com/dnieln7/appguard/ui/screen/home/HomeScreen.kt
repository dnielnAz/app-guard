package com.dnieln7.appguard.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dnieln7.appguard.ui.theme.AppGuardTheme

@Composable
fun HomeScreen() {
    Scaffold {
        Column(modifier = Modifier.padding(it)) {

        }
    }
}

@Preview
@Composable
fun HomePreview() {
    AppGuardTheme {
        HomeScreen()
    }
}