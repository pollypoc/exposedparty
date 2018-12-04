package com.lourdinas.finalaplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        TextView tx_nome = findViewById(R.id.regnome);
        TextView tx_sobrenome = findViewById(R.id.regsobrenome);
        TextView tx_formacao = findViewById(R.id.regformação);
        TextView tx_email = findViewById(R.id.regemail);
        TextView tx_telefone = findViewById(R.id.regtelefone);
        TextView tx_data = findViewById(R.id.regdata);

        Intent intentRecebido = getIntent();
        String nome = intentRecebido.getStringExtra("nome");
        String sobrenome = intentRecebido.getStringExtra("sobrenome");
        String formacao = intentRecebido.getStringExtra("formacao");
        String email = intentRecebido.getStringExtra("email");
        String telefone = intentRecebido.getStringExtra("telefone");
        String data = intentRecebido.getStringExtra("data");

        tx_nome.setText(nome);
        tx_sobrenome.setText(sobrenome);
        tx_formacao.setText(formacao);
        tx_email.setText(email);
        tx_telefone.setText(telefone);
        tx_data.setText(data);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(),
                    "Minhas configurações", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();

        if (id == R.id.configuracao) {
            Toast.makeText(getApplicationContext(),
                    "Abrir configurações", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.calcularMedia) {

            Intent intent = new Intent(MainActivity.this, calculadoramedia.class);
            startActivity(intent);

            Toast.makeText(getApplicationContext(),
                    "Abrir Calcular média", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.calculadora) {

            Intent intent = new Intent(MainActivity.this, calculadora.class);
            startActivity(intent);

            Toast.makeText(getApplicationContext(),
                    "Abrir Calculadora", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.chamadaFalsa) {

            Intent intent = new Intent(MainActivity.this, ChamadaActivity.class);
            startActivity(intent);

            Toast.makeText(getApplicationContext(),
                    "Abrir Chamada", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
