package com.example.marvel.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Personagem(private var nome: String, private var descricao: String): Parcelable
{
    fun getNome() = this.nome
    fun getDescricao() = this.descricao
}