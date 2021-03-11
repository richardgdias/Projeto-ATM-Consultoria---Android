package com.curso.atm_consultoria.ui.sobre;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.curso.atm_consultoria.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * A simple {@link Fragment} subclass.
 */
public class SobreFragment extends Fragment {


    public SobreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String descricao = "A ATM consultoria tem como apoiar osganizações que " +
                "desejam alcançar o sucesso atráves da excelência em gestão e da busca pela qualidade";

        Element versao = new Element();
        versao.setTitle("Versão 1.0");

        return new AboutPage (getActivity())
                .setImage(R.drawable.logo)
                .setDescription(descricao)

                .addGroup("Entre em contato")
                .addEmail("atendimento@atmconsultoria.com.br", "Envie um e-mail")
                .addWebsite("https://google.com.br", "Acesse nosso site")

                .addGroup("Redes sociais")
                .addFacebook("richard.glauberdias", "Facebook")
                .addInstagram("richard_gdias", "Instagram")
                .addTwitter("richardgdias", "Twitter")
                .addYoutube("richardgdias", "Youtube")
                .addGitHub("richardgdias", "GitHub")
                .addPlayStore("com.facebook.katana", "Download App")

                .addItem(versao)

                .create();

        //return inflater.inflate(R.layout.fragment_sobre, container, false);
    }
}
