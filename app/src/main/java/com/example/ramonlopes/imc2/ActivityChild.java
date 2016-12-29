package com.example.ramonlopes.imc2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityChild extends AppCompatActivity {

    Button btn;
    EditText edtPeso, edtAltura;
    Spinner spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn = (Button) findViewById(R.id.submit);
        edtAltura = (EditText) findViewById(R.id.edt1);
        edtPeso = (EditText) findViewById(R.id.edt2);
        spin = (Spinner) findViewById(R.id.spinner);


        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sexo_child, android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spin.setAdapter(adapter);

        final AdapterView.OnItemSelectedListener escolha = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 1) {
                    Toast.makeText(getApplicationContext(), "Selecionado o !" + i, Toast.LENGTH_SHORT).show();
                } else if (i == 2) {
                    Toast.makeText(getApplicationContext(), "Selecionado o !" + i, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };
        //obtem qual item da lista foi clicado
        spin.setOnItemSelectedListener(escolha);

        nullcampos();
    }

    public void nullcampos() {
        //verificando se os campos estao preenchidos
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtAltura.getText().toString().length() == 0) {
                    edtAltura.setError("Campo Altura Inválido !");
                    //Toast.makeText(getApplicationContext(), "Campo Altura está vazio!", Toast.LENGTH_SHORT).show();
                    edtAltura.requestFocus();
                } else if (edtPeso.getText().toString().length() == 0) {
                    edtPeso.setError("Campo Peso Inválido !");
                    //Toast.makeText(getApplicationContext(), "Campo Altura está vazio!", Toast.LENGTH_SHORT).show();
                    edtPeso.requestFocus();
                } else {
                    calcChild();
                }
            }
        });
    }

    //Math do IMC
    public void calcChild() {

        Double resultadoImc;
        Float altura, peso;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_child, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.rights_child) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
