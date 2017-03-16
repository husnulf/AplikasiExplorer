package com.husnulfikrah.blogspot.aplikasibaru.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.husnulfikrah.blogspot.aplikasibaru.DetAct;
import com.husnulfikrah.blogspot.aplikasibaru.MainActivity;
import com.husnulfikrah.blogspot.aplikasibaru.R;

import java.util.ArrayList;
import java.util.HashMap;

import static com.husnulfikrah.blogspot.aplikasibaru.R.id.lvhape;


public class AdapterList extends RecyclerView.Adapter<AdapterList.ViewHolder> {

    Context context;
    ArrayList<HashMap<String, String>> list_data;


    public AdapterList(MainActivity mainActivity, ArrayList<HashMap<String, String>> list_data) {
        this.context = mainActivity;
        this.list_data = list_data;//nilai
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final HashMap<String,String>listitem = list_data.get(position);
        Glide.with(context)
                .load("http://31.220.55.37/muhammadhusnul/uploads/" + list_data.get(position).get("gambar"))
                .crossFade()
                .into(holder.imghape);
        holder.txthape.setText(list_data.get(position).get("tipe"));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent a = new Intent(v.getContext(),DetAct.class);
                a.putExtra("id_hp",listitem.get("id_hp"));
                a.putExtra("merk",listitem.get("merk"));
                a.putExtra("tipe",listitem.get("tipe"));
                a.putExtra("keterangan",listitem.get("keterangan"));
                a.putExtra("gambar",listitem.get("gambar"));
                v.getContext().startActivity(a);
            }
        });



    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txthape;
        ImageView imghape;
        CardView cardView;



        public ViewHolder(View itemView) {
            super(itemView);

            txthape = (TextView) itemView.findViewById(R.id.txthape);
            imghape = (ImageView) itemView.findViewById(R.id.imghp);
            cardView= (CardView) itemView.findViewById(R.id.cardview);

        }
    }
}


