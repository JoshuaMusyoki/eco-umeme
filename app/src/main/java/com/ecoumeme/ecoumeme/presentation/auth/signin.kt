package com.ecoumeme.ecoumeme.presentation.auth

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.ecoumeme.ecoumeme.domain.MainViewModel
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen(mainViewModel: MainViewModel, modifier: Modifier = Modifier) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()

//    val firebaseAuth = FirebaseAuth.getInstance()

    Scaffold(
        content = {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    value = username.value,
                    onValueChange = { username.value = it },
                    label = { Text("Username") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(percent = 20)
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = password.value,
                    onValueChange = { password.value = it },
                    label = { Text("Password") },
                    modifier = Modifier.fillMaxWidth(),
                    visualTransformation = PasswordVisualTransformation(),
                    shape = RoundedCornerShape(percent = 20)
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedButton(
                    onClick = {
                        coroutineScope.launch {
                            if (username.value.isNotEmpty() && password.value.isNotEmpty()) {
                                mainViewModel.loginUser(username = username.value, password = password.value)
                            } else {
//                                scaffoldState.snackbarHostState.showSnackbar("Please fill out all fields")
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(percent = 20),
                ) {
                    Text("Login")
                }
            }
        }
    )
}

suspend fun loginUserWithEmail(
//    firebaseAuth: FirebaseAuth,
    email: String,
    password: String
) {

}
