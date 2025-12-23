package com.example.signupca2

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.signupca2.ui.theme.SignUpCA2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SignUpCA2Theme {
                SignUpScreen()
            }
        }
    }
}
@Preview
@Composable
fun SignUpScreen(){
    val context  = LocalContext.current
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var userType by remember { mutableStateOf("")}
    var switch by remember {mutableStateOf(false)}
    var color = if(switch) Color.Black else Color.Blue
    Column(modifier = Modifier.fillMaxSize().background(color)
        .padding(start = 20.dp, top = 100.dp, end = 20.dp)) {
        Text(text = "Signup",
            color = Color.Yellow,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic,
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text("UserName",
            fontSize = 20.sp,
            color = Color.Yellow,
            fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = username,
            onValueChange = {
                username = it
                Log.d("Signup","user: $username")
            },
            placeholder = {Text("Enter Your Username",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)},
            textStyle = androidx.compose.ui.text.TextStyle(
                color = Color.Green,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text("Password",
            fontSize = 20.sp,
            color = Color.Yellow,
            fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                Log.d("Signup","Password: $password")
            },
            placeholder = {Text("Enter Your Password",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)},
            textStyle = androidx.compose.ui.text.TextStyle(
                color = Color.Green,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            ),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text("Select User Type",
            color = Color.Yellow,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = userType == "Student",
                onClick = {
                    userType = "Student"
                    Log.d("Signup", "UserType: $userType")
                },
                colors = androidx.compose.material3.RadioButtonDefaults.colors(
                    selectedColor = Color.Green,
                    unselectedColor = Color.Red
                )
            )
            Text("Student",
                color = Color.Green,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp)
            Spacer(modifier = Modifier.width(50.dp))
            RadioButton(
                selected = userType == "Admin",
                onClick = {
                    userType = "Admin"
                    Log.d("Signup", "UserType: $userType")
                },
                colors = androidx.compose.material3.RadioButtonDefaults.colors(
                    selectedColor = Color.Green,
                    unselectedColor = Color.Red
                )
            )
            Text("Admin",
                color = Color.Green,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(verticalAlignment = Alignment.CenterVertically){
            Text(text = "Dark Mode",color = Color.Yellow, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(230.dp))
            Switch(
                checked = switch,
                onCheckedChange = {
                    switch = it
                }
            )
        }
        Spacer(modifier = Modifier.height(35.dp))
        Box(modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center){
            Button(
                onClick = {

                    if (username.length < 4) {
                        Toast.makeText(
                            context,
                            "Username must be at least 4 characters",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    else if (password.length < 6) {
                        Toast.makeText(
                            context,
                            "Password must be at least 6 characters",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    else {
                        Toast.makeText(
                            context,
                            "Signup Successfully",
                            Toast.LENGTH_LONG
                        ).show()

                        Log.d("SignUpScreen", "Username: $username")
                        Log.d("SignUpScreen", "Password: $password")
                    }
                },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Yellow,
                    contentColor = Color.Red,
                )
            ) {
                Text(
                    "Sign Up",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .padding(10.dp),
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}