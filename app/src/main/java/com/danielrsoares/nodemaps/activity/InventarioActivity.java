package com.danielrsoares.nodemaps.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.danielrsoares.nodemaps.R;

public class InventarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario);

        // == Alterando Título da Toobar === //
        getSupportActionBar().setTitle("Inventário");
    }

    public void BotaoCadastrarNode(View view){
        startActivity(new Intent(this, CadastroNodeActivity.class));
    }
}
