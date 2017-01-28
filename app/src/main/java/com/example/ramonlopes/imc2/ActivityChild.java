package com.example.ramonlopes.imc2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class ActivityChild extends AppCompatActivity implements View.OnClickListener {

    public Button btn, btnlimpar;
    public EditText edtPeso, edtAltura, edtidade;
    public RadioButton radiowom, radiomen;
    public RadioGroup buttonSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn = (Button) findViewById(R.id.submit);
        btnlimpar = (Button) findViewById(R.id.btnclear);
        edtAltura = (EditText) findViewById(R.id.edt1);
        edtidade = (EditText) findViewById(R.id.editIdade);
        edtPeso = (EditText) findViewById(R.id.edt2);

        btnlimpar.setOnClickListener(this);
        //campo do raioButton
        chekec();
        //chamada do método de verificação dos campos
        nullcampos();
    }

    public void chekec() {
        //cheked
        radiomen = (RadioButton) findViewById(R.id.radioMen);
        radiowom = (RadioButton) findViewById(R.id.radiowoman);
        buttonSelect = (RadioGroup) findViewById(R.id.radioGroup);

        buttonSelect.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkId) {
                switch (checkId) {
                    case R.id.radioMen:

                        break;
                    case R.id.radiowoman:
                        break;
                }
            }
        });

    }

    //limpa os campos do editText
    @Override
    public void onClick(View v) {
        edtAltura.getText().clear();
        edtPeso.getText().clear();
        edtidade.getText().clear();
    }

    //verificando se os campos estao preenchidos
    public void nullcampos() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtAltura.getText().toString().length() == 0) {
                    Toasty.custom(getApplicationContext(), "Preencha o campo Altura !", R.drawable.alert, getResources()
                            .getColor(R.color.White), getResources()
                            .getColor(R.color.colorPrimaryDark), Toast.LENGTH_LONG, true, true).show();
                    //edtAltura.setError("Campo Altura em branco !");
                    edtAltura.requestFocus();
                    //btn.setEnabled(false);
                } else if (edtPeso.getText().toString().length() == 0) {
                    Toasty.custom(getApplicationContext(), "Preencha o campo Peso !", R.drawable.alert, getResources()
                            .getColor(R.color.White), getResources()
                            .getColor(R.color.colorPrimaryDark), Toast.LENGTH_LONG, true, true).show();
                    //edtPeso.setError("Campo Peso em branco !");
                    edtPeso.requestFocus();
                    //btn.setEnabled(false);
                } else if (edtidade.getText().toString().length() == 0) {
                    Toasty.custom(getApplicationContext(), "Preencha o campo Idade !", R.drawable.alert, getResources()
                            .getColor(R.color.White), getResources()
                            .getColor(R.color.colorPrimaryDark), Toast.LENGTH_LONG, true, true).show();
                    //edtidade.setError("Campo Peso em branco !");
                    edtidade.requestFocus();
                } else {
                    calcChild();
                }
            }
        });
    }

    //Math do IMC
    public void calcChild() {

        Double resultadoImc;
        float altura, peso;

        altura = Float.parseFloat(edtAltura.getText().toString());
        peso = Float.parseFloat(edtPeso.getText().toString());

        resultadoImc = peso / Math.pow(altura, 2);
        String resultIMC = String.format("%.2f", resultadoImc);


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

            }
        });
        alertDialogBuilder.setPositiveButton("Correto", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
}
