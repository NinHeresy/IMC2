package com.example.ramonlopes.imc2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityChild extends AppCompatActivity {

    Button btn;
    EditText edtPeso,edtAltura;
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


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_child, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //oinspection SimplifiableIfStatement
        if (id == R.id.rights_child) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
