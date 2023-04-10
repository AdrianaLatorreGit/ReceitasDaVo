package com.adrianalatorre.receitasdavo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvReceitas: RecyclerView
    private lateinit var receitasAdapter: ReceitasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvReceitas = findViewById(R.id.rv_receitas)

        val lista = listOf(
            Receita(
                "Escondidinho de camarão", "25min", R.drawable.carne1,
                listOf("1 KG de camarão", "Manteiga", "alho", "cebola")
            ),
            Receita(
                "Panqueca de carne moída", "30min", R.drawable.carne2,
                listOf("1 KG de carne", "Manteiga", "alho")
            ),
            Receita(
                "Rocambole de carne moída", "45min", R.drawable.carne3,
                listOf("4 KG de carne", "Manteiga", "alho", "cebola")
            ),
            Receita(
                "Escondidinho de carne seca", "15min", R.drawable.carne4,
                listOf("4 KG de carne seca", "Manteiga", "alho", "cebola", "farinha")
            ),
        )

        //Adapter
        receitasAdapter = ReceitasAdapter { receita ->
            val intent = Intent(this, DetalhesActivity::class.java)
            intent.putExtra("receita", receita)
            startActivity(intent)
        }
        rvReceitas.adapter = receitasAdapter
        receitasAdapter.configurarLista(lista)

        //Layout
        rvReceitas.layoutManager = LinearLayoutManager(this)

    }
}