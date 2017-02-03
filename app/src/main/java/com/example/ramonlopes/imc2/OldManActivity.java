package com.example.ramonlopes.imc2;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OldManActivity extends AppCompatActivity implements View.OnClickListener {

    public Button btnCal,btnClear;
    private EditText campPeso, campAlt;
    private Toolbar mToobar;

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
        mToobar.setNavigationIcon(R.drawable.back_left);
        setSupportActionBar(mToobar);

        //colcoando o button back em Write
        final Drawable upArrow = ContextCompat
                .getDrawable(this,R.drawable.back_left);
        upArrow.setColorFilter(ContextCompat.getColor(this,R.color.White), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        btnClear.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        campAlt.getText().clear();
        campPeso.getText().clear();
    }
}