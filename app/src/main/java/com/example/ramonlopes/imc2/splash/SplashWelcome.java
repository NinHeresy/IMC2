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

    private WelcomeHelper welcomeScreen;
    public static final String TAG_APP = "Aplicativo IMC";

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
                .page(new TitlePage(R.drawable.splash_img,
                        getResources().getString(R.string.page1))
                )
                .page(new BasicPage(R.drawable.splash_img,
                        getResources().getString(R.string.page2_string1),
                        getResources().getString(R.string.page2_string2))
                        .background(R.color.colorPrimary)
                )
                .bottomLayout(WelcomeConfiguration.BottomLayout.BUTTON_BAR_SINGLE)
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
