package com.lourdinas.finalaplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChamadaActivity extends AppCompatActivity {

    String memoria = "";
    TextView txtnumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chamada);

        txtnumero = findViewById(R.id.txtnumeros);
        Button ligar = findViewById(R.id.btnligar);
        Button apagar = findViewById(R.id.btnapagar);
        Button asterisco = findViewById(R.id.btnasterisco);
        Button hashtag = findViewById(R.id.btnhashtag);
        Button btn0 = findViewById(R.id.btn_0);
        Button btn1 = findViewById(R.id.btn_1);
        Button btn2 = findViewById(R.id.btn_2);
        Button btn3 = findViewById(R.id.btn_3);
        Button btn4 = findViewById(R.id.btn_4);
        Button btn5 = findViewById(R.id.btn_5);
        Button btn6 = findViewById(R.id.btn_6);
        Button btn7 = findViewById(R.id.btn_7);
        Button btn8 = findViewById(R.id.btn_8);
        Button btn9 = findViewById(R.id.btn_9);

        btn0.setOnClickListener(myListener);
        btn1.setOnClickListener(myListener);
        btn2.setOnClickListener(myListener);
        btn3.setOnClickListener(myListener);
        btn4.setOnClickListener(myListener);
        btn5.setOnClickListener(myListener);
        btn6.setOnClickListener(myListener);
        btn7.setOnClickListener(myListener);
        btn8.setOnClickListener(myListener);
        btn9.setOnClickListener(myListener);
        ligar.setOnClickListener(myListener);
        asterisco.setOnClickListener(myListener);
        hashtag.setOnClickListener(myListener);
        apagar.setOnClickListener(myListener);

    }

    private View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_0:
                    setDisplayText("0");
                    break;
                case R.id.btn_1:
                    setDisplayText("1");
                    break;
                case R.id.btn_2:
                    setDisplayText("2");
                    break;
                case R.id.btn_3:
                    setDisplayText("3");
                    break;
                case R.id.btn_4:
                    setDisplayText("4");
                    break;
                case R.id.btn_5:
                    setDisplayText("5");
                    break;
                case R.id.btn_6:
                    setDisplayText("6");
                    break;
                case R.id.btn_7:
                    setDisplayText("7");
                    break;
                case R.id.btn_8:
                    setDisplayText("8");
                    break;
                case R.id.btn_9:
                    setDisplayText("9");
                    break;
                case R.id.btnasterisco:
                    setDisplayText("*");
                    break;
                case R.id.btnhashtag:
                    setDisplayText("#");
                    break;
                case R.id.btnapagar:
                    //codigo by felix
                    if (memoria.length()>0){
                        memoria = memoria.substring(0, memoria.length()-1);
                        txtnumero.setText(memoria);
                    }
                    break;

                case R.id.btnligar:

                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + memoria));

                    if(ActivityCompat.checkSelfPermission(ChamadaActivity.this,
                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){

                        ActivityCompat.requestPermissions(ChamadaActivity.this,
                                new String[]{Manifest.permission.CALL_PHONE},
                                0);
                    }

                    startActivity(intent);
                    break;
            }
        }
    };

    private void setDisplayText(String valor) {
        memoria = memoria + valor;
        txtnumero.setText(memoria);
    }
}
