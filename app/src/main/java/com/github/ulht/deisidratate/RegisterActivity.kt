package com.github.ulht.deisidratate

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
      /*  binding.botaoFechar.setOnClickListener {
            // Programa aqui a ação do botão

            finish()
        }*/
    }

     override fun onResume() {
         super.onResume()

         binding.submitButton.setOnClickListener {
             val drinkIndex= binding.spinnerDrink.selectedItemPosition
             var drinkType = DrinkType.entries[drinkIndex]
             val amount = binding.sliderAmount.value.toInt()
             val notes = binding.inputNotes.text.toString()

             val waterEntry = WaterEntry(drink = drinkType, amount= amount,notes = notes, date = null)

             EntriesBook.getInstance().insert(waterEntry)

             Toast.makeText(this, "Register succesfully", Toast.LENGTH_LONG).show()
             finish()
         }
     }

 }