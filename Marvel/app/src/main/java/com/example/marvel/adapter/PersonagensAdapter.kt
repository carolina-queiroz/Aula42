package com.example.marvel.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.databinding.MarvelItemBinding
import com.example.marvel.model.Personagem

class PersonagensAdapter(
    private var listaPersonagem: MutableList<Personagem>,
    private val clickPersonagem: (personagem: Personagem) -> Unit
) : RecyclerView.Adapter<PersonagensAdapter.Viewholder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Viewholder {
        val binding = MarvelItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val personagem = listaPersonagem[position]
        holder.exibirInformacoesView(personagem)
        holder.binding.cvItemLista.setOnClickListener {
            clickPersonagem(personagem)
        }
    }

    override fun getItemCount(): Int {
        return listaPersonagem.size
    }

    fun atualizarLista(novaLista: MutableList<Personagem>){
        if (listaPersonagem.size == 0){
            listaPersonagem = novaLista
        }else{
            listaPersonagem.addAll(novaLista)
        }
        notifyDataSetChanged()
    }

    fun limparLista() {
        listaPersonagem.clear()
    }

    class Viewholder(val binding: MarvelItemBinding): RecyclerView.ViewHolder(binding.root){

        fun exibirInformacoesView(personagem: Personagem){
            binding.ivHeroi.setImageResource(personagem.getImagem())
            binding.tvNomeHeroi.text = personagem.getNome()
        }
    }


}