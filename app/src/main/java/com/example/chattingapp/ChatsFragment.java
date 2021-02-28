package com.example.chattingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class ChatsFragment extends Fragment {

    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.chats_tab_fragment, container, false);
        listView = (ListView) view.findViewById(R.id.chats_list);
        ArrayList<ChatsListView> items = new ArrayList<>();
        items.add(new ChatsListView("Nasrin", R.drawable.contact_1, "Message 1", "09:45"));
        items.add(new ChatsListView("Amal", R.drawable.contact_2, "Message 2", "04:13"));
        items.add(new ChatsListView("Ousama", R.drawable.contact_3, "Message 3", "16:55"));
        items.add(new ChatsListView("Zobida", R.drawable.contact_4, "Message 4", "10:00"));
        items.add(new ChatsListView("Abdelkarim", R.drawable.contact_5, "Message 5", "11:50"));
        items.add(new ChatsListView("Omar", R.drawable.contact_3, "Message 6", "13:52"));
        items.add(new ChatsListView("Maryam", R.drawable.contact_2, "Message 7", "09:10"));
        items.add(new ChatsListView("Chahinaz", R.drawable.contact_1, "Message 8", "10:29"));
        items.add(new ChatsListView("Amin", R.drawable.contact_5, "Message 9", "05:14"));
        ChatsListViewAdapter adapter = new ChatsListViewAdapter(getActivity(), R.layout.chats_tab_list_view, items);
        listView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.frriends_tab_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.fm_notifications:
                Toast.makeText(getContext(), "Hallo no update...", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.fm_search:
                Toast.makeText(getContext(), "todo", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.fm_goto_about:
                Intent intent = new Intent(getActivity(), AboutActivity.class);
                startActivity(intent);
                return true;
            case  R.id.fm_exit:
                Toast.makeText(getContext(), "Exit App...", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }

}
