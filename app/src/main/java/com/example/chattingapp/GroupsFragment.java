package com.example.chattingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class GroupsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.groups_tab_fragment, container, false);
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
