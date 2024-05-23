package com.example.bdsimples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var buttonCadastrar: Button
    private lateinit var buttonAlterar: Button
    private lateinit var buttonDeletar: Button
    private lateinit var buttonListar: Button
    private lateinit var textViewPessoas: TextView
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar as variáveis com os elementos da tela
        editText = findViewById(R.id.editText)
        buttonCadastrar = findViewById(R.id.buttonCadastrar)
        buttonAlterar = findViewById(R.id.buttonAlterar)
        buttonDeletar = findViewById(R.id.buttonDeletar)
        buttonListar = findViewById(R.id.buttonListar)
        textViewPessoas = findViewById(R.id.textViewPessoas)
        listView = findViewById(R.id.listView)

        // Definir funções de clique para os botões
        buttonCadastrar.setOnClickListener { cadastrar() }
        buttonAlterar.setOnClickListener { alterar() }
        buttonDeletar.setOnClickListener { deletar() }
        buttonListar.setOnClickListener { listar() }
    }

    // Função para cadastrar
    private fun cadastrar() {
        Toast.makeText(this, "Botão Cadastrar clicado", Toast.LENGTH_SHORT).show()
    }

    // Função para alterar
    private fun alterar() {
        Toast.makeText(this, "Botão Alterar clicado", Toast.LENGTH_SHORT).show()
    }

    // Função para deletar
    private fun deletar() {
        Toast.makeText(this, "Botão Deletar clicado", Toast.LENGTH_SHORT).show()
    }

    // Função para listar
    private fun listar() {
        Toast.makeText(this, "Botão Listar clicado", Toast.LENGTH_SHORT).show()
    }
}