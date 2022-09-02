package com.liliane.workoutlog.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.liliane.workoutlog.api.ApiClient
import com.liliane.workoutlog.api.ApiInterface
import com.liliane.workoutlog.databinding.ActivitySignUpBinding
import com.liliane.workoutlog.models.RegisterRequest
import com.liliane.workoutlog.models.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castViews()
    }


    fun castViews() {
        binding.btnSign.setOnClickListener { validateSign() }
        binding.tvLogin.setOnClickListener {
            var intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }

    fun validateSign() {
        var error = false
        binding.tilAddress.error = null
        binding.tilPass.error = null
        var address = binding.etAddress.text.toString()
        if (address.isBlank()) {
            binding.tilAddress.error = "Email is a required field"
            error = true
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(address).matches()) {
            binding.tilAddress.error = "Not a valid email address"
            error = true
            //REGULAR EXPRESSIONS

        }

        var firstName = binding.etName.text.toString()
        if (firstName.isBlank()) {
            binding.tilName.error = "First name is required"
            error = true
        }


        var secondName = binding.etSecondName.text.toString()
        if (secondName.isBlank()) {
            binding.tilSecondName.error = "Second name is required"
            error = true
        }

        var phoneNumber = binding.etPhoneNumber.text.toString()
        if (phoneNumber.isBlank()) {
            binding.tilPhoneNumber.error = "First name is required"
            error = true
        }

        var password = binding.etPass.text.toString()
        if (password.isBlank()) {
            binding.tilPass.error = "Password is required"
            error = true
        }

        var confirmPassword = binding.etConfirm.text.toString()
        if (confirmPassword != password) {


            binding.tilConfirm.error = "Password should match"
            error = true

            // if(!error){
            if (confirmPassword.isBlank()) {
                binding.tilConfirm.error = "Confirm password"
                error = true

            }
            if (!error) {
                val registerRequest =
                    RegisterRequest(firstName, secondName, phoneNumber, address, password)
            }

        }
        fun makeRegisterRequest(registerRequest: RegisterRequest) {
            var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
            val request = apiClient.registerUser(registerRequest)

            request.enqueue(object : Callback<RegisterResponse> {
                override fun onResponse(
                    call: Call<RegisterResponse>,
                    response: Response<RegisterResponse>
                ) {
                   if (response.isSuccessful){
                       Toast.makeText(baseContext,response.body()?.message,Toast.LENGTH_LONG).show()


                   }
                    else{
                        val error=response.errorBody()?.string()
                       Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()



                   }
                }

                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()

                }
            })
        }
    }
}







