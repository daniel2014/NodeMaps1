package com.danielrsoares.nodemaps.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.danielrsoares.nodemaps.R;

public class LoginUsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_usuario);

        // == Alterando Título da Toobar === //
        getSupportActionBar().setTitle("Login de Usuário");
    }

    public void botaoCadastroUsuario(View view){
        startActivity(new Intent(this, CadastroUsuarioActivity.class));
    }

    public void butaoHome(View view){
        startActivity(new Intent(this, MainActivity.class));
    }

    public void butaoInventario(View view){
        startActivity(new Intent(this, InventarioActivity.class));
    }
}
