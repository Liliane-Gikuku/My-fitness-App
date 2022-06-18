package com.liliane.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.liliane.workoutlog.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castViews()
    }
        fun castViews(){



        binding.btnLogin.setOnClickListener { validateLogin()
            startActivity(Intent(this,HomeActivity::class.java))}
        binding.tvSignUp.setOnClickListener{
            var intent=Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }

        }

    fun validateLogin(){
        var error = false
        binding.tilEmail.error=null
        binding.tilPassword.error=null

        var password= binding.etPassword.text.toString()
        if (password. isBlank()){
            binding.tilPassword.error="Password is required"
            error=true
        }
        var email= binding.etEmail.text.toString()
        if (email.isBlank()){
            binding.tilEmail.error="Email is required"
            error=true
        }
        if (!error){
            //startActivity(Intent(this,HomeActivity::class.java))

        }
    }
}