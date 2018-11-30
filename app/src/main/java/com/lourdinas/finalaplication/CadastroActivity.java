package com.lourdinas.finalaplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Button btn_reg = (Button)findViewById(R.id.btn_reg);

        EditText regnome = (EditText)findViewById(R.id.regnome);

        Intent intentRecebido = getIntent();
        String nome = intentRecebido.getStringExtra("nome");

        regnome.setText(nome);

        final EditText sobrenome = (EditText) findViewById(R.id.regsobrenome);
        final EditText formacao = (EditText) findViewById(R.id.regformação);
        final EditText telefone = (EditText) findViewById(R.id.regtelefone);
        final EditText data = (EditText) findViewById(R.id.regdata);
        final EditText email = (EditText) findViewById(R.id.regemail);


        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
                intent.putExtra("sobrenome", sobrenome.getText().toString());
                intent.putExtra("formacao", formacao.getText().toString());
                intent.putExtra("telefone", telefone.getText().toString());
                intent.putExtra("data", data.getText().toString());
                intent.putExtra("email", email.getText().toString());
                startActivity(intent);
                finish();


            }
        });
    }

}
