package com.google.ar.core.examples.java.helloar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    // ArrayList to store the data added to the Adapter
    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();

    // Constructor for ListViewAdapter
    public ListViewAdapter() {

    }

    // Returns the number of items used in the Adapter : required implementation
    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    // Returns the View to display the data at the specified position : required implementation
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // Inflate "listview_item" layout to obtain the convertView reference
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }

        // Obtain references to the widgets from the inflated layout
        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageView1);
        TextView titleTextView = (TextView) convertView.findViewById(R.id.textView1);

        // Get a reference to the data at the specified position from the Data Set (listViewItemList)
        ListViewItem listViewItem = listViewItemList.get(position);

        // Apply data to each widget in the item
        iconImageView.setImageDrawable(listViewItem.getIcon());
        titleTextView.setText(listViewItem.getTitle());

        return convertView;
    }

    // Returns the ID of the item (row) associated with the specified position : required implementation
    @Override
    public long getItemId(int position) {
        return position;
    }

    // Returns the data at the specified position : required implementation
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    // Function to add item data; can be customized as needed by the developer
    public void addItem(Drawable icon, String title) {
        ListViewItem item = new ListViewItem();

        item.setIcon(icon);
        item.setTitle(title);

        listViewItemList.add(item);
    }
}