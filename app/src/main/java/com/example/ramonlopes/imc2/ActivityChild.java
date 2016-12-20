package com.example.ramonlopes.imc2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityChild extends AppCompatActivity {

    Button btn;
    EditText edtPeso,edtAltura;
    Spinner spn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        btn = (Button)findViewById(R.id.submit);
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
                }
            }
        });

        //spinner para definir o sexo do usuario
        spn = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.sexo_child,android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spn.setAdapter(adapter);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_child, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.rights_child) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
