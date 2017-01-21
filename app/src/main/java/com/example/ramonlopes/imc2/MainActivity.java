package com.example.ramonlopes.imc2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
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

    public EditText campPeso;
    public EditText campAltura;
    Button btn, btnLimp;
    public Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        btnLimp = (Button) findViewById(R.id.btnLimpar);
        campPeso = (EditText) findViewById(R.id.edt2);
        campAltura = (EditText) findViewById(R.id.edt1);

        btnLimp.setOnClickListener(this);


        //tooblar
        // Toolbar mToolbar = (Toolbar) findViewById(R.id.my_tooblar);
        // mToolbar.setTitle("Indice de Massa Corporal");
        // mToolbar.setSubtitle("IMC");
        //setSupportActionBar(mToolbar);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (campAltura.getText().toString().length() == 0) {
                    Toasty.custom(getApplicationContext(), "Preencha o campo Altura !", R.drawable.alert, getResources()
                            .getColor(R.color.White), getResources().getColor(R.color.colorPrimaryDark), Toast.LENGTH_SHORT, true, true).show();
                    //Toasty.error(getApplicationContext(), "Preencha o campo Altura !", Toast.LENGTH_SHORT, true).show();
                    //campAltura.setError("Campo Altura em branco !");
                    campAltura.requestFocus();
                } else if (campPeso.getText().toString().length() == 0) {
                    Toasty.custom(getApplicationContext(), "Preencha o campo Peso !", R.drawable.alert, getResources()
                            .getColor(R.color.White), getResources().getColor(R.color.colorPrimaryDark), Toast.LENGTH_SHORT, true, true).show();
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


    public void open() {
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
                        " Site/ http://www.calculoimc.com.br/");
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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //oinspection SimplifiableIfStatement
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
        return super.onOptionsItemSelected(item);
    }
}
