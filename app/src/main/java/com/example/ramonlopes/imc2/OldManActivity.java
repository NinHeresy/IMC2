package com.example.ramonlopes.imc2;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OldManActivity extends AppCompatActivity implements View.OnClickListener {

    public Button btnCal,btnClear;
    private EditText campPeso, campAlt;
    public Toolbar mToobar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_man);

        btnClear = (Button)findViewById(R.id.btnLimpar);
        btnCal = (Button)findViewById(R.id.btn);
        campPeso = (EditText)findViewById(R.id.edt2);
        campAlt = (EditText)findViewById(R.id.edt1);

        mToobar = (Toolbar) findViewById(R.id.my_tooblar);
        mToobar.setTitle("IMC para Idosos");
        mToobar.setNavigationIcon(R.drawable.back);
        setSupportActionBar(mToobar);

        //colcoando o button back em Write
        final Drawable upArrow = ContextCompat
                .getDrawable(this,R.drawable.back);
        upArrow.setColorFilter(ContextCompat.getColor(this,R.color.White), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        btnClear.setOnClickListener(this);

        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcOld();
            }
        });
    }
    @Override
    public void onClick(View v) {
        campAlt.getText().clear();
        campPeso.getText().clear();
    }


    public void calcOld(){
        Double resultadoImc;
        Float altura, peso;

        altura = Float.parseFloat(campAlt.getText().toString());
        peso = Float.parseFloat(campPeso.getText().toString());
        resultadoImc = peso / (Math.pow(altura, 2));
        final String resultIMC = String.format("%.2f", resultadoImc);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        if (resultadoImc <= 22) {
            alertDialogBuilder.setTitle("RESULTADO DO CALCULO:");
            alertDialogBuilder.setMessage("ABAIXO DO PESO!" +
                    "\nPara sua altura, o peso ideal está entre: 50kg e 60kg\n" +
                    "Resultado: " + resultIMC);

        } else if ((resultadoImc > 22) && (resultadoImc < 27)) {
            alertDialogBuilder.setTitle("RESULTADO DO CALCULO:");
            alertDialogBuilder.setMessage("PESO ADEQUADO!" +
                    "\nPara sua altura, o peso ideal está entre: 60kg e 81kg\n" +
                    "Resultado: " + resultIMC);

        } else if (resultadoImc >= 27) {
            alertDialogBuilder.setTitle("RESULTADO DO CALCULO:");
            alertDialogBuilder.setMessage("SOBREPESO!" +
                    "\nPara sua altura, o peso ideal está entre: 60kg e 81kg\n" +
                    "Resultado: " + resultIMC);

        }
        alertDialogBuilder.setNegativeButton("Compartilhar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT, "Fiz o IMC, e olhe o resultado: " + resultIMC +
                        "http://indicedemassacorporal.com");
                startActivity(Intent.createChooser(share, "Compartilhar...."));

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
}