package hk.edu.hkmu.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddPlayersActivity extends MenuClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

        EditText playerOne = findViewById(R.id.playerOne);
        EditText playerTwo = findViewById(R.id.playerTwo);
        Button startButton = findViewById(R.id.startGameButton);
        androidx.cardview.widget.CardView card = findViewById(R.id.card);
        TextView title = findViewById(R.id.title);

        Animation small_shake = AnimationUtils.loadAnimation(this, R.anim.small_shake);
        Animation zoom = AnimationUtils.loadAnimation(this, R.anim.zoom);
        card.startAnimation(small_shake);
        title.startAnimation(zoom);

        startButton.setOnClickListener(view -> {

            String PlayerOneName = playerOne.getText().toString();
            String PlayerTwoName = playerTwo.getText().toString();

            if (PlayerOneName.isEmpty() || PlayerTwoName.isEmpty()) {
                Toast.makeText(AddPlayersActivity.this, "Please enter player name", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(AddPlayersActivity.this, MainActivity.class);
                intent.putExtra("playerOne", PlayerOneName);
                intent.putExtra("playerTwo", PlayerTwoName);
                startActivity(intent);
            }
        });

    }
}
