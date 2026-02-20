package com.github.ulht.deisidratate

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.github.ulht.deisidratate.databinding.ActivityMainBinding
import com.github.ulht.deisidratate.databinding.ActivityRegisterBinding

 class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
    override fun onStart() {
        super.onStart()
        binding.botaoFechar.setOnClickListener {
            // Programa aqui a ação do botão

            finish()
        }
    }

 }