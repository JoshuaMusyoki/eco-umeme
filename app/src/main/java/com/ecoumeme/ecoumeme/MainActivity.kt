package com.ecoumeme.ecoumeme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ecoumeme.ecoumeme.domain.FailedLogin
import com.ecoumeme.ecoumeme.domain.MainViewModel
import com.ecoumeme.ecoumeme.domain.NotAttempted
import com.ecoumeme.ecoumeme.domain.SuccessLogin
import com.ecoumeme.ecoumeme.presentation.Routes
import com.ecoumeme.ecoumeme.presentation.auth.LoginScreen
import com.ecoumeme.ecoumeme.presentation.auth.RegisterScreen
import com.ecoumeme.ecoumeme.presentation.home.EnergyForm
import com.ecoumeme.ecoumeme.presentation.home.RecommendationScreen
import com.ecoumeme.ecoumeme.ui.theme.EcoUmemeTheme
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.KoinContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EcoUmemeTheme {
                KoinContext {
                    val mainViewModel: MainViewModel = koinViewModel()
                    var signUpScreen by remember { mutableStateOf(true) }
                    val loginState by mainViewModel.loginResponse.collectAsState()
                    val navController = rememberNavController()

                    LaunchedEffect(loginState) {
                        when (loginState) {
                            is NotAttempted -> {

                            }

                            is FailedLogin -> {

                            }

                            is SuccessLogin -> {
                                navController.navigate(Routes.ENERGY_SURVEY_FORM.routes)
                            }
                        }
                    }
                    NavHost(
                        navController = navController,
                        startDestination = Routes.REGISTRATION.routes
                    ) {
                        composable(Routes.REGISTRATION.routes) {
                            Scaffold(
                                bottomBar = {
                                    UmemeBottomBar(
                                        onSignUp = signUpScreen,
                                        onFragmentChange = {
                                            signUpScreen = it
                                        }
                                    )
                                }
                            ) { innerPadding ->
                                if (signUpScreen) {
                                    RegisterScreen(
                                        mainViewModel = mainViewModel,
                                        modifier = Modifier.padding(innerPadding)
                                    )
                                } else {
                                    LoginScreen(
                                        mainViewModel = mainViewModel,
                                        modifier = Modifier.padding(innerPadding)
                                    )
                                }
                            }
                        }

                        composable(Routes.ENERGY_SURVEY_FORM.routes) {
                            EnergyForm(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun UmemeBottomBar(
    onSignUp: Boolean,
    onFragmentChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    BottomAppBar(
        modifier = modifier.fillMaxWidth(),
        contentPadding = WindowInsets.navigationBars.asPaddingValues()
    ) {

        Spacer(Modifier.weight(1f))
        Box(
            modifier = Modifier.weight(1f).clickable {
                onFragmentChange(true)
            }
        ){
            Text("Sign Up", textDecoration = if(onSignUp){
                TextDecoration.Underline
            } else {
                TextDecoration.None
            }
            )
        }

        Spacer(Modifier.weight(1f))

        Box(
            modifier = Modifier.weight(1f).clickable {
                onFragmentChange(false)
            }
        ){
            Text("Sign In", textDecoration = if(!onSignUp){
                TextDecoration.Underline
            } else {
                TextDecoration.None
            })
        }
        Spacer(Modifier.weight(1f))
    }
}