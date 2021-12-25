package com.dnieln7.appguard.ui.screen.apps

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dnieln7.appguard.ui.theme.AppGuardTheme

@Composable
fun AppsScreen() {
    Scaffold {
        Column(modifier = Modifier.padding(it)) {
            Text(text = "Apps")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppsScreenPreview() {
    AppGuardTheme {
        AppsScreen()
    }
}