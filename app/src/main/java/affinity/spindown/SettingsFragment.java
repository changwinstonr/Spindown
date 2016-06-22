package affinity.spindown;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by aaron on 6/22/2016.
 */
public class SettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
