package com.example.ramonlopes.imc2;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.webkit.WebView;

public class ActivitysobreIMC extends AppCompatActivity {

    public WebView  web;
    public Toolbar mToobar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitysobre_imc);

        mToobar = (Toolbar) findViewById(R.id.my_tooblar);
        mToobar.setTitle("Sobre IMC");
        mToobar.setSubtitle("Tire suas duvidas sobre o IMC !");
        mToobar.setNavigationIcon(R.drawable.back);
        setSupportActionBar(mToobar);

        //colcoando o button back em Write
        final Drawable upArrow = ContextCompat
                .getDrawable(this,R.drawable.back);
        upArrow.setColorFilter(ContextCompat
                .getColor(this,R.color.White), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar()
                .setHomeAsUpIndicator(upArrow);

        web = (WebView)findViewById(R.id.webview);

        String texto = "<html><body>"
                + "<p align=\"justify\">"
                + getString(R.string.copy)
                + "</p> "
                + "</body></html>";
        web.loadData(texto,"text/html;charset=UTF-8",null);
    }
}
