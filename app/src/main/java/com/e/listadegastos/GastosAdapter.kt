package com.e.listadegastos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GastosAdapter(private val listGastos: ArrayList<Gasto>, val listener: OnGastoClickListener) :
    RecyclerView.Adapter<GastosAdapter.GastosViewHolder>() {

    //inflando a recyclerview com o item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GastosViewHolder {
        var itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_gasto, parent, false)
        return GastosViewHolder(itemView)
    }

    //passando dados para cada item
    override fun onBindViewHolder(holder: GastosViewHolder, position: Int) {
        var gasto = listGastos[position]

        //pega o tvDescricao do GastosViewHolder
        holder.tvDescricao.text = gasto.descricao
    }

    //pegando tamanho da lista
    override fun getItemCount() = listGastos.size


    //interface que traz comportamento de click e vai ser sobrescrita na activity
    interface OnGastoClickListener {
        fun gastoClick(position: Int)

    }


   inner class GastosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        //para cada componente dinamico do item fazemos:
        val tvDescricao: TextView = itemView.findViewById(R.id.tvDescricao)

        init{
            itemView.setOnClickListener(this)
        }


        //passa a position para a interface OnGastoClick Listener
        override fun onClick(v: View?) {
            val position = adapterPosition
            if (RecyclerView.NO_POSITION != position)
                listener.gastoClick(position)

        }
    }
}