package wc.dev.khoand.worldcup.Fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import wc.dev.khoand.worldcup.APIClient.APIUtils;
import wc.dev.khoand.worldcup.Adapter.AdapterCountryRCV;
import wc.dev.khoand.worldcup.MainItem.CountryItem;
import wc.dev.khoand.worldcup.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Country extends BaseFragment {

    private CountryItem countryItem;
    public static final String ARGS_FIXTURE = "country";

    private RecyclerView recyclerView;

    public Country() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_country, container, false);
        recyclerView = rootView.findViewById(R.id.country_rcv);
        loadApiCountryInformation();

        return rootView;
    }

    private void loadApiCountryInformation() {
        apiService = APIUtils.getMyService();
        apiService.getCountry().enqueue(new Callback<CountryItem>() {
            @Override
            public void onResponse(Call<CountryItem> call, Response<CountryItem> response) {
                if (response.isSuccessful()) {
                    countryItem = response.body();
                    AdapterCountryRCV adapter = new AdapterCountryRCV(countryItem.getTeams());
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<CountryItem> call, Throwable t) {

            }
        });
    }
}
