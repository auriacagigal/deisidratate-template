package com.github.ulht.deisidratate

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.github.ulht.deisidratate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private val TAG = MainActivity::class.java.simpleName

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
  }

  override fun onStart() {
    super.onStart()
    binding.nomeBotao.setOnClickListener {
      // Programa aqui a ação do botão
      startActivity(Intent(this, RegisterActivity::class.java))
    }
  }


}