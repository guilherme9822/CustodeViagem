package com.example.custodeviagem

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.custodeviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalcular.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_calcular) calculate()
    }

    private fun isValidate(): Boolean {
        return (binding.editDistance.text.toString() != ""
                && binding.editPreco.text.toString() != ""
                && binding.editAutonomy.text.toString() != ""
                && binding.editAutonomy.text.toString().toFloat() != 0f)
    }

    @SuppressLint("SetTextI18n")
    private fun calculate() {

        if (isValidate()) {

            val distance = binding.editDistance.text.toString().toFloat()
            val preco = binding.editPreco.text.toString().toFloat()
            val autonomia = binding.editAutonomy.text.toString().toFloat()

            val totalValue = (distance * preco) / autonomia
            binding.textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"

            Toast.makeText(this, "O Cauculo Foi Feito!", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, R.string.colocar_Valor, Toast.LENGTH_SHORT).show()
        }

    }
}

