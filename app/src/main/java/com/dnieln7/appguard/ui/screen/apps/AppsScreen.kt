package com.dnieln7.appguard.ui.screen.apps

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dnieln7.appguard.domain.GuardedApp
import com.dnieln7.appguard.domain.InstalledApp
import com.dnieln7.appguard.ui.component.GuardedAppListTile
import com.dnieln7.appguard.ui.component.InstalledAppListTile
import com.dnieln7.appguard.ui.component.VerticalSeparator
import com.dnieln7.appguard.ui.theme.AppGuardTheme

fun generateFakeGuardedApps(): List<GuardedApp> {
    val reports = mutableListOf<GuardedApp>()

    for (i in 1..20) {
        reports.add(
            GuardedApp(
                packageName = "com.company.$i",
                appName = "Guarded app number $i",
                icon = null,
                i % 2 == 0
            )
        )
    }

    return reports
}

fun generateFakeInstalledApps(): List<InstalledApp> {
    val reports = mutableListOf<InstalledApp>()

    for (i in 1..20) {
        reports.add(
            InstalledApp(
                packageName = "com.company.$i",
                appName = "Guarded app number $i",
                icon = null,
                i % 2 == 0
            )
        )
    }

    return reports
}

@Composable
fun AppsScreen() {
    val apps by rememberSaveable(key = "reports") {
        mutableStateOf(generateFakeGuardedApps())
    }

    val appsI by rememberSaveable(key = "reportsI") {
        mutableStateOf(generateFakeInstalledApps())
    }

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
                .padding(horizontal = 10.dp)
                .verticalScroll(rememberScrollState())
        ) {
            VerticalSeparator(size = 10)
            Card(
                modifier = Modifier.height(300.dp),
                elevation = 5.dp,
                shape = CutCornerShape(0.dp),
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        modifier = Modifier
                            .background(MaterialTheme.colors.onBackground.copy(0.8F))
                            .fillMaxWidth()
                            .padding(horizontal = 5.dp, vertical = 10.dp),
                        text = "Guarded apps",
                        style = MaterialTheme.typography.subtitle1.copy(MaterialTheme.colors.background)
                    )
                    LazyColumn {
                        items(apps) { app ->
                            GuardedAppListTile(app)
                            Divider()
                        }
                    }
                }
            }
            VerticalSeparator(size = 20)
            Card(
                modifier = Modifier.height(400.dp),
                elevation = 5.dp,
                shape = CutCornerShape(0.dp),
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        modifier = Modifier
                            .background(MaterialTheme.colors.onBackground.copy(0.8F))
                            .fillMaxWidth()
                            .padding(horizontal = 5.dp, vertical = 10.dp),
                        text = "Installed apps",
                        style = MaterialTheme.typography.subtitle1.copy(MaterialTheme.colors.background)
                    )
                    LazyColumn {
                        items(appsI) { app ->
                            InstalledAppListTile(app)
                            Divider()
                        }
                    }
                }
            }
            VerticalSeparator(size = 10)
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