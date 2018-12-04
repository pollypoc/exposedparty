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

        final EditText nome = findViewById(R.id.regnome);

        final EditText sobrenome = findViewById(R.id.regsobrenome);
        final EditText formacao = findViewById(R.id.regformação);
        final EditText telefone = findViewById(R.id.regtelefone);
        final EditText data = findViewById(R.id.regdata);
        final EditText email = findViewById(R.id.regemail);


        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadastroActivity.this, MainActivity.class);
                intent.putExtra("nome", nome.getText().toString());
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
