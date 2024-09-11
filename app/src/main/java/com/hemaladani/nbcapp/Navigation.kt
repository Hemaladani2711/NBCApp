import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hemaladani.nbcapp.data.NavigationItem
import com.hemaladani.nbcapp.ui.dashboard.DashboardScreen
import com.hemaladani.nbcapp.ui.home.TrendingNowViewSetUp
import com.hemaladani.nbcapp.ui.notifications.notifications_text

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            TrendingNowViewSetUp()
        }
        composable(NavigationItem.Dashboard.route) {
            DashboardScreen()
        }
        composable(NavigationItem.Notifications.route) {
            notifications_text()
        }
        /*composable(NavigationItem.Profile.route) {
            ProfileScreen()
        }*/
    }
}