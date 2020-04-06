package com.example.lab6_slominski_april1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflator;
    private ArrayList<Person> mDataSource;

    public PersonAdapter(Context mContext, ArrayList<Person> mDataSource){
        this.mContext = mContext;
        this.mDataSource = mDataSource;
        mInflator = (LayoutInflater) mContext.getSystemService((Context.LAYOUT_INFLATER_SERVICE));
    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = mInflator.inflate(R.layout.activity_person, parent, false);

        EditText etInputName = rowView.findViewById(R.id.etInputName);

        Person person = (Person) getItem(position);
        etInputName.setText(person.getName());

        return rowView;
    }
}
