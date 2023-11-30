package hk.edu.hkmu.tictactoe;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public abstract class MenuClass extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.setting) {
            Intent intent = new Intent(this, PreferenceActivity.class);
            startActivity(intent);
            return true;
        } else if (itemId == R.id.about) {
            new AlertDialog.Builder(this)
                    .setTitle("Rule of Tic-Tac-Toe")
                    .setMessage("\n" +
                            "The Tic-Tac-Toe game is played on 3 x 3 squares.\n\n" +
                            "Two players take turns marking Xs or Os on empty squares. \n\n" +
                            "The first player who gets 3 of his marks in a row wins the game. ")
                    .setNeutralButton(android.R.string.ok, null)
                    .show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
