package com.lctproduction.monagement

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lctproduction.monagement.databinding.ActivityRegisterBinding
import com.lctproduction.monagement.datasources.User
import com.lctproduction.monagement.datasources.UserDataSource


class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var userDataSource: UserDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userDataSource = UserDataSource(this)

        binding.btnRegister.setOnClickListener {
            val name = binding.edtNamaLengkap.text.toString()
            val phone = binding.edtNomorHandphone.text.toString()
            val password = binding.edtPassword.text.toString()
            val confirmPassword = binding.edtConfirmPass.text.toString()

            if (name.isNotEmpty() && phone.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                if (password == confirmPassword) {
                    val user = User(name = name, phone = phone, password = password)
                    val userId = userDataSource.addUser(user)
                    if (userId != -1L) {
                        Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
                        // Navigate to the next screen or do other actions
                    } else {
                        Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}