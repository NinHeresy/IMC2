package com.example.ramonlopes.imc2.splash;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.ramonlopes.imc2.MainActivity;
import com.example.ramonlopes.imc2.R;
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
                ).bottomLayout(WelcomeConfiguration.BottomLayout.BUTTON_BAR_SINGLE)
                .swipeToDismiss(false)
                .build();

    }

    //call acitivity Main
    @Override
    protected void onButtonBarFirstPressed() {
        super.onButtonBarFirstPressed();
        Intent call = new Intent(SplashWelcome.this, MainActivity.class);
        startActivity(call);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        welcomeScreen.onSaveInstanceState(outState);

    }


}
