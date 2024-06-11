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

    private val bd by lazy {
        DataBaseHelper(this)
    }

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
        var sql = "INSERT INTO cadastroPessoa VALUES(null, 'Larissa Rayane');"

        try {
            bd.writableDatabase.execSQL(sql)
            Toast.makeText(this, "Cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    // Função para alterar
    private fun alterar() {
        var sql = "UPDATE cadastroPessoa SET nome = 'Rayane' WHERE id_pessoa = 2;"
        try {
            bd.writableDatabase.execSQL(sql)
            Toast.makeText(this, "Alterado com sucesso", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    // Função para deletar
    private fun deletar() {
        var sql = "delete from cadastroPessoa where id_pessoa = 2"
        try {
            bd.writableDatabase.execSQL(sql)
            Toast.makeText(this, "Deletado com sucesso", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    // Função para listar
    private fun listar() {
        var sql = "SELECT * FROM cadastroPessoa"
        var cursor = bd.readableDatabase.rawQuery(sql, null)
        val indiceId = cursor.getColumnIndex("id_pessoa")
        val indiceNome = cursor.getColumnIndex("nome")
        while (cursor.moveToNext()) {

            var idPessoa = cursor.getInt(indiceId)
            var nomePessoa = cursor.getString(indiceNome)
            Toast.makeText(this, "$idPessoa - $nomePessoa", Toast.LENGTH_SHORT).show()
        }
    }
}