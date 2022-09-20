package com.example.marvel.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.clearFragmentResult
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.marvel.CHAVE_PERSONAGEM
import com.example.marvel.R
import com.example.marvel.adapter.PersonagensAdapter
import com.example.marvel.databinding.FragmentListaPersonagensBinding
import com.example.marvel.model.Personagem


class ListaPersonagensFragment : Fragment() {
    private lateinit var binding: FragmentListaPersonagensBinding

    private val personagemAdapter: PersonagensAdapter by lazy {
        PersonagensAdapter(arrayListOf(), this::irParaDetalhePersonagem)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaPersonagensBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        criarListaPersonagem()
        exibirRecyclerView()
    }

    private fun exibirRecyclerView() {
        binding.rvHerois.adapter = personagemAdapter
        binding.rvHerois.layoutManager = StaggeredGridLayoutManager(1,
            StaggeredGridLayoutManager.VERTICAL)
    }

    private fun criarListaPersonagem() {
        val listaPersonagens = mutableListOf<Personagem>()

        listaPersonagens.add(
         Personagem("Feiticeira Escarlate", "Feiticeira Escarlate foi retratada como uma feiticeira poderosa desde os anos 1980 e mais tarde foi considerada poderosa o suficiente para alterar a realidade.", R.drawable.feiticeira_escarlate)
        )

        listaPersonagens.add(
        Personagem("Gamorra", "Gamora foi uma personagem fictícia que apareceu nas histórias em quadrinhos publicadas pela Marvel Comics. Criada por Jim Starlin, a personagem apareceu pela primeira vez em \"Strange Tales\" #180. Gamora foi a filha adotiva de Thanos, e a última de sua espécie.", R.drawable.gamora)
        )

        listaPersonagens.add(
        Personagem("Homem de Ferro", "O Homem de Ferro foi um personagem dos quadrinhos publicados pela Marvel Comics. Sua verdadeira identidade é o empresário e bilionário Tony Stark, que usou armaduras de alta tecnologia no combate ao crime. Foi criado em 1963 pelo escritor Stan Lee, o roteirista Larry Lieber e os desenhistas Jack Kirby e Don Heck. ", R.drawable.homem_ferro)
        )

        listaPersonagens.add(
        Personagem("Mercúrio","Mercúrio é um personagem fictício das histórias em quadrinhos publicadas pela editora Marvel Comics. Foi criado por Stan Lee e Jack Kirby como vilão, herói e membro temporário dos X-Men, mas depois se tornaria herói e membro dos Vingadores.", R.drawable.mercurio)
        )

        listaPersonagens.add(
        Personagem("Mulher Invisível",
                "A Mulher Invisível, alter-ego de Susan \"Sue\" Richards, é uma super-heroína de histórias em quadrinhos da editora Marvel Comics. Quando foi criada e durante vários anos chamou-se Garota Invisível. No filme do Quarteto Fantástico de 2005 foi interpretada por Jessica Alba e no de 2015, por Kate Mara. ", R.drawable.mulher_invisivel)
        )

        listaPersonagens.add(
        Personagem("Noturno", "Noturno é um personagem fictício de quadrinhos do Universo Marvel. Ele tem sido associado a ambos, X-Men e Excalibur, originalmente aparecendo nas histórias em quadrinhos publicados pela Marvel Comics. Criado pelo escritor Len Wein e pelo artista Dave Cockrum, ele estreou no Gigante-Size X-Men ", R.drawable.noturno)
        )

        listaPersonagens.add(
        Personagem("Tempestade", "empestade é membro de uma subespécie de humanos nascidos com habilidades sobre-humanas conhecidas como mutantes. Ela é capaz de controlar o clima e a atmosfera e é considerada uma dos mutantes mais poderosas do planeta.", R.drawable.tempestade)
        )

        listaPersonagens.add(
        Personagem("Vampira", "Rogue (no Brasil, Vampira) é uma mutante Nível Ômega, personagem de histórias em quadrinhos da editora Marvel Comics. Vampira é integrante (e as vezes líder) de algumas equipes dos X-Men e dos Vingadores.", R.drawable.vampira)
        )

        listaPersonagens.add(
        Personagem("Vespa", "Vespa (do inglês Wasp) é uma personagem de histórias em quadrinhos da editora norte-americana Marvel Comics. Além de grande heroína e fundadora dos Vingadores, tornou-se também uma estilista extremamente renomada e altamente conceituada obtendo uma carreira de sucesso no Universo Marvel.", R.drawable.vespa)
        )

        listaPersonagens.add(
        Personagem("Wolverine", "Wolverine (nascido James Howlett[1] conhecido como Logan e às vezes como Arma X) é um personagem fictício que aparece em quadrinhos americanos publicados pela Marvel Comics, principalmente em associação com os X-Men. Ele é um mutante que possui sentidos afiados, capacidades físicas aprimoradas, habilidade regenerativa poderosa conhecida como fator de cura e três garras retratáveis de osso em cada mão. Wolverine foi retratado de forma variada como membro do X-Men, Tropa Alfa e Vingadores.", R.drawable.wolverine)
        )

        personagemAdapter.atualizarLista(listaPersonagens)
    }

    private fun irParaDetalhePersonagem(personagem: Personagem) {
        val bundle = bundleOf(CHAVE_PERSONAGEM to personagem)

        NavHostFragment.findNavController(this).navigate(
            R.id.action_listaPersonagensFragment_to_detalhePersonagensFragment, bundle
        )
    }

}