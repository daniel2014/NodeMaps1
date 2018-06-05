package com.danielrsoares.nodemaps.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.danielrsoares.nodemaps.R;
import com.danielrsoares.nodemaps.adapter.AdapterInventario;
import com.danielrsoares.nodemaps.config.ConfiguracaoFirebase;
import com.danielrsoares.nodemaps.model.MovInventario;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class InventarioActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterInventario adapterInventario;
    private List<MovInventario> movInventarios = new ArrayList<>();

    private Spinner campoCidades;
    private String[] estados_doBrasil;
    private String cidade;
    private int posicao;


    private FirebaseAuth autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
    private DatabaseReference firebaseRef = ConfiguracaoFirebase.getFirebaseDatabase();
    private DatabaseReference movInventarioRef;
    private ValueEventListener valueEventListenerMovInventario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario);

        // == Alterando Título da Toobar === //
        getSupportActionBar().setTitle("Inventário");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Exibi o botão voltar  na actionBar
        //Tools.setSystemBarColor(this, R.color.pink_400);


        //FILTRO de CIDADES => Pegando a posicao do Spinner no array cidades
        estados_doBrasil = getResources().getStringArray(R.array.cidades); // Array se encontra em => res > values > array.xml
        campoCidades = findViewById(R.id.spinnerInventarioCidade); // Botão Spinner
        campoCidades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //valor = parent.getItemAtPosition(position).toString();
                //Toast.makeText(CadastroNodeActivity.this, cidade, Toast.LENGTH_SHORT).show();

                posicao = position; // verifica a posição do item ex: 0, 1, 2 correspodente do arrey selecionado do spinner da cidade

                // Atualiza os dados da pesquisa de cidades comparando com a posição atual(posicao) com a posição modificada pelo usuário(position)
                if (posicao == position){
                    recuperarMovInventario();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //Configurar Adapter
        adapterInventario = new AdapterInventario(movInventarios, this);

        //Configurar RecyclerView
        recyclerView = findViewById(R.id.recycler_Inventario);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        ((LinearLayoutManager) layoutManager).setReverseLayout(true);
        ((LinearLayoutManager) layoutManager).setStackFromEnd(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterInventario);


    }


    // Método Recuperando Movimentações
    public void recuperarMovInventario(){
        //String emailUsuario = autenticacao.getCurrentUser().getEmail(); //Aqui Recupera o E-mail do usuário cadastrado
        //String idUsuario = Base64Custom.codificarBase64(emailUsuario);

        movInventarioRef = firebaseRef.child("mov_inventarioNode")
        .child(estados_doBrasil[posicao]); // Adicionado (cidades) para o filtro de Cidades através do Spinner

        //Query movInventarioRef = firebaseRef.child("mov_inventarioNode").orderByChild("node").limitToLast(20000);

        valueEventListenerMovInventario = movInventarioRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                movInventarios.clear(); //Limpando movimentações

                for (DataSnapshot dados: dataSnapshot.getChildren()){ //Para recuperar todos os filhos de dataSnapshot
                    Log.i("dados1", "retorno: " + dados.toString());

                    MovInventario movInventario = dados.getValue(MovInventario.class);
                    movInventario.setKey(dados.getKey());//Recupera a chave ID do Item de cada movimentação lá no FireBase
                    movInventarios.add(movInventario); //Criando um Array de List
                    Log.i("dadosRetorno", "dados: " + movInventario.getNode());

                }
                //Método => Notifica o adapterInventario que os dados foram atualizado
                adapterInventario.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        Log.i("CIDADE","cidade:" );

    }

    public void atualizar(){

        recuperarMovInventario();
    }


    //Botão Fechar a Tela atual
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish(); //Fecha a Tela
        }
        return super.onOptionsItemSelected(item);
    }

    public void BotaoCadastrarNode(View view) {
        startActivity(new Intent(this, CadastroNodeActivity.class));
    }



    @Override
    protected void onResume() {
        super.onResume();
        recuperarMovInventario(); //recuperando movimentações

    }

    // === Recuperando o Resumo no estado onStart ou seja recupera Evento do Listener do método recuperarResumo abaixo ====/
    @Override
    protected void onStart() {
        super.onStart();
        //recuperarResumo();

    }
    //Sobreescrever a Classe onStop / ele é chamado sempre que o app não estiver mais sendo utilizado.
    //ou seja desanexando o Resumo do Listener no estado onStop ou seja desanexa o Evento do Listener do método recuperarResumo bem acima
    //Removendo Evento do Listener
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Evento", "Evento foi removido!");
        //usuarioRef.removeEventListener(valueEventListenerUsuario); // Remove EventListener de Referência de Usuário
        //movimentacaoRef.removeEventListener(valueEventListenerMovimentacoes); //Remove EventListener de Movimentação de Usuário
        movInventarioRef.removeEventListener(valueEventListenerMovInventario); //Remove EventListener de Inventario
    }

}
