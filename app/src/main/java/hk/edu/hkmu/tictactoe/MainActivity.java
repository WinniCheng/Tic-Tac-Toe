package hk.edu.hkmu.tictactoe;

import android.content.SharedPreferences;
import android.content.res.Resources;
import androidx.preference.PreferenceManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import hk.edu.hkmu.tictactoe.databinding.ActivityMainBinding;

public class MainActivity extends MenuClass {
    ActivityMainBinding binding;
    private int playerTurn = 1;
    private int totalSelectedBoxes = 1;
    private static final String TAG = "MainActivity";
    private BoardClass board;
    private Resources res;
    private SharedPreferences prefs;
    MediaPlayer gameBGM;
    MediaPlayer soundEffect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gameBGM = MediaPlayer.create(this, R.raw.game_bgm);
        soundEffect = MediaPlayer.create(this, R.raw.put_down);
        res = getResources();
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        board = new BoardClass();

        String getPlayerOneName = getIntent().getStringExtra("playerOne");
        String getPlayerTwoName = getIntent().getStringExtra("playerTwo");

        binding.playerOneName.setText(getPlayerOneName);
        binding.playerTwoName.setText(getPlayerTwoName);
        binding.playerOneLayout.setBackgroundResource(R.drawable.thick_blue_border);
        binding.playerTwoLayout.setBackgroundResource(R.drawable.game_box);

        binding.image1.setOnClickListener(view -> {
            if (board.isBoxSelectable(0)){
                performAction((ImageView) view, 0);
            }
            boolean defaultValue = res.getBoolean(R.bool.pref_sound_effect_default);
            boolean effectOn = prefs.getBoolean(getString(R.string.pref_sound_effect_key), defaultValue);
            if (effectOn) {
                soundEffect.start();
            }
        });

        binding.image2.setOnClickListener(view -> {
            if (board.isBoxSelectable(1)){
                performAction((ImageView) view, 1);
            }
            boolean defaultValue = res.getBoolean(R.bool.pref_sound_effect_default);
            boolean effectOn = prefs.getBoolean(getString(R.string.pref_sound_effect_key), defaultValue);
            if (effectOn) {
                soundEffect.start();
            }
        });
        binding.image3.setOnClickListener(view -> {
            if (board.isBoxSelectable(2)){
                performAction((ImageView) view, 2);
            }
            boolean defaultValue = res.getBoolean(R.bool.pref_sound_effect_default);
            boolean effectOn = prefs.getBoolean(getString(R.string.pref_sound_effect_key), defaultValue);
            if (effectOn) {
                soundEffect.start();
            }
        });

