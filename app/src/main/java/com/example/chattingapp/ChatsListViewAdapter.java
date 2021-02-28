package com.example.chattingapp;

import android.content.Context;
import android.content.Intent;
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


public class ChatsListViewAdapter extends ArrayAdapter<ChatsListView> {

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

    public ChatsListViewAdapter(Context context, int resource, ArrayList<ChatsListView> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(resource, parent, false);

        TextView name = (TextView) convertView.findViewById(R.id.chats_view_name);
        TextView message = (TextView) convertView.findViewById(R.id.chats_view_msg);
        TextView time = (TextView) convertView.findViewById(R.id.chats_view_msg_time);
        CircleImageView circleImageView = (CircleImageView) convertView.findViewById(R.id.chats_view_image_view);
        name.setText(getItem(position).getName().toString());
        message.setText(getItem(position).getMessage().toString());
        time.setText(getItem(position).getTime().toString());
        circleImageView.setImageResource(getItem(position).getImage());

        ImageButton imageButton= (ImageButton) convertView.findViewById(R.id.chats_image_button);
        final Context fcontext = convertView.getContext();
        final int fposition = position;
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(view.getContext(), view);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.list_view_popup_menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new MyMenuItemClickListener(fcontext, fposition));
                popup.show();
            }
        });

        return convertView;
    }

}
