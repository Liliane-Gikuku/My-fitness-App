package com.liliane.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.liliane.workoutlog.databinding.ActivitySignInBinding
import com.liliane.workoutlog.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
   lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castViews()
    }


        fun castViews(){
        binding.btnSign.setOnClickListener { validateSign() }
        binding.tvLogin.setOnClickListener {
            var intent=Intent(this,SignInActivity::class.java)
            startActivity(intent)
        }
    }
    fun validateSign(){
        var error=false
        binding.tilAddress.error=null
        binding.tilPass.error=null
        var Address=binding.etAddress.text.toString()
        if(Address.isBlank()){
            binding.tilAddress.error="Email is a required field"
            error=true
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(Address).matches()){
            binding.tilAddress.error="Not a valid email address"
            error=true
            //REGULAR EXPRESSIONS

        }

        var firstName=binding.etName.text.toString()
        if(firstName.isBlank()){
            binding.tilName.error="First name is required"
            error=true
        }

        var secondName=binding.etSecondName.text.toString()
        if(secondName.isBlank()){
            binding.tilSecondName.error="Second name is required"
            error=true
        }

        var password=binding.etPass.text.toString()
        if (password.isBlank()){
            binding.tilPass.error="Password is required"
            error=true
        }

        var confirmPassword=binding.etConfirm.text.toString()
        if (confirmPassword!=password){


            binding.tilConfirm.error="Password should match"
            error=true

       // if(!error){
            if(confirmPassword.isBlank()){
                binding.tilConfirm.error="Confirm password"
                error=true
            }
        }
    }
}

