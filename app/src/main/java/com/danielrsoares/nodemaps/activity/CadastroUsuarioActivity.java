package com.danielrsoares.nodemaps.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.danielrsoares.nodemaps.R;

public class CadastroUsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        // == Alterando Título da Toobar === //
        getSupportActionBar().setTitle("Cadastro de Usuário");
    }
}