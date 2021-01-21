package com.e.listadegastos

class Gasto (var id: Int, var descricao: String, var valor: Double) {
    override fun toString(): String {
        return "Gasto(id=$id, descricao='$descricao', valor=$valor)"
    }
}