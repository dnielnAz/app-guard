package com.dnieln7.appguard.ui.component

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalSeparator(size: Int) {
    Spacer(modifier = Modifier.width(size.dp))
}

@Composable
fun VerticalSeparator(size: Int) {
    Spacer(modifier = Modifier.height(size.dp))
}

@Composable
fun ColumnScope.VerticalExpandableSeparator() {
    Spacer(modifier = Modifier.weight(1f))
}

@Composable
fun ColumnScope.HorizontalExpandableSeparator() {
    Spacer(modifier = Modifier.weight(1f))
}