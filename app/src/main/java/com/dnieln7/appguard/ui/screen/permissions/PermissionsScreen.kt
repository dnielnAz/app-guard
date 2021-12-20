package com.dnieln7.appguard.ui.screen.permissions

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.dnieln7.appguard.R
import com.dnieln7.appguard.ui.component.VerticalExpandableSeparator
import com.dnieln7.appguard.ui.component.VerticalSeparator
import com.dnieln7.appguard.ui.theme.AppGuardTheme
import com.dnieln7.appguard.utils.PermissionChecker

@Composable
fun PermissionsScreen() {
    val context = LocalContext.current
    val lifecycle = LocalLifecycleOwner.current.lifecycle

    DisposableEffect(key1 = lifecycle) {
        val observer = LifecycleEventObserver { source, event ->
            if(event == Lifecycle.Event.ON_START) {
                println("started-------------------------------------")
            }
        }

        lifecycle.addObserver(observer)

        onDispose {
            lifecycle.removeObserver(observer)
        }
    }

    Column(modifier = Modifier.padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            modifier = Modifier.size(100.dp),
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null
        )

        VerticalSeparator(size = 20)

        Text(
            text = "Please allow us to use these features",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h6
        )

        VerticalSeparator(size = 10)

        Text(
            text = "To use App Guard you need to enable the following permissions",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.subtitle1
        )

        VerticalSeparator(size = 20)

        Text(
            text = "Usage stats: We need to watch your app's usage history",
            style = MaterialTheme.typography.caption.copy(fontSize = 16.sp)
        )

        VerticalSeparator(size = 5)

        Text(
            text = "Overlay screen: We need to be able to display a lock screen on top of the apps you choose to protect",
            style = MaterialTheme.typography.caption.copy(fontSize = 16.sp)
        )

        VerticalExpandableSeparator()

        Button(onClick = { PermissionChecker.requestUsageAccessPermission(context) }) {
            Text(text = "ALLOW USAGE STATS")
        }

        VerticalSeparator(size = 10)

        Button(onClick = { PermissionChecker.requestOverlayPermission(context) }) {
            Text(text = "ALLOW OVERLAY SCREEN")
        }

        VerticalSeparator(size = 20)

        TextButton(onClick = { (context as ComponentActivity).finishAffinity() }) {
            Text(
                text = "I don't want to (The application will close)",
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PermissionsPreview() {
    AppGuardTheme {
        PermissionsScreen()
    }
}