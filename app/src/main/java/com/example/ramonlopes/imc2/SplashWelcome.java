package com.example.ramonlopes.imc2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.stephentuso.welcome.BasicPage;
import com.stephentuso.welcome.TitlePage;
import com.stephentuso.welcome.WelcomeActivity;
import com.stephentuso.welcome.WelcomeConfiguration;
import com.stephentuso.welcome.WelcomeHelper;

public class SplashWelcome extends WelcomeActivity {

    public WelcomeHelper welcomeScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_splash_welcome);

        welcomeScreen = new WelcomeHelper(this, SplashWelcome.class);
        welcomeScreen.show(savedInstanceState);
    }

    @Override
    protected WelcomeConfiguration configuration() {
        return new WelcomeConfiguration.Builder(this)
                .defaultBackgroundColor(R.color.colorPrimary)
                .page(new TitlePage(0,
                        getResources().getString(R.string.teste))
                )
                .page(new BasicPage(0,
                        "Estamos a disposição para te ajudar",
                        "Conte conosco para o que der e vier !!")
                        .background(R.color.colorPrimary)
                )
                .page(new BasicPage(0,
                        "Estamos a disposição para te ajudar",
                        "Conte conosco para o que der e vier !!")
                )
                .swipeToDismiss(false)
                .build();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        welcomeScreen.onSaveInstanceState(outState);

    }
}
