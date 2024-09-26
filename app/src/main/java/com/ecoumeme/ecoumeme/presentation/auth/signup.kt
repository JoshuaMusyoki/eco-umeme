package com.ecoumeme.ecoumeme.presentation.auth
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ecoumeme.ecoumeme.domain.MainViewModel
//import com.google.firebase.auth.FirebaseAuth

import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RegisterScreen(mainViewModel: MainViewModel, modifier: Modifier = Modifier){
    val name = remember { mutableStateOf("") }
    val phone = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Scaffold (
        content = {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    value = name.value,
                    onValueChange = { name.value = it },
                    label = { Text("Full Name") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = phone.value,
                    onValueChange = { phone.value = it },
                    label = { Text("Phone Number") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = email.value,
                    onValueChange = { email.value = it },
                    label = { Text("Email Address") },
                    modifier = Modifier.fillMaxWidth()
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

                Button(
                    onClick = {
                        mainViewModel.createUser(
                            username = name.value,
                            phone = phone.value,
                            email = email.value,
                            password = password.value,
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Register")
                }
            }
        }
    )
}

suspend fun registerUserWithEmail(
//    firebaseAuth: FirebaseAuth,
    email: String,
    password: String,
//    scaffoldState: ScaffoldState
) {
//    try {
//        firebaseAuth.createUserWithEmailAndPassword(email, password)
//            .addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    scaffoldState.snackbarHostState.showSnackbar("User registered successfully")
//                } else {
//                    task.exception?.message?.let {
//                        scaffoldState.snackbarHostState.showSnackbar("Registration failed: $it")
//                    }
//                }
//            }
//    } catch (e: Exception) {
//        scaffoldState.snackbarHostState.showSnackbar("Error: ${e.localizedMessage}")
//    }
}

