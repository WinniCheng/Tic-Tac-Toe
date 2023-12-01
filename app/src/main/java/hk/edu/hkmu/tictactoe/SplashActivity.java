package hk.edu.hkmu.tictactoe;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.preference.PreferenceManager;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends MenuClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Resources res = getResources();
        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        boolean isShowing = prefs.getBoolean(res.getString(R.string.pref_splash_key), res.getBoolean(R.bool.pref_splash_default));
        if (!isShowing) {
            showMainMenu();
            return;
        }

        setContentView(R.layout.splash);

        Animation blink = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.blink);

        ImageView logo = findViewById(R.id.splash_monster);
        TextView click = findViewById(R.id.clickTo);
        TextView title = findViewById(R.id.title);

        logo.startAnimation(blink);
        click.startAnimation(blink);
        title.startAnimation(blink);



    }
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN)
            showMainMenu();
        return true;
    }
    private void showMainMenu() {
        Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }

}