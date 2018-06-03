package com.danielrsoares.nodemaps.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.danielrsoares.nodemaps.R;
import com.danielrsoares.nodemaps.config.ConfiguracaoFirebase;
import com.danielrsoares.nodemaps.utils.Tools;
import com.google.firebase.auth.FirebaseAuth;

public class InventarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario);

        // == Alterando Título da Toobar === //
        getSupportActionBar().setTitle("Inventário");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Tools.setSystemBarColor(this, R.color.pink_400);

    }

    //Botão Fechar a Tela atual
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish(); //Fecha a Tela
        }
        return super.onOptionsItemSelected(item);


    }

    public void BotaoCadastrarNode(View view){
        startActivity(new Intent(this, CadastroNodeActivity.class));
    }
}
