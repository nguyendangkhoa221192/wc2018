package wc.dev.khoand.worldcup;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

import wc.dev.khoand.worldcup.Fragment.BottomNavigationFragment;
import wc.dev.khoand.worldcup.Fragment.Country;
import wc.dev.khoand.worldcup.Fragment.MatchSchedule;

public class MainActivity extends AppCompatActivity {

    private static final String TAG_FRAGMENT_SCHEDULE = "tag_frag_schedule";
    private static final String TAG_FRAGMENT_DASHBOARD = "tag_frag_dashboard";
    private static final String TAG_FRAGMENT_NOTIFY = "tag_frag_notify";

    private ArrayList<Fragment> fragments = new ArrayList<>();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_schedule:
                    switchFrag(0, TAG_FRAGMENT_SCHEDULE);
                    return true;
                case R.id.navigation_dashboard:
                    switchFrag(1, TAG_FRAGMENT_DASHBOARD);
                    return true;
                case R.id.navigation_notifications:
                    switchFrag(2, TAG_FRAGMENT_NOTIFY);
                    return true;
            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buildListFrag();

        BottomNavigationView navigation = findViewById(R.id.navigation);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        switchFrag(0, TAG_FRAGMENT_SCHEDULE);
    }

    private void switchFrag(int pos, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_holder, fragments.get(pos), tag)
                .commit();
    }

    private void buildListFrag() {
        MatchSchedule matchSchedule = new MatchSchedule();
        Country country = new Country();
        BottomNavigationFragment frag_notify = buildFragment("Notify");

        fragments.add(matchSchedule);
        fragments.add(country);
        fragments.add(frag_notify);
    }

    private BottomNavigationFragment buildFragment(String title) {
        BottomNavigationFragment bottomNavigationFragment = new BottomNavigationFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BottomNavigationFragment.ARG_TITLE, title);

        bottomNavigationFragment.setArguments(bundle);

        return bottomNavigationFragment;
    }

}
