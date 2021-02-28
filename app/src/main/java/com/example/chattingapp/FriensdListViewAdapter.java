package com.example.chattingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class FriensdListViewAdapter extends ArrayAdapter<FriendsListView> {

    private Context context;
    private int resource;

    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        private int positon;
        private Context context;

        public MyMenuItemClickListener( Context context, int positon) {
            this.positon = positon;
            this.context = context;
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {

                case R.id.list_popup_pofile:
                    Toast.makeText(context, "Profile " + positon, Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.list_popup_call:
                    Toast.makeText(context, "Call " + positon, Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.list_popup_messsag:
                    Toast.makeText(context, "Message "+ positon, Toast.LENGTH_SHORT).show();
                default:
                    return false;
            }
        }
    }

    public FriensdListViewAdapter(Context context, int resource, ArrayList<FriendsListView> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(resource, parent, false);

        TextView textView = (TextView) convertView.findViewById(R.id.list_view_name);
        textView.setText(getItem(position).getName().toString());

        CircleImageView circleImageView = (CircleImageView) convertView.findViewById(R.id.list_view_image_view);
        circleImageView.setImageResource(getItem(position).getImage());

        ImageButton imageButton= (ImageButton) convertView.findViewById(R.id.imageButton);
        final Context fcontext = convertView.getContext();
        final int fposition = position;
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(view.getContext(),view );
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.list_view_popup_menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new MyMenuItemClickListener(fcontext, fposition));
                popup.show();
            }
        });

        return convertView;
    }

}
