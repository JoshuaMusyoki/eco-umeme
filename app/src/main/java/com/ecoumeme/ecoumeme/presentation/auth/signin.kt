package com.ecoumeme.ecoumeme.presentation.auth

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen() {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()

//    val firebaseAuth = FirebaseAuth.getInstance()

    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                TextField(
                    value = email.value,
                    onValueChange = { email.value = it },
                    label = { Text("Email Address") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                TextField(
                    value = password.value,
                    onValueChange = { password.value = it },
                    label = { Text("Password") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        coroutineScope.launch {
                            if (email.value.isNotEmpty() && password.value.isNotEmpty()) {
                                loginUserWithEmail(email.value, password.value)
                            } else {
//                                scaffoldState.snackbarHostState.showSnackbar("Please fill out all fields")
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
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
    try {
//        firebaseAuth.signInWithEmailAndPassword(email, password)
//            .addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    scaffoldState.snackbarHostState.showSnackbar("Login successful")
//                } else {
//                    task.exception?.message?.let {
//                        scaffoldState.snackbarHostState.showSnackbar("Login failed: $it")
//                    }
//                }
//            }
    } catch (e: Exception) {
//        scaffoldState.snackbarHostState.showSnackbar("Error: ${e.localizedMessage}")
    }
}

@Preview
@Composable
fun SignInPreview(){
    LoginScreen()
}
