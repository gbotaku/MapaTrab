package com.example.feto.mapatrab;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by feto on 01/02/2017.
 */

public class Customlistadapter extends ArrayAdapter {
    String[] animal_names;
    Integer[] image_id;
    Context context;

    public Customlistadapter(Activity context,Integer[] image_id, String[] text){
        super(context, R.layout.list_row, text);

        this.animal_names = text;
        this.image_id = image_id;
        this.context = context;
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View single_row = inflater.inflate(R.layout.list_row, null,
                true);
        TextView textView = (TextView) single_row.findViewById(R.id.textView);
        ImageView imageView = (ImageView) single_row.findViewById(R.id.imageView);
        if(animal_names[position].equals(null) && image_id[position] == null){

        }else {
            textView.setText(animal_names[position]);
            imageView.setImageResource(image_id[position]);
            return single_row;
        }
        return null;
    }
}
