package com.liliane.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {
    lateinit var etName:TextInputEditText
    lateinit var tilName:TextInputLayout
    lateinit var etSecondName:TextInputEditText
    lateinit var tilSecondName:TextInputLayout
    lateinit var btnSign:Button
    lateinit var tvLogin:TextView
    lateinit var etAddress:TextInputEditText
    lateinit var tilAddress:TextInputLayout
    lateinit var etPass:TextInputEditText
    lateinit var tilPass:TextInputLayout
    lateinit var etConfirm:TextInputEditText
    lateinit var tilConfirm:TextInputLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        btnSign=findViewById(R.id.btnSign)
        tvLogin=findViewById(R.id.tvLogin)
        tilName=findViewById(R.id.tilName)
        etName=findViewById(R.id.etName)
        tilSecondName=findViewById(R.id.tilSecondName)
        etSecondName=findViewById(R.id.etSecondName)
        tilPass=findViewById(R.id.tilPass)
        etPass=findViewById(R.id.etPass)
        tilConfirm=findViewById(R.id.tilConfirm)
        etConfirm=findViewById(R.id.etConfirm)
        tilAddress=findViewById(R.id.tilAddress)
        etAddress=findViewById(R.id.etAddress)
        btnSign.setOnClickListener { validateSign() }
        tvLogin.setOnClickListener {
            var intent=Intent(this,SignInActivity::class.java)
            startActivity(intent)
        }
    }
    fun validateSign(){
        var error=false
        tilAddress.error=null
        tilPass.error=null
        var Address=etAddress.text.toString()
        if(Address.isBlank()){
            tilAddress.error="Email is a required field"
            error=true
        }

        var password=etPass.text.toString()
        if (password.isBlank()){
            tilPass.error="Password is required"
            error=true
        }
        if(!error){

        }
    }
}

