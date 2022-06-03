package com.liliane.workoutlog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignInActivity : AppCompatActivity() {
    lateinit var btnLogin:Button
    lateinit var tilEmail:TextInputLayout
    lateinit var etEmail:TextInputEditText
    lateinit var tilPassword:TextInputLayout
    lateinit var etPassword:TextInputEditText
    lateinit var tvSignUP:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        btnLogin=findViewById(R.id.btnLogin)
        tilEmail=findViewById(R.id.tilEmail)
        etEmail=findViewById(R.id.etEmail)
        tilPassword=findViewById(R.id.tilPassword)
        etPassword=findViewById(R.id.etPassword)
        tvSignUP=findViewById(R.id.tvSignUp)


        btnLogin.setOnClickListener { validateLogin()}
    }
    fun validateLogin(){
        var error = false
        tilEmail.error=null
        tilPassword.error=null

        var password= etPassword.text.toString()
        if (password. isBlank()){
            tilPassword.error="Password is required"
            error=true
        }
        var email= etEmail.text.toString()
        if (email.isBlank()){
            tilEmail.error="Email is required"
            error=true
        }
    }
}