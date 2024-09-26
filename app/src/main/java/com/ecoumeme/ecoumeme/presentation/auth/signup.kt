package com.ecoumeme.ecoumeme.presentation.auth
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
//import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RegisterScreen(){
    val name = remember { mutableStateOf("") }
    val phone = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
//    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    

    Scaffold (
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                TextField(
                    value = name.value,
                    onValueChange = { name.value = it },
                    label = { Text("Full Name") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                TextField(
                    value = phone.value,
                    onValueChange = { phone.value = it },
                    label = { Text("Phone Number") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

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
                                registerUserWithEmail(
//                                    firebaseAuth,
                                    email.value,
                                    password.value,
//                                    scaffoldState
                                )
                            } else {
                                // Show a snackbar message if any field is empty

//                                scaffoldState.snackbarHostState.showSnackbar("Please fill out all fields")
                            }
                        }
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

@Preview
@Composable
fun RegisterScreenPreview(){
    RegisterScreen()
}
