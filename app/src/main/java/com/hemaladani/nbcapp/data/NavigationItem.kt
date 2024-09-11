package com.hemaladani.nbcapp.data

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.ui.graphics.vector.ImageVector
import com.hemaladani.nbcapp.R

sealed class NavigationItem(var route: String, var icon: ImageVector, var title: String) {
    object Home : NavigationItem("home", Icons.Default.Home, "Home")
    object Dashboard : NavigationItem("dashboard", Icons.Default.Favorite, "Dashboard")
    object Notifications : NavigationItem("notifications",Icons.Default.Notifications, "Notifications")
}