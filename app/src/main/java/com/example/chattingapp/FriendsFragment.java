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

import de.hdodenhof.circleimageview.CircleImageView;

public class FriendsFragment extends Fragment {

    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.friends_tab_fragment, container, false);
        listView = (ListView) view.findViewById(R.id.friends_list);
        ArrayList<FriendsListView> items = new ArrayList<>();
        items.add(new FriendsListView("Nasrin", R.drawable.contact_1));
        items.add(new FriendsListView("Amal", R.drawable.contact_2));
        items.add(new FriendsListView("Ousama", R.drawable.contact_3));
        items.add(new FriendsListView("Thę Čongrėše", R.drawable.contact_5));
        items.add(new FriendsListView("Abdelkarim", R.drawable.contact_5));
        items.add(new FriendsListView("Omar", R.drawable.contact_3));
        items.add(new FriendsListView("Maryam", R.drawable.contact_2));
        items.add(new FriendsListView("Chahinaz", R.drawable.contact_1));
        items.add(new FriendsListView("Amin", R.drawable.contact_5));
        FriensdListViewAdapter adapter = new FriensdListViewAdapter(getActivity(), R.layout.friends_tab_list_view, items);
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
