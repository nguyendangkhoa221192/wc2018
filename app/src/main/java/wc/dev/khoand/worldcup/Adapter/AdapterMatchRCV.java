package wc.dev.khoand.worldcup.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import wc.dev.khoand.worldcup.Items.FixtureItem;
import wc.dev.khoand.worldcup.MainItem.MatchItem;
import wc.dev.khoand.worldcup.R;
import wc.dev.khoand.worldcup.Utils.Constants;

/**
 * Created by khoam on 3/1/2018.
 */

public class AdapterMatchRCV extends RecyclerView.Adapter<AdapterMatchRCV.MyViewHolder>{
    private ArrayList<FixtureItem> listMatch;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView name1st, name2nd, goal1st, goal2nd, styleMatch, timeMatch;
        public ImageView icon1st, icon2nd;

        public MyViewHolder(View view) {
            super(view);
            name1st = view.findViewById(R.id.match_rcv_item_name1st);
            name2nd = view.findViewById(R.id.match_rcv_item_name2nd);
            goal1st = view.findViewById(R.id.match_rcv_item_goal1st);
            goal2nd = view.findViewById(R.id.match_rcv_item_goal2nd);
            styleMatch = view.findViewById(R.id.match_rcv_item_type_match);
            timeMatch = view.findViewById(R.id.match_rcv_item_time_location);
            icon1st = view.findViewById(R.id.match_rcv_item_img1st);
            icon2nd = view.findViewById(R.id.match_rcv_item_img2nd);
        }
    }

    public AdapterMatchRCV(ArrayList<FixtureItem> listMatch) {
        this.listMatch = listMatch;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.match_rcv_row_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FixtureItem item = listMatch.get(position);
        holder.name1st.setText(item.getHomeTeamName());
        holder.name2nd.setText(item.getAwayTeamName());
        if (item.getResult().getGoalsHomeTeam() != null && item.getResult().getGoalsAwayTeam() != null) {
            holder.goal1st.setText(String.valueOf(item.getResult().getGoalsHomeTeam()));
            holder.goal2nd.setText(String.valueOf(item.getResult().getGoalsAwayTeam()));
            holder.goal1st.setVisibility(View.VISIBLE);
            holder.goal2nd.setVisibility(View.VISIBLE);
        }
        holder.styleMatch.setText(item.getStatus());
        holder.timeMatch.setText(item.getDate());
        holder.icon1st.setImageResource(R.drawable.img1);
        holder.icon2nd.setImageResource(R.drawable.img2);
    }

    @Override
    public int getItemCount() {
        return listMatch.size();
    }
}
