package com.example.ramonlopes.imc2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.webkit.WebView;

public class ActivitysobreIMC extends AppCompatActivity {

    public WebView  web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitysobre_imc);



        web = (WebView)findViewById(R.id.webview);

        String texto = "<html><body>"
                + "<p align=\"justify\">"
                + getString(R.string.copy)
                + "</p> "
                + "</body></html>";
        web.loadData(texto,"text/html;charset=UTF-8",null);
    }
}
