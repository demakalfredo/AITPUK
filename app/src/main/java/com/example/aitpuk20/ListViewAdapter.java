package com.example.aitpuk20;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {
    //deklarasi variabel
    Context mContext;
    LayoutInflater inflater;
    private List<ClassNames> classNamesList = null;
    private ArrayList<ClassNames> arraylist;

    public ListViewAdapter(Context context,
                           List<ClassNames> classNamesList){
        mContext = context;
        this.classNamesList = classNamesList;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<ClassNames>();
        this.arraylist.addAll(classNamesList);

    }

    public class ViewHolder {
        TextView gol;
        TextView names;
        ImageView images;
    }

    @Override
    public int getCount(){
        return classNamesList.size();
    }

    @Override
    public ClassNames getItem(int position){
        return classNamesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public View getView(final int position, View view, ViewGroup parent) {

        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.layout_list_unsur, null);
            // Locate the TextViews in listview_item.xml
            holder.gol = (TextView) view.findViewById(R.id.textView_golongan);
            holder.names = (TextView) view.findViewById(R.id.textView_name);
            // Locate the ImageView in listview_item.xml
            holder.images= (ImageView) view.findViewById(R.id.imageView);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.gol.setText(classNamesList.get(position).getGol());
        holder.names.setText(classNamesList.get(position).getNames());
        // Set the results into ImageView
        holder.images.setImageResource(classNamesList.get(position)
                .getImages());
        // Listen for ListView Item Click
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                // Send single item click data to SingleItemView Class
                Intent intent = new Intent(mContext, popup_listunsur.class);
                //memberikan data dari konfelektron
                intent.putExtra("konfelektron",
                        (classNamesList.get(position).getKonfelektron()));
                //memberikan data elektronsel dari array
                intent.putExtra("elektronsel",
                        (classNamesList.get(position).getElektronsel()));
                //memberikan data url dari array
                intent.putExtra("url",
                        (classNamesList.get(position).getUrl()));
                //memberikan data definisi dari array
                intent.putExtra("definisi",
                        (classNamesList.get(position).getDefinisi()));
                //memberikan data nomassa dari array
                intent.putExtra("nomassa",
                        (classNamesList.get(position).getNomassa()));
                // Pass all data rank
                //intent.putExtra("gol",
                //(classNamesList.get(position).getGol()));
                // Pass all data population
                //intent.putExtra("names",
                //      (classNamesList.get(position).getNames()));
                // Pass all data flag
                intent.putExtra("images",
                        (classNamesList.get(position).getImages()));
                // Start SingleItemView Class
                mContext.startActivity(intent);
            }
        });

        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        classNamesList.clear();
        if (charText.length() == 0) {
            classNamesList.addAll(arraylist);
        } else {
            for (ClassNames cn : arraylist) {
                if (cn.getNames().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                    classNamesList.add(cn);
                }
            }
        }
        notifyDataSetChanged();
    }
}
