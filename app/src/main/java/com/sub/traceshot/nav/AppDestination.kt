package com.sub.traceshot.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.sub.traceshot.ui.main.MainScreen
import com.sub.traceshot.ui.main.SettingScreen

/**
 * @Description TODO
 * @systemUser bill.liu
 * @Author
 * @Date 05-21-2025 週三 下午 04:44
 */
interface AppDestination {
    val icon: ImageVector?
    val route: String
    val title: String
    val screen: @Composable () -> Unit
    val selected: Boolean
}

object MainScreen : AppDestination {
    override val icon: ImageVector = Icons.Filled.Home
    override val route: String = "Main"
    override val title: String = "Main"
    override val screen = @Composable { MainScreen() }
    override val selected = true
}

object SettingScreen : AppDestination {
    override val icon: ImageVector = Icons.Filled.Settings
    override val route: String = "Setting"
    override val title: String = "Setting"
    override val screen = @Composable { SettingScreen() }
    override val selected = false
}

val viewScreens = listOf(MainScreen,SettingScreen)