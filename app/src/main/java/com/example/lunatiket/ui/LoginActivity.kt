package com.example.lunatiket.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lunatiket.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.l_back
import kotlinx.android.synthetic.main.activity_login.txt_signup

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //auth
        auth = FirebaseAuth.getInstance()

        binding.button4.setOnClickListener{
            val email = binding.loginemail.text.toString().trim()
            val password = binding.loginpassword.text.toString().trim()
            loginUser(email, password)
        }

        supportActionBar?.hide()
        btnBackLoginListener()
        txtRegisListener()
    }
    private fun btnBackLoginListener() {
        l_back.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
    private fun txtRegisListener() {
        txt_signup.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
    private fun loginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { login ->
                if (login.isSuccessful){
                    Intent(this, HomeActivity::class.java).also{
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                        Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show()
                    }
                } else{
                    Toast.makeText(this, login.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
    }
}