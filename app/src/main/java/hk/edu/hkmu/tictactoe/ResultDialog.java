package hk.edu.hkmu.tictactoe;

import androidx.annotation.NonNull;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultDialog extends Dialog {

    private final String message;
    private final MainActivity mainActivity;

    public ResultDialog(@NonNull Context context, String message, MainActivity mainActivity) {
        super(context);
        this.message = message;
        this.mainActivity = mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_dialog);

        TextView result = findViewById(R.id.result);
        Button startAgain = findViewById(R.id.startAgainButton);
        Button exit = findViewById(R.id.exitButton);

        result.setText(message);

        startAgain.setOnClickListener(view -> {
            mainActivity.restartMatch();
            dismiss();
        });

        exit.setOnClickListener(view -> {
            mainActivity.restartMatch();
            dismiss();
            mainActivity.finishAffinity();

        });


    }
}
