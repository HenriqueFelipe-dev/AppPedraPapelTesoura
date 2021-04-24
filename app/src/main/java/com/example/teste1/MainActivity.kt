package com.example.teste1

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var pontApp = 0
    private var pontUsuario = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun selecPedra(view: View){
        opcaoSelecionada("Pedra")
    }

    fun selecPapel(view: View){
        opcaoSelecionada("Papel")
    }

    fun selecTesoura(view: View){
        opcaoSelecionada("Tesoura")
    }

    @SuppressLint("SetTextI18n")
    fun opcaoSelecionada(escolhaUsuario: String){
        val imageApp = findViewById<ImageView>(R.id.imageView)
        val textResultado = findViewById<TextView>(R.id.textViewResultado)
        val textPontApp = findViewById<TextView>(R.id.textViewApp)
        val textPontUsuario = findViewById<TextView>(R.id.textViewUsuario)

        val random = Random.nextInt(3)
        val opcoes = arrayOf("Pedra", "Papel", "Tesoura")
        val escolhaApp = opcoes[random]

        when (escolhaApp){
            "Pedra" -> {
                imageApp.setImageResource(R.drawable.pedra)
            }
            "Papel" -> {
                imageApp.setImageResource(R.drawable.papel)
            }
            "Tesoura" -> {
                imageApp.setImageResource(R.drawable.tesoura)
            }
        }

        if (
                (escolhaApp == "Pedra" && escolhaUsuario == "Tesoura") ||
                (escolhaApp == "Papel" && escolhaUsuario == "Pedra") ||
                (escolhaApp == "Tesoura" && escolhaUsuario == "Papel")

                ){

            pontApp += 1
            textPontApp.text = pontApp.toString()
            textResultado.text = "Você perdeu man :/"

        }else if(

                (escolhaApp == "Tesoura" && escolhaUsuario == "Pedra") ||
                (escolhaApp == "Pedra" && escolhaUsuario == "Papel") ||
                (escolhaApp == "Papel" && escolhaUsuario == "Tesoura")

                ){
            pontUsuario += 1
            textPontUsuario.text = pontUsuario.toString()
            textResultado.text = "Você ganhou :^)"
        }else{
            textResultado.text = "Empate!!"
        }

    }


}