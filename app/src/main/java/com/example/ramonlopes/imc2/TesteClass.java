package com.example.ramonlopes.imc2;

import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Ramon Lopes on 29/12/2016.
 */

public class TesteClass extends MainActivity {
    EditText text;
    String teste;

    public String toast() {

        text = (EditText) findViewById(R.id.edt2);
        teste = text.getText().toString();
        return teste;
    }
}
