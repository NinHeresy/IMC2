package com.example.ramonlopes.imc2;

import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.IdRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class ActivityChild extends AppCompatActivity implements View.OnClickListener {

    public Button btn, btnlimpar;
    private EditText edtPeso, edtAltura, edtidade;
    private static final int TIME_OUT = 3000;
    private static final int MSG_DISMISS_DIALOG = 0;
    private AlertDialog mAlertDialog;
    private Toolbar mToobar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn = (Button) findViewById(R.id.submit);
        btnlimpar = (Button) findViewById(R.id.btnclear);
        edtAltura = (EditText) findViewById(R.id.edt1);
        edtidade = (EditText) findViewById(R.id.editIdade);
        edtPeso = (EditText) findViewById(R.id.edt2);

        mToobar = (Toolbar) findViewById(R.id.my_tooblar);
        mToobar.setTitle("IMC para Crianças");
        mToobar.setNavigationIcon(R.drawable.back);
        setSupportActionBar(mToobar);

        //colcoando o button back em Write
        final Drawable back = ContextCompat
                .getDrawable(this,R.drawable.back);
        back.setColorFilter(ContextCompat.getColor(this,R.color.White), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(back);


        btnlimpar.setOnClickListener(this);
        //campo do radioButton
        check();
        //chamada do método de verificação dos campos
        nullcampos();

        //alertOncreate
        dialogChild();
    }

    public void check() {
        //checked
        RadioButton radiomen = (RadioButton) findViewById(R.id.radioMen);
        RadioButton radiowom = (RadioButton) findViewById(R.id.radiowoman);
        RadioGroup buttonSelect = (RadioGroup) findViewById(R.id.radioGroup);

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
                            .getColor(R.color.colorPrimary), Toast.LENGTH_LONG, true, true).show();
                    //edtAltura.setError("Campo Altura em branco !");
                    edtAltura.requestFocus();
                    //btn.setEnabled(false);
                } else if (edtPeso.getText().toString().length() == 0) {
                    Toasty.custom(getApplicationContext(), "Preencha o campo Peso !", R.drawable.alert, getResources()
                            .getColor(R.color.White), getResources()
                            .getColor(R.color.colorPrimary), Toast.LENGTH_LONG, true, true).show();
                    //edtPeso.setError("Campo Peso em branco !");
                    edtPeso.requestFocus();
                    //btn.setEnabled(false);
                } else if (edtidade.getText().toString().length() == 0) {
                    Toasty.custom(getApplicationContext(), "Preencha o campo Idade !", R.drawable.alert, getResources()
                            .getColor(R.color.White), getResources()
                            .getColor(R.color.colorPrimary), Toast.LENGTH_LONG, true, true).show();
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

    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_DISMISS_DIALOG:
                    if (mAlertDialog != null && mAlertDialog.isShowing()) {
                        mAlertDialog.dismiss();
                    }
            }
        }
    };


    private void dialogChild() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("ATENÇÃO:");
        builder.setMessage("Essa tela abaixo faz somente cálculos de IMC para crianças dos 6 á 15 anos de idade!");
        builder.setPositiveButton("OK", null)
                .setNegativeButton(null, null);
        mAlertDialog = builder.create();
        mAlertDialog.show();
        mHandler.sendEmptyMessageDelayed(MSG_DISMISS_DIALOG, TIME_OUT);

    }
}
