package com.example.marvel.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
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
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recuperarExibirDadosPersonagem()
    }

    private fun recuperarExibirDadosPersonagem() {
        val personagem = arguments?.getParcelable<Personagem>(CHAVE_PERSONAGEM)
        if (personagem != null){
            binding.tvNomeDetalhe.text = personagem.getNome()
            binding.tvDescricao.text = personagem.getDescricao()
        }
    }

}