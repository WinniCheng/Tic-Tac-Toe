package hk.edu.hkmu.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;


public class HomeActivity extends MenuClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageView homeLogo = findViewById(R.id.homeLogo);
        Button start = findViewById(R.id.start);
        Button settings = findViewById(R.id.setting);
        Button exit = findViewById(R.id.exit);

        Animation small_zoom = AnimationUtils.loadAnimation(this, R.anim.small_zoom);
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        homeLogo.startAnimation(small_zoom);
        start.startAnimation(shake);

        start.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, AddPlayersActivity.class);
            startActivity(intent);
        });

        settings.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, PreferenceActivity.class);
            startActivity(intent);
        });
        exit.setOnClickListener(v -> finishAffinity());
    }

}