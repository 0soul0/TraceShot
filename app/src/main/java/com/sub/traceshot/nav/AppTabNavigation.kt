package com.sub.traceshot.nav

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.W900
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.sub.traceshot.theme.TraceShotTheme

@Composable
fun AppTabNavigation(
    allDestinations: List<AppDestination>,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    // 獲取當前導航棧的入口，並轉換為 State
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val selectedDestination = allDestinations.find { it.route == currentRoute }


    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Transparent),
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(8.dp,8.dp,0.dp),
            elevation = CardDefaults.cardElevation(defaultElevation =8.dp)
        ) {
            NavigationBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
                    .padding(0.dp),
                containerColor = Color.Transparent,
            ) {
                allDestinations.forEach { destination ->
                    NavigationBarItem(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp),
                        icon = {
                            destination.icon?.let {
                                Icon(
                                    imageVector = it,
                                    modifier = Modifier.size(32.dp),
                                    contentDescription = null,
                                    tint =  MaterialTheme.colorScheme.onSurface
                                )
                            }
                        },
                        label = {
                            Text(
                                destination.title,
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = W900,
                                color = MaterialTheme.colorScheme.onSurface)
                        },
                        selected = selectedDestination == destination,
                        onClick = {
                            navController.navigateSingleTopTo(destination.route)
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.secondary,
                            unselectedIconColor = MaterialTheme.colorScheme.inversePrimary,
                            selectedTextColor = MaterialTheme.colorScheme.secondary,
                            unselectedTextColor = MaterialTheme.colorScheme.inversePrimary,
                            indicatorColor = Color.Transparent
                        )
                    )
                }
            }

        }
    }
}


@Composable
fun AppNavHost(
    allDestinations: List<AppDestination>,
    startDestination: String=allDestinations.first().route,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination) {
        allDestinations.forEach { destination ->
            composable(destination.route) {
                destination.screen()
            }
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }

@Preview(
    showBackground = true,
    backgroundColor = 0xFF0f0c12,
    heightDp = 64)
@Composable
fun AppTabNavigationPreview() {
    TraceShotTheme {
        AppTabNavigation(
            allDestinations = viewScreens,
            navController = rememberNavController(),
            modifier = Modifier)
    }
}