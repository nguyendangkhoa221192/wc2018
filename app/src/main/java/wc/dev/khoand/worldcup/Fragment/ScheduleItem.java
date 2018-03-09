package wc.dev.khoand.worldcup.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import wc.dev.khoand.worldcup.Adapter.AdapterMatchRCV;
import wc.dev.khoand.worldcup.Items.FixtureItem;
import wc.dev.khoand.worldcup.MainItem.MatchItem;
import wc.dev.khoand.worldcup.MainItem.TeamItem;
import wc.dev.khoand.worldcup.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleItem extends Fragment {

    private ArrayList<FixtureItem> fixtureItems;

    private RecyclerView recyclerView;
    private AdapterMatchRCV matchRCV;

    public ScheduleItem() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_schedule_item, container, false);

        fixtureItems = getArguments().getParcelableArrayList(MatchSchedule.ARGS_FIXTURE);

        recyclerView = root.findViewById(R.id.match_recycler_view);
        matchRCV = new AdapterMatchRCV(fixtureItems);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(matchRCV);

        return root;
    }

}
