package hk.edu.hkmu.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;


public class HomeActivity extends MenuClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageView homeLogo = (ImageView) findViewById(R.id.homeLogo);
        Animation small_zoom = AnimationUtils.loadAnimation(this, R.anim.small_zoom);
        homeLogo.startAnimation(small_zoom);



        Button start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AddPlayersActivity.class);
                startActivity(intent);
            }
        });
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        start.startAnimation(shake);

        Button settings = (Button) findViewById(R.id.setting);
        settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, PreferenceActivity.class);
                startActivity(intent);
            }
        });
        Button exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finishAffinity();
            }
        });
    }

}