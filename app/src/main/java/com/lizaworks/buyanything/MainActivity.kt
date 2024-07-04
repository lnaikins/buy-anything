package com.lizaworks.buyanything

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lizaworks.buyanything.screens.Content
import com.lizaworks.buyanything.screens.LoginScreen
import com.lizaworks.buyanything.screens.OnboardingScreen
import com.lizaworks.buyanything.ui.theme.BuyAnythingTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContent {
            BuyAnythingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Content(modifier = Modifier.padding(innerPadding))
                    val navController = rememberNavController()
                    NavHost(
                        startDestination = Screen.ONBOARDING.route,
                        navController = navController
                    ) {
                        composable(route = Screen.ONBOARDING.route) {
                            OnboardingScreen(onStartClicked = { navController.navigate(Screen.LOGIN.route) })
                        }
                        composable(route = Screen.LOGIN.route, enterTransition = {
                            slideIntoContainer(
                                AnimatedContentTransitionScope.SlideDirection.Start
                            )
                        }) {
                            LoginScreen(onLoginClicked = { navController.navigate(Screen.CONTENT.route) })
                        }
                        composable(route = Screen.CONTENT.route) {
                            Content()
                        }
                    }
                }

            }
        }
    }
}


@Composable
fun MyApp() {
    var screen by remember { mutableStateOf(Screen.ONBOARDING) }

    when (screen) {
        Screen.ONBOARDING -> OnboardingScreen(onStartClicked = { screen = Screen.LOGIN })
        Screen.LOGIN -> LoginScreen(onLoginClicked = { screen = Screen.CONTENT })
        Screen.CONTENT -> Content()
    }

}


enum class Screen(val route: String) {
    ONBOARDING("onboarding"),
    LOGIN("login"),
    CONTENT("content")
}