        binding.image4.setOnClickListener(view -> {
            if (board.isBoxSelectable(3)){
                performAction((ImageView) view, 3);
            }
            boolean defaultValue = res.getBoolean(R.bool.pref_sound_effect_default);
            boolean effectOn = prefs.getBoolean(getString(R.string.pref_sound_effect_key), defaultValue);
            if (effectOn) {
                soundEffect.start();
            }
        });
        binding.image5.setOnClickListener(view -> {
            if (board.isBoxSelectable(4)){
                performAction((ImageView) view, 4);
            }
            boolean defaultValue = res.getBoolean(R.bool.pref_sound_effect_default);
            boolean effectOn = prefs.getBoolean(getString(R.string.pref_sound_effect_key), defaultValue);
            if (effectOn) {
                soundEffect.start();
            }
        });
        binding.image6.setOnClickListener(view -> {
            if (board.isBoxSelectable(5)){
                performAction((ImageView) view, 5);
            }
            boolean defaultValue = res.getBoolean(R.bool.pref_sound_effect_default);
            boolean effectOn = prefs.getBoolean(getString(R.string.pref_sound_effect_key), defaultValue);
            if (effectOn) {
                soundEffect.start();
            }
        });
        binding.image7.setOnClickListener(view -> {
            if (board.isBoxSelectable(6)){
                performAction((ImageView) view, 6);
            }
            boolean defaultValue = res.getBoolean(R.bool.pref_sound_effect_default);
            boolean effectOn = prefs.getBoolean(getString(R.string.pref_sound_effect_key), defaultValue);
            if (effectOn) {
                soundEffect.start();
            }
        });
        binding.image8.setOnClickListener(view -> {
            if (board.isBoxSelectable(7)){
                performAction((ImageView) view, 7);
            }
            boolean defaultValue = res.getBoolean(R.bool.pref_sound_effect_default);
            boolean effectOn = prefs.getBoolean(getString(R.string.pref_sound_effect_key), defaultValue);
            if (effectOn) {
                soundEffect.start();
            }
        });
        binding.image9.setOnClickListener(view -> {
            if (board.isBoxSelectable(8)){
                performAction((ImageView) view, 8);
            }
            boolean defaultValue = res.getBoolean(R.bool.pref_sound_effect_default);
            boolean effectOn = prefs.getBoolean(getString(R.string.pref_sound_effect_key), defaultValue);
            if (effectOn) {
                soundEffect.start();
            }
        });


    }

    private void performAction(ImageView  imageView, int selectedBoxPosition) {
        board.setBoxPosition(selectedBoxPosition, playerTurn);

        if (playerTurn == 1) {
            imageView.setImageResource(R.drawable.large_x_icon);
            if (board.checkResults()) {
                String winnerMessage = getString(R.string.winner_message, binding.playerOneName.getText().toString());
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, winnerMessage, MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            } else if(totalSelectedBoxes == 9) {
                String winnerMessage = getString(R.string.tie_game);
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, winnerMessage, MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            } else {
                changePlayerTurn(2);
                totalSelectedBoxes++;
            }
        } else {
            imageView.setImageResource(R.drawable.large_o_icon);
            if (board.checkResults()) {
                String winnerMessage = getString(R.string.winner_message, binding.playerTwoName.getText().toString());
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, winnerMessage, MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            } else if(totalSelectedBoxes == 9) {
                String winnerMessage = getString(R.string.tie_game);
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, winnerMessage, MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            } else {
                changePlayerTurn(1);
                totalSelectedBoxes++;
            }
        }
    }

    private void changePlayerTurn(int currentPlayerTurn) {
        playerTurn = currentPlayerTurn;
        if (playerTurn == 1) {
            binding.playerOneLayout.setBackgroundResource(R.drawable.thick_blue_border);
            binding.playerTwoLayout.setBackgroundResource(R.drawable.game_box);
        } else {
            binding.playerTwoLayout.setBackgroundResource(R.drawable.thick_blue_border);
            binding.playerOneLayout.setBackgroundResource(R.drawable.game_box);
        }
    }

    public void restartMatch(){
        board.restartMatch();
        playerTurn = 1;
        totalSelectedBoxes = 1;

        binding.playerOneLayout.setBackgroundResource(R.drawable.thick_blue_border);
        binding.playerTwoLayout.setBackgroundResource(R.drawable.game_box);
        binding.image1.setImageResource(R.drawable.game_box);
        binding.image2.setImageResource(R.drawable.game_box);
        binding.image3.setImageResource(R.drawable.game_box);
        binding.image4.setImageResource(R.drawable.game_box);
        binding.image5.setImageResource(R.drawable.game_box);
        binding.image6.setImageResource(R.drawable.game_box);
        binding.image7.setImageResource(R.drawable.game_box);
        binding.image8.setImageResource(R.drawable.game_box);
        binding.image9.setImageResource(R.drawable.game_box);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (gameBGM != null && gameBGM.isPlaying()) {
            gameBGM.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        boolean defaultValue = res.getBoolean(R.bool.pref_background_music_default);
        boolean musicOn = prefs.getBoolean(getString(R.string.pref_background_music_key), defaultValue);
        Log.i(TAG, Boolean.toString(musicOn));
        if (musicOn) {
            gameBGM.start();
            gameBGM.setLooping(true);
        }

    }


}