package com.example.ramonlopes.imc2;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Ramon Lopes on 28/12/2016.
 */

public class Nullcampos extends ActivityChild {

    public void nullcampos(){

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sexo_child, android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spin.setAdapter(adapter);

        AdapterView.OnItemSelectedListener escolha = new AdapterView.OnItemSelectedListener() {
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
    }
}
