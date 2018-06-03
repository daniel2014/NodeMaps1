package com.danielrsoares.nodemaps.activity;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.danielrsoares.nodemaps.R;
import com.danielrsoares.nodemaps.model.MovInventario;

public class CadastroNodeActivity extends AppCompatActivity {

    private TextView campoNode;
    private TextInputEditText campoCidade, campoBairro, campoEndereco, campoNumero;
    private Spinner campoCidades;
    private MovInventario movInventario;
    private String[] estados_doBrasil;
    private String cidade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_node);

        campoNode = findViewById(R.id.editTextCadastroNode);
        campoBairro = findViewById(R.id.editTextCadastroBairro);
        campoEndereco = findViewById(R.id.editTextCadastroEndereco);
        campoNumero = findViewById(R.id.editTextCadastroNumero);


        estados_doBrasil = getResources().getStringArray(R.array.cidades); // Array se encontra em => res > values > array.xml
        campoCidades = findViewById(R.id.spinner_CastNodeCidades); // Botão Spinner

        campoCidades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //String valor = parent.getItemAtPosition(position).toString();
                //Toast.makeText(CadastroNodeActivity.this, cidade, Toast.LENGTH_SHORT).show();
                cidade = estados_doBrasil[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    //Movimentação serão salvas no firebase
    public void salvarNode(View view){
        if (validarCamposSalvarNode()){
            movInventario = new MovInventario();
            movInventario.setNode(campoNode.getText().toString());
            movInventario.setCidade(cidade);
            movInventario.setBairro(campoBairro.getText().toString());
            movInventario.setEndereco(campoEndereco.getText().toString());
            movInventario.setNumero(campoNumero.getText().toString());
            movInventario.salvar();
            finish();
        }

    }

    //Método para Validar os Campos Preenchidos cadastro Node antes de Salvar
    public Boolean validarCamposSalvarNode(){
        String textNode = campoNode.getText().toString();
        String textBairro = campoBairro.getText().toString();
        String textEndereco = campoEndereco.getText().toString();
        String textNumero = campoNumero.getText().toString();

        if (!textNode.isEmpty()){
                if (!textBairro.isEmpty()){
                    if (!textEndereco.isEmpty()){
                        if (!textNumero.isEmpty()){

                            return true;

                        }else {
                            Toast.makeText(CadastroNodeActivity.this,
                                    "Preencha o Campo Número",
                                    Toast.LENGTH_SHORT).show();
                            return false;
                        }

                    }else {
                        Toast.makeText(CadastroNodeActivity.this,
                                "Preencha o Campo Endereço",
                                Toast.LENGTH_SHORT).show();
                        return false;
                    }

                }else {
                    Toast.makeText(CadastroNodeActivity.this,
                            "Preencha o Cammpo Bairro",
                            Toast.LENGTH_SHORT).show();
                    return false;
                }

        }else {
            Toast.makeText(CadastroNodeActivity.this,
                    "Preencha o Campo Node",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
    }

}

