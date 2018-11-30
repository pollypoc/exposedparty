package com.lourdinas.finalaplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class calculadoramedia extends AppCompatActivity {

    //private double resultado = 0;
    private double nota_1 = 0;
    private double nota_2 = 0;
    private double nota_3 = 0;
    private double nota_4 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadoramedia);

        final EditText nota_1 = (EditText) findViewById(R.id.nota_1);
        final EditText nota_2 = (EditText) findViewById(R.id.nota_2);
        final EditText nota_3 = (EditText) findViewById(R.id.nota_3);
        final EditText nota_4 = (EditText) findViewById(R.id.nota_4);
        final TextView resul = (TextView) findViewById(R.id.resul);
        final Button calcular = (Button) findViewById(R.id.btn_calcular);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nota_1.getEditableText().equals("")) {
                    Toast.makeText(getApplicationContext(), "Digita a Nota 1!", Toast.LENGTH_LONG).show();
                }
                if (nota_2.getEditableText().equals("")) {
                    Toast.makeText(getApplicationContext(), "Digita a Nota 2!", Toast.LENGTH_LONG).show();
                }
                if (nota_3.getEditableText().equals("")) {
                    Toast.makeText(getApplicationContext(), "Digita a Nota 3!", Toast.LENGTH_LONG).show();
                }
                if (nota_4.getEditableText().equals("")) {
                    Toast.makeText(getApplicationContext(), "Digita a Nota 4!", Toast.LENGTH_LONG).show();
                } else {
                    String resultado = calcular(Double.parseDouble(nota_1.getEditableText().toString()), Double.parseDouble(nota_2.getEditableText().toString()), Double.parseDouble(nota_3.getEditableText().toString()), Double.parseDouble(nota_4.getEditableText().toString()));
                    resul.setText(resultado);
                }
            }
        });
    }


    public String calcular(Double nota_1, Double nota_2, Double nota_3, Double nota_4) {

        Double resultado = 0.0;

        resultado = (nota_1 + nota_2 + nota_3 + nota_4) / 4;

        return resultado.toString();
    }
}

