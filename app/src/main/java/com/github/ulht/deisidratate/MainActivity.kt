package com.github.ulht.deisidratate

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.ulht.deisidratate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  // Estamos a criar uma instância do adapter que teremos de fornecer
// à lista para que ela saiba como desenhar a lista no ecrã
  private val adapter = WaterAdapter.WaterAdapter(onClick = ::onWaterEntryClick)

  // Este método é invocado sempre que o utilizador clica num elemento
  // da lista. Neste caso estamos a imprimir as notas num popup (Toast)
  private fun onWaterEntryClick(entry: WaterEntry) {
    if(entry.notes != null) {
      Toast.makeText(this, entry.notes, Toast.LENGTH_LONG).show()
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
  }

  // O resto do código vem para aqui 🙂

  override fun onStart() {
    super.onStart()
    val entries = EntriesBook.getInstance().getAll()
    adapter.update(entries)
    binding.list.adapter = adapter
    binding.labelProgress.text = EntriesBook.getInstance().getCurrentConsumption()
    binding.progressBar.progress = EntriesBook.getInstance().getPercentageOfLiquids()
    binding.buttonRegister.setOnClickListener {
      startActivity(Intent(this, RegisterActivity::class.java))
    }
  }

}
