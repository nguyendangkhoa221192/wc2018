package wc.dev.khoand.worldcup.Fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import wc.dev.khoand.worldcup.APIClient.APIUtils;
import wc.dev.khoand.worldcup.Items.FixtureItem;
import wc.dev.khoand.worldcup.MainItem.MatchItem;
import wc.dev.khoand.worldcup.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MatchSchedule extends BaseFragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private MatchItem matchItem;
    public static final String ARGS_FIXTURE = "fixture";

    public MatchSchedule() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_match_schedule, container, false);
        tabLayout = root.findViewById(R.id.match_sch_tabs);
        viewPager = root.findViewById(R.id.match_sch_viewpager);
        loadApiMatchInfo();
        // Inflate the layout for this fragment
        return root;
    }

    private void loadApiMatchInfo() {
        apiService = APIUtils.getMyService();
        apiService.getMatchInfo().enqueue(new Callback<MatchItem>() {
            @Override
            public void onResponse(Call<MatchItem> call, Response<MatchItem> response) {
                if (response.isSuccessful()) {
                    matchItem = response.body();
                    for (int i = 0; i < matchItem.getFixtures().size(); i++) {
                        matchItem.getFixtures().get(i).setDate(matchItem.getFixtures().get(i).getDate().replace("T", " "));
                    }
                    setupViewPaper(viewPager);
                    tabLayout.setupWithViewPager(viewPager);
                } else {

                }
            }

            @Override
            public void onFailure(Call<MatchItem> call, Throwable t) {

            }
        });
    }


    private void setupViewPaper(ViewPager viewPager) {
        ViewPaperMatchAdapter adapter = new ViewPaperMatchAdapter(getActivity().getSupportFragmentManager());
//        args.putSerializable(ARGS_FIXTURE, matchItem);
        HashMap<String, ArrayList<FixtureItem>> hashMapFilter = new HashMap<>();
        ArrayList<FixtureItem> listMatch = matchItem.getFixtures();

        for (int i = 0; i < listMatch.size(); i++) {
            FixtureItem item = listMatch.get(i);
            String date = item.getDate().split(" ")[0];
            if (hashMapFilter.containsKey(date)) {
                hashMapFilter.get(date).add(item);
            } else {
                ArrayList<FixtureItem> listItem = new ArrayList<>();
                listItem.add(item);
                hashMapFilter.put(date, listItem);
            }
        }

        Map<String, ArrayList<FixtureItem>> map = new TreeMap<>(hashMapFilter);

        for (Map.Entry<String, ArrayList<FixtureItem>> itemHashMap : map.entrySet()) {
            String strdate = itemHashMap.getKey();
            ArrayList<FixtureItem> list = itemHashMap.getValue();

            ScheduleItem scheduleItem = new ScheduleItem();
            Bundle args = new Bundle();
            args.putParcelableArrayList(ARGS_FIXTURE, list);
            scheduleItem.setArguments(args);
            Date date = Calendar.getInstance().getTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = format.parse(strdate);
                format = new SimpleDateFormat("MMM dd");
                strdate = format.format(date);
            } catch (Exception ex) {
                strdate = format.format(date);
                ex.printStackTrace();
            }
            adapter.addFragment(scheduleItem, strdate);
        }
        viewPager.setAdapter(adapter);
    }

    class ViewPaperMatchAdapter extends FragmentPagerAdapter {

        private final ArrayList<Fragment> mFragmentList = new ArrayList<>();
        private final ArrayList<String> mFragmentTitleList = new ArrayList<>();

        public ViewPaperMatchAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String string) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(string);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
