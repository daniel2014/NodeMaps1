package com.danielrsoares.nodemaps.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.danielrsoares.nodemaps.R;
import com.danielrsoares.nodemaps.fragments.AtividadesFragment;
import com.danielrsoares.nodemaps.fragments.HistoricoFragment;
import com.danielrsoares.nodemaps.fragments.PrincipalFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private PrincipalFragment principalFragment;
    private AtividadesFragment atividadesFragment;
    private HistoricoFragment historicoFragment;

    // ===== Menu Inferior Principal ====
    private TextView mTextMessage;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_prinvipal:

                    //Fragment Principal
                    mTextMessage.setText(R.string.titulo_home);
                    principalFragment = new PrincipalFragment(); //Fragment Principal
                    android.support.v4.app.FragmentTransaction transaction_1 = getSupportFragmentManager().beginTransaction();
                    transaction_1.replace(R.id.frameMain, principalFragment);
                    transaction_1.commit();
                    return true;

                    //Fragment Atividades
                case R.id.navigation_atividades:
                    mTextMessage.setText(R.string.titulo_atividades);
                    atividadesFragment = new AtividadesFragment();//Fragment Principal
                    android.support.v4.app.FragmentTransaction transaction_2 = getSupportFragmentManager().beginTransaction();
                    transaction_2.replace(R.id.frameMain, atividadesFragment);
                    transaction_2.commit();
                    return true;

                    //Fragment Hitórico
                case R.id.navigation_historico:
                    mTextMessage.setText(R.string.titulo_notificacao);
                    historicoFragment = new HistoricoFragment();//Fragment Principal
                    android.support.v4.app.FragmentTransaction transaction_3 = getSupportFragmentManager().beginTransaction();
                    transaction_3.replace(R.id.frameMain, historicoFragment);
                    transaction_3.commit();
                    return true;
            }
            return false;
        }
    };

     // ============= Método => OnCreate =========================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        principalFragment = new PrincipalFragment();
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameMain, principalFragment);
        transaction.commit();

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            startActivity(new Intent(this, MainActivity.class));
        } else if (id == R.id.nav_gallery) {
            startActivity(new Intent(this, InventarioActivity.class));
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
