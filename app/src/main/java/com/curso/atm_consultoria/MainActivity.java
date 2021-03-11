package com.curso.atm_consultoria;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarEmail();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
            R.id.nav_principal, R.id.nav_servico, R.id.nav_clientes, R.id.nav_contato, R.id.nav_sobre
        ).setDrawerLayout(drawer).build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void enviarEmail(){

        Intent intent = new Intent(Intent.ACTION_SEND);

        //qual email enviar, pode ser enviado para varios, apenas separe com virgulas
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"atendimento@atmconsultoria.com.br", "outro"});

        //assunto do email
        intent.putExtra(Intent.EXTRA_SUBJECT, "Contato pelo App");

        //corpo da mensagem
        intent.putExtra(Intent.EXTRA_TEXT, "Mensagem automática");

        //definir que é um email, tipo de dado que vou compartilhar
        intent.setType("message/rfc822"); //tipo para email
        //intent.setType("text/plain"); //texto padrao
        //intent.setType("image/*"); //qualquer tipo de imagem
        //PESQUISAR MIME-TYPES NO GOOGLE APARECE UMA LISTA SOBRE TODOS

        // a partir de uma intent escolhe os apps que pode abrir aquela intent
        startActivity(Intent.createChooser(intent, "Escolha um App de e-mail"));

        /* FAZER UMA LIGAÇÃO
        String celular = "tel:11996352894";
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(celular));
        startActivity(intent);


        ABRIR UMA IMAGEM
        String imagem = "https://cdn.consumidormoderno.com.br/wp-content/uploads/2020/06/will-terra-H35OVHmtATo-unsplash-1024x768.jpg";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(imagem));
        startActivity(intent);


        ABRIR GOOGLE MAPS NO LOCAL DO LINK
        String endereco = "https://www.google.com.br/maps/place/Jardim+Novo+I,+Mogi+Gua%C3%A7u+-+SP/@-22.3453107,-46.9465259,15z/data=!3m1!4b1!4m5!3m4!1s0x94c856fc61e4202b:0xabb0afc7b6c5aa72!8m2!3d-22.3441942!4d-46.9380182";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(endereco));
        startActivity(intent);
         */
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
