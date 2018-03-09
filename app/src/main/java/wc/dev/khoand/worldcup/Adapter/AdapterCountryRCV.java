package wc.dev.khoand.worldcup.Adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URL;
import java.util.ArrayList;

import wc.dev.khoand.worldcup.Items.CountryTeam;
import wc.dev.khoand.worldcup.MainItem.CountryItem;
import wc.dev.khoand.worldcup.R;

/**
 * Created by khoam on 3/9/2018.
 */

public class AdapterCountryRCV extends RecyclerView.Adapter<AdapterCountryRCV.MyViewHolder> {
    private ArrayList<CountryTeam> listCountry;

    public AdapterCountryRCV(ArrayList<CountryTeam> listCountry) {
        this.listCountry = listCountry;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView img_icon;
        public TextView tv_country_name;

        public MyViewHolder(View v) {
            super(v);
            img_icon = v.findViewById(R.id.country_rcv_img);
            tv_country_name = v.findViewById(R.id.country_rcv_tv);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_cv_row_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final CountryTeam item = listCountry.get(position);
        try {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        URL url = new URL(item.getCrestUrl());
                        Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                        holder.img_icon.setImageBitmap(bmp);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            thread.start();

            holder.tv_country_name.setText(item.getName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return listCountry.size();
    }
}
