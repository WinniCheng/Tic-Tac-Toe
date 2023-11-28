package hk.edu.hkmu.tictactoe;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;

import hk.edu.hkmu.tictactoe.databinding.ActivityMainBinding;

public class MainActivity extends MenuClass {
    ActivityMainBinding binding;
    private final List<int[]> combinationList = new ArrayList<>();
    private int[] boxPositions = {0,0,0,0,0,0,0,0,0}; //9 zero
    private int playerTurn = 1;
    private int totalSelectedBoxes = 1;
    private static final String TAG = "MainActivity";
    private Board board;
    private Resources res;
    private SharedPreferences prefs;
    MediaPlayer mediaPlayer;
    MediaPlayer soundEffect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mediaPlayer = MediaPlayer.create(this, R.raw.game_bgm);
        soundEffect = MediaPlayer.create(this, R.raw.put_down);
        res = getResources();
        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());


        setContentView(binding.getRoot());

        board = new Board();

        String getPlayerOneName = getIntent().getStringExtra("playerOne");
        String getPlayerTwoName = getIntent().getStringExtra("playerTwo");

        binding.playerOneName.setText(getPlayerOneName);
        binding.playerTwoName.setText(getPlayerTwoName);

        binding.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (board.isBoxSelectable(0)){
                    performAction((ImageView) view, 0);
                }
                soundEffect.start();
            }
        });

        binding.image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (board.isBoxSelectable(1)){
                    performAction((ImageView) view, 1);
                }
                soundEffect.start();
            }
        });
        binding.image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (board.isBoxSelectable(2)){
                    performAction((ImageView) view, 2);
                }
                soundEffect.start();
            }
        });

        binding.image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (board.isBoxSelectable(3)){
                    performAction((ImageView) view, 3);
                }
                soundEffect.start();
            }
        });
        binding.image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (board.isBoxSelectable(4)){
                    performAction((ImageView) view, 4);
                }
                soundEffect.start();
            }
        });
        binding.image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (board.isBoxSelectable(5)){
                    performAction((ImageView) view, 5);
                }
                soundEffect.start();
            }
        });
        binding.image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (board.isBoxSelectable(6)){
                    performAction((ImageView) view, 6);
                }
                soundEffect.start();
            }
        });
        binding.image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (board.isBoxSelectable(7)){
                    performAction((ImageView) view, 7);
                }
                soundEffect.start();
            }
        });
        binding.image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (board.isBoxSelectable(8)){
                    performAction((ImageView) view, 8);
                }
                soundEffect.start();
            }
        });


    }

    private void performAction(ImageView  imageView, int selectedBoxPosition) {
        board.setBoxPosition(selectedBoxPosition, playerTurn);

        if (playerTurn == 1) {
            imageView.setImageResource(R.drawable.ximage);
            if (board.checkResults()) {
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, "The winner is " + binding.playerOneName.getText().toString()
                        + " !", MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            } else if(totalSelectedBoxes == 9) {
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, "Match Draw", MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            } else {
                changePlayerTurn(2);
                totalSelectedBoxes++;
            }
        } else {
            imageView.setImageResource(R.drawable.oimage);
            if (board.checkResults()) {
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, "The winner is " + binding.playerTwoName.getText().toString()
                        + " !", MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            } else if(totalSelectedBoxes == 9) {
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, "Match Draw", MainActivity.this);
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
            binding.playerTwoLayout.setBackgroundResource(R.drawable.white_box);
        } else {
            binding.playerTwoLayout.setBackgroundResource(R.drawable.thick_blue_border);
            binding.playerOneLayout.setBackgroundResource(R.drawable.white_box);
        }
    }

    public void restartMatch(){
        board.restartMatch(); //9 zero
        playerTurn = 1;
        totalSelectedBoxes = 1;

        binding.image1.setImageResource(R.drawable.white_box);
        binding.image2.setImageResource(R.drawable.white_box);
        binding.image3.setImageResource(R.drawable.white_box);
        binding.image4.setImageResource(R.drawable.white_box);
        binding.image5.setImageResource(R.drawable.white_box);
        binding.image6.setImageResource(R.drawable.white_box);
        binding.image7.setImageResource(R.drawable.white_box);
        binding.image8.setImageResource(R.drawable.white_box);
        binding.image9.setImageResource(R.drawable.white_box);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Retrieve and play background music
        boolean defaultValue = res.getBoolean(R.bool.pref_background_music_default);
        boolean musicOn = prefs.getBoolean(getString(R.string.pref_background_music_key), defaultValue);
        Log.i(TAG, Boolean.toString(musicOn));
        if (musicOn) {
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }

    }


}