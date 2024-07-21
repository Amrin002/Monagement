package com.lctproduction.monagement

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.MotionEvent
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lctproduction.monagement.databinding.ActivityLoginBinding
import com.lctproduction.monagement.datasources.UserDataSource

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var userDataSource: UserDataSource
    private var isPasswordVisible = false

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        userDataSource = UserDataSource(this)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.backbtn.setOnClickListener {
            val intent = Intent(this, GetStartedPage::class.java)
            startActivity(intent)
        }

        binding.txtDaftar.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            if(validasi()) {
                val nomorHandphone = binding.edtNomorHandphone.text.toString().trim()
                val password = binding.edtPassword.text.toString().trim()
                if (userDataSource.validateUser(nomorHandphone, password)) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Nomor Handphone atau Password salah", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Masukan Semua kolom", Toast.LENGTH_SHORT).show()
            }
        }

        binding.edtPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

        binding.edtPassword.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                if (event.rawX >= (binding.edtPassword.right - binding.edtPassword.compoundDrawables[2].bounds.width())) {
                    isPasswordVisible = !isPasswordVisible
                    if (isPasswordVisible) {
                        binding.edtPassword.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                    } else {
                        binding.edtPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                    }
                    binding.edtPassword.setSelection(binding.edtPassword.text.length)
                    return@setOnTouchListener true
                }
            }
            false
        }
    }

    private fun validasi(): Boolean {
        val nomorHandphone = binding.edtNomorHandphone.text.toString().trim()
        val password = binding.edtPassword.text.toString().trim()
        return nomorHandphone.isNotEmpty() && password.isNotEmpty()
    }
}