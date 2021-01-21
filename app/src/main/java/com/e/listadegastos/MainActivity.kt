package com.e.listadegastos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity(), GastosAdapter.OnGastoClickListener {

    //variavel como função
    var listGastos = getAllGastos()

    var adap = GastosAdapter(listGastos, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //instanciando o adapter
        rvGastos.adapter = adap
        rvGastos.layoutManager = LinearLayoutManager(this)
        rvGastos.setHasFixedSize(true)


    }


    //retorna uma lista fixa de gastos
    private fun getAllGastos(): ArrayList<Gasto> {
        var gasto1 = Gasto(1, "Mercado", 50.00)
        var gasto2 = Gasto(2, "Hortifruti", 80.00)
        var gasto3 = Gasto(3, "Padoca", 20.00)
        var gasto4 = Gasto(4, "Café", 40.00)

        return arrayListOf(gasto1, gasto2, gasto3, gasto4)
    }

    override fun gastoClick(position: Int) {
        val gasto = listGastos[position]
        gasto.descricao = "DEU CERTO"
        adap.notifyItemChanged(position)
    }
}