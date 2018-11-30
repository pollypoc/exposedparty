package com.lourdinas.finalaplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class calculadora extends AppCompatActivity {

    private String memoria;
    private String operacao;
    private Double valor1 = 0.0;
    private Double valor2 = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);


        final TextView displayConta = (TextView) findViewById(R.id.displayConta);
        final TextView displayResult = (TextView) findViewById(R.id.displayResult);


        final Button btn0 = (Button) findViewById(R.id.btn_0);
        final Button btn1 = (Button) findViewById(R.id.btn_1);
        final Button btn2 = (Button) findViewById(R.id.btn_2);
        final Button btn3 = (Button) findViewById(R.id.btn_3);
        final Button btn4 = (Button) findViewById(R.id.btn_4);
        final Button btn5 = (Button) findViewById(R.id.btn_5);
        final Button btn6 = (Button) findViewById(R.id.btn_6);
        final Button btn7 = (Button) findViewById(R.id.btn_7);
        final Button btn8 = (Button) findViewById(R.id.btn_8);
        final Button btn9 = (Button) findViewById(R.id.btn_9);
        final Button btnSomar         = (Button) findViewById(R.id.btnSomar);
        final Button btnMultiplicao = (Button) findViewById(R.id.btnMultiplicao);
        final Button btnDivisao       = (Button) findViewById(R.id.btnDivisao);
        final Button btnSubtracao     = (Button) findViewById(R.id.btnSubtracao);
        final Button btnVirgula       = (Button) findViewById(R.id.btnVirgula);
        final Button btnIgual         = (Button) findViewById(R.id.btnIgual);
        final Button btnApagar        = (Button) findViewById(R.id.btnApagar);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                memoria = (String) displayConta.getText();
                displayConta.setText(memoria + "0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                memoria = (String) displayConta.getText();
                displayConta.setText(memoria + "1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                memoria = (String) displayConta.getText();
                displayConta.setText(memoria + "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                memoria = (String) displayConta.getText();
                displayConta.setText(memoria + "3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                memoria = (String) displayConta.getText();
                displayConta.setText(memoria + "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                memoria = (String) displayConta.getText();
                displayConta.setText(memoria + "5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                memoria = (String) displayConta.getText();
                displayConta.setText(memoria + "6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                memoria = (String) displayConta.getText();
                displayConta.setText(memoria + "7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                memoria = (String) displayConta.getText();
                displayConta.setText(memoria + "8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                memoria = (String) displayConta.getText();
                displayConta.setText(memoria + "9");
            }
        });
        btnVirgula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                memoria = (String) displayConta.getText();
                displayConta.setText(memoria + ",");
            }
        });

        btnApagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                memoria = "";
                displayConta.setText("");
                displayResult.setText("");
            }
        });

        btnSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacao = "+";
                valor1 = Double.parseDouble(displayConta.getText().toString());
                displayResult.setText(displayConta.getText().toString() + "+");
                displayConta.setText("");
            }
        });
        btnSubtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacao = "-";
                valor1 = Double.parseDouble(displayConta.getText().toString());
                displayResult.setText(displayConta.getText().toString() + "-");
                displayConta.setText("");
            }
        });
        btnMultiplicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacao = "x";
                valor1 = Double.parseDouble(displayConta.getText().toString());
                displayResult.setText(displayConta.getText().toString() + "x");
                displayConta.setText("");
            }
        });
        btnDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacao = "/";
                valor1 = Double.parseDouble(displayConta.getText().toString());
                displayResult.setText(displayConta.getText().toString() + "/");
                displayConta.setText("");
            }
        });
        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (displayConta.getText().equals("")){

                    Toast.makeText(getApplicationContext(),
                            "Digite um número", Toast.LENGTH_LONG).show();

                }
                else {

                    //operacao = "=";
                    valor2 = Double.parseDouble(displayConta.getText().toString());
                    displayConta.setText("");
                    String resultado = Calcular(valor1,valor2, operacao);
                    displayResult.setText(resultado);
                }
            }
        });


    }
    public String Calcular(Double valor1, Double valor2, String operacao){

        Double resultado = 0.0;

        if (operacao.equals("+")){
            resultado = valor1+valor2;
        }
        else if (operacao.equals("-")){
            resultado = valor1-valor2;
        }
        else if(operacao.equals("x")){
            resultado = valor1*valor2;
        }
        else if (operacao.equals("/")){
            if (valor2 == 0){
                Toast.makeText(getApplicationContext(), "Não é possível dividir por 0!", Toast.LENGTH_LONG).show();
            }
            else{
                resultado = valor1/valor2;
            }
        }


        return resultado.toString();
    }
}
