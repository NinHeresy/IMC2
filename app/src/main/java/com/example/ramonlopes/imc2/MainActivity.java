package com.example.ramonlopes.imc2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import es.dmoral.toasty.Toasty;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText campPeso;
    private EditText campAltura;
    public Button btn, btnLimp;
    public Toolbar mToobar;

    public static final String TAG_APP = "Aplicativo IMC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        btnLimp = (Button) findViewById(R.id.btnLimpar);
        campPeso = (EditText) findViewById(R.id.edt2);
        campAltura = (EditText) findViewById(R.id.edt1);

        mToobar = (Toolbar) findViewById(R.id.my_tooblar);
        mToobar.setTitle("Indice de Massa Corporal");
        setSupportActionBar(mToobar);

        btnLimp.setOnClickListener(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (campAltura.getText().toString().length() == 0) {
                    Toasty.custom(getApplicationContext(), getResources().getString(R.string.msg_alert_alt), R.drawable.alert, getResources()
                            .getColor(R.color.White), getResources()
                            .getColor(R.color.colorPrimary), Toast.LENGTH_LONG, true, true).show();
                    //campAltura.setError("Campo Altura em branco !");
                    campAltura.requestFocus();
                } else if (campPeso.getText().toString().length() == 0) {
                    Toasty.custom(getApplicationContext(),
                            getResources().getString(R.string.msg_alert_peso), R.drawable.alert, getResources()
                                    .getColor(R.color.White), getResources()
                                    .getColor(R.color.colorPrimary), Toast.LENGTH_LONG, true, true).show();
                    //campPeso.setError("Campo Peso em branco !");
                    campPeso.requestFocus();
                } else {
                    open();
                }
            }
        });
    }

    //metodo de limpar os campos do EditText
    @Override
    public void onClick(View v) {
        campAltura.getText().clear();
        campPeso.getText().clear();

    }

    private void open() {
        Double resultadoImc;
        final Float altura, peso;

        altura = Float.parseFloat(campAltura.getText().toString());
        peso = Float.parseFloat(campPeso.getText().toString());
        resultadoImc = peso / (Math.pow(altura, 2));
        final String resultIMC = String.format("%.2f", resultadoImc);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        if (resultadoImc < 17) {
            alertDialogBuilder.setTitle("RESULTADO DO CALCULO:");
            alertDialogBuilder.setMessage("MUITO ABAIXO DO PESO!" +
                    "\nPara sua altura, o peso ideal está entre: 50kg e 60kg\n" +
                    "Resultado: " + resultIMC);

        } else if ((resultadoImc >= 17) || (resultadoImc <= 18.49)) {
            alertDialogBuilder.setTitle("RESULTADO DO CALCULO:");
            alertDialogBuilder.setMessage("ABAIXO DO PESO!" +
                    "\nPara sua altura, o peso ideal está entre: 60kg e 81kg\n" +
                    "Resultado: " + resultIMC);

        } else if ((resultadoImc >= 18.5) || (resultadoImc <= 24.99)) {
            alertDialogBuilder.setTitle("RESULTADO DO CALCULO:");
            alertDialogBuilder.setMessage("Parabéns, voce está no peso ideal!" +
                    "\nPara sua altura, o peso ideal está entre: 60kg e 81kg\n" +
                    "Resultado: " + resultIMC);

        } else if ((resultadoImc >= 25) || (resultadoImc <= 29.99)) {
            alertDialogBuilder.setTitle("RESULTADO DO CALCULO:");
            alertDialogBuilder.setMessage("ACIMA DO PESO!" +
                    "\nPara sua altura, o peso ideal está entre: 60kg e 81kg\n" +
                    "Resultado: " + resultIMC);

        } else if ((resultadoImc >= 30) || (resultadoImc <= 34.99)) {
            alertDialogBuilder.setTitle("RESULTADO DO CALCULO:");
            alertDialogBuilder.setMessage("OBESIDADE I!" +
                    "\nPara sua altura, o peso ideal está entre: 60kg e 81kg\n" +
                    "Resultado: " + resultIMC);

        } else if ((resultadoImc >= 35) || (resultadoImc <= 39.99)) {
            alertDialogBuilder.setTitle("RESULTADO DO CALCULO:");
            alertDialogBuilder.setMessage("OBESIDADE II (SEVERA)!" +
                    "\nPara sua altura, o peso ideal está entre: 60kg e 81kg\n" +
                    "Resultado: " + resultIMC);

        } else {
            alertDialogBuilder.setTitle("RESULTADO DO CALCULO:");
            alertDialogBuilder.setMessage("OBESIDADE III (MÓBIDA)\n" +
                    "Para sua altura, o peso ideal seria entre 45Kg e 69Kg\n" +
                    "Resultado: " + resultIMC);

        }
        alertDialogBuilder.setNegativeButton("Compartilhar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT, "Fiz o meu IMC e o resultado foi " + resultIMC + "." +
                        "http://www.calculoimc.com.br/");
                startActivity(Intent.createChooser(share, "Compartilhar via"));

            }
        });
        alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_child) {
            Intent intent = new Intent(this, ActivityChild.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.to_tutorial) {
            Intent copy = new Intent(this, ActivitysobreIMC.class);
            startActivity(copy);
            return true;
        }
        if (id == R.id.old_man) {
            Intent old_man = new Intent(this, OldManActivity.class);
            startActivity(old_man);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
