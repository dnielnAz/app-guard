package com.dnieln7.appguard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.dnieln7.appguard.ui.screen.home.HomeScreen
import com.dnieln7.appguard.ui.screen.permissions.PermissionsScreen
import com.dnieln7.appguard.ui.theme.AppGuardTheme
import com.dnieln7.appguard.utils.PermissionChecker

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val splashWasDisplayed = savedInstanceState != null

        if (!splashWasDisplayed) {
            val splashScreen = installSplashScreen()

            splashScreen.setOnExitAnimationListener {
                it.iconView
                    .animate()
                    .setDuration(500L)
                    .alpha(0f)
                    .withEndAction {
                        it.remove()
                        setContent {
                            AppGuardTheme {
                                Surface {
                                    PermissionsScreen()
                                }
                            }
                        }
                    }
            }
        } else {
            setContent {
                AppGuardTheme {
                    Surface {
                        PermissionsScreen()
                    }
                }
            }
        }
    }

    @Composable
    fun StartApp() {
        if (
            PermissionChecker.checkOverlayPermission(this) &&
            PermissionChecker.checkUsageAccessPermission(this)
        ) {
            HomeScreen()
        }else {

        }
    }
}