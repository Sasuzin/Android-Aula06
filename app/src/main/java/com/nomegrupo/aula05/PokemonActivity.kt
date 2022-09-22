package com.nomegrupo.aula05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.nomegrupo.aula05.databinding.ActivityPokemonBinding

class PokemonActivity : AppCompatActivity() {
    lateinit var binding: ActivityPokemonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPokemonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pokemons = arrayListOf("Escolha um Pokemon", "Bulbassauro","Squirtle", "Charmander")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, pokemons)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinner.adapter = adapter

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapter: AdapterView<*>?, spinner: View?, posicao: Int, id: Long) {

                when(posicao) {
                    1 -> {
                        val imagemBulbassauro = getDrawable(R.drawable.bulbassauro)
                        binding.imageView.setImageDrawable(imagemBulbassauro)
                    }
                    2 -> {
                        val imagemSquirtle = getDrawable(R.drawable.squirtle)
                        binding.imageView.setImageDrawable(imagemSquirtle)
                    }
                    3 -> {
                        val imagemCharmander = getDrawable(R.drawable.charmander)
                        binding.imageView.setImageDrawable(imagemCharmander)
                    }
                    else -> binding.imageView.setImageDrawable(null)
                }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        binding.button.setOnClickListener{
            when(binding.spinner.selectedItemPosition) {
                1 -> alert("Tipo do Pokemon","Grama/Poison",this)
                2 -> alert("Tipo do Pokemon","Agua",this)
                3 -> alert("TIpo do Pokemon","Fogo",this)
                else -> alert("Erro","Selecione um Pokemon",this)
            }
        }
    }
}