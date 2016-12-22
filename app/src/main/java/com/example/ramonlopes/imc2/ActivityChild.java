package com.example.ramonlopes.imc2;

import android.content.Context;
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

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtAltura.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Campo Altura está vazio!", Toast.LENGTH_SHORT).show();
                    edtAltura.requestFocus();
                } else if (edtPeso.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Campo Altura está vazio!", Toast.LENGTH_SHORT).show();
                    edtPeso.requestFocus();
                } else {
                    calcChild();
                }
            }
        });
        spin = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sexo_child, android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spin.setAdapter(adapter);


        AdapterView.OnItemSelectedListener escolha = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    //calcMac();
                } else if (i == 1) {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };
        //obtem qual item da lista foi clicado
        spin.setOnItemSelectedListener(escolha);
    }

    public void calcChild() {

        Double resultadoImc;
        Float altura, peso;

        altura = Float.parseFloat(edtAltura.getText().toString());
        peso = Float.parseFloat(edtPeso.getText().toString());

        resultadoImc = peso / Math.pow(altura, 2);
        String resultIMC = String.format("%.2f", resultadoImc);

        Toast.makeText(getApplicationContext(), "Valor é: " + resultIMC, Toast.LENGTH_SHORT).show();
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
