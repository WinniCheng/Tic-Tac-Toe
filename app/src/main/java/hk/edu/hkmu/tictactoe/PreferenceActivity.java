package hk.edu.hkmu.tictactoe;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.PreferenceFragmentCompat;

public class PreferenceActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fragment fragment = new SettingPreferenceFragment();
        FragmentTransaction txn = getSupportFragmentManager().beginTransaction();
        txn.replace(android.R.id.content, fragment);
        txn.commit();
    }

    public static class SettingPreferenceFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            addPreferencesFromResource(R.xml.preferences);
        }
    }

}