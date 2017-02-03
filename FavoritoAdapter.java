package com.example.feto.mapatrab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by feto on 26/01/2017.
 */

public class FavoritoAdapter extends BaseAdapter{
    private Context context;
    private List<Animal> listanimais;

    public FavoritoAdapter(Context context, List<Animal> listanimais){
        this.context = context;
        this.listanimais = listanimais;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.activity_favoritos, null);


        return layout;
    }
   
}
