package com.itil.vm;

/**
 * Created by Aniket on 7/2/2018.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class UserList extends ArrayAdapter<ServiceRequest> {
   private List<ServiceRequest> usersL;
    private Activity context;

    public UserList(Activity context, List<ServiceRequest> usersL) {
        super(context, R.layout.service_name, usersL);
        this.context = context;
        this.usersL = usersL;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.service_name, null);

        TextView textViewName = listViewItem.findViewById(R.id.textView2);

        ServiceRequest loc = usersL.get(position);

        textViewName.setText(loc.getsName());

        return listViewItem;
    }
}