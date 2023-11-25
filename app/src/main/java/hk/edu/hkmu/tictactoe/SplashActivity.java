package hk.edu.hkmu.tictactoe;


import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

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

        ImageView imageView = findViewById(R.id.splash_monster);
        Animation animation = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.blink);

        TextView textView = findViewById(R.id.clickTo);

        imageView.startAnimation(animation);
        textView.startAnimation(animation);


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