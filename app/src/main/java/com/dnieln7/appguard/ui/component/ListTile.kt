package com.dnieln7.appguard.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Android
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dnieln7.appguard.R
import com.dnieln7.appguard.domain.GuardedApp
import com.dnieln7.appguard.domain.InstalledApp
import com.dnieln7.appguard.ui.theme.AppGuardTheme

@Preview
@Composable
fun PreviewTitle() {
    AppGuardTheme(darkTheme = true) {
        Surface {
            GuardedAppListTile(
                app = GuardedApp(
                    packageName = "com.dnieln7.appguard",
                    appName = "App Guard",
                    icon = null,
                    false
                )
            )
        }
    }
}

@Composable
fun GuardedAppListTile(app: GuardedApp) {
    Card(elevation = 0.dp, shape = CutCornerShape(0.dp)) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (app.icon != null)
                Image(
                    bitmap = ImageBitmap.imageResource(id = R.drawable.ic_logo),
                    contentDescription = app.appName
                )
            if (app.icon == null)
                Icon(
                    modifier = Modifier.size(50.dp),
                    imageVector = Icons.Sharp.Android,
                    tint = MaterialTheme.colors.onBackground,
                    contentDescription = app.appName
                )

            HorizontalSeparator(size = 10)

            Column {
                Text(text = app.appName, style = MaterialTheme.typography.subtitle1)
                VerticalSeparator(size = 10)
                if (app.installed)
                    Text(text = app.packageName, style = MaterialTheme.typography.body1)
                if (!app.installed)
                    Text(text = "Not installed", style = MaterialTheme.typography.body2)
            }
        }
    }
}

@Composable
fun InstalledAppListTile(app: InstalledApp) {
    Card(elevation = 0.dp, shape = CutCornerShape(0.dp)) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (app.icon != null)
                Image(
                    bitmap = ImageBitmap.imageResource(id = R.drawable.ic_logo),
                    contentDescription = app.appName
                )
            if (app.icon == null)
                Icon(
                    modifier = Modifier.size(50.dp),
                    imageVector = Icons.Sharp.Android,
                    tint = MaterialTheme.colors.onBackground,
                    contentDescription = app.appName
                )

            HorizontalSeparator(size = 10)

            Column(modifier = Modifier.weight(1F)) {
                Text(text = app.appName, style = MaterialTheme.typography.subtitle1)
                VerticalSeparator(size = 10)
                Text(text = app.packageName, style = MaterialTheme.typography.body1)
            }

            Checkbox(checked = false, onCheckedChange = {})
        }
    }
}