package com.example.marvel.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.example.marvel.CHAVE_PERSONAGEM
import com.example.marvel.R
import com.example.marvel.databinding.FragmentDetalhePersonagensBinding
import com.example.marvel.model.Personagem


class DetalhePersonagensFragment : Fragment() {
private lateinit var binding: FragmentDetalhePersonagensBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalhePersonagensBinding.inflate(inflater, container, false)
        return binding.root

        recuperarExibirDadosPersonagem()
    }

    private fun recuperarExibirDadosPersonagem() {
        val personagem = arguments?.getParcelable<Personagem>(CHAVE_PERSONAGEM)
        if (personagem != null){
           exibirPersonagens(personagem)
        }
    }

    private fun exibirPersonagens(personagem: Personagem){
        binding.ivHeroiDetalhe.setImageResource(personagem.getImagem())
        binding.tvNomeDetalhe.text = personagem.getNome()
        binding.tvDescricao.text = personagem.getDescricao()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}