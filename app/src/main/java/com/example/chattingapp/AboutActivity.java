package com.example.chattingapp;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    private TextView textSelect, textSelect2, textSelect3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        textSelect = (TextView) findViewById(R.id.about_text_select);
        textSelect2 = (TextView) findViewById(R.id.about_text_select_v2);
        textSelect3 = (TextView) findViewById(R.id.about_text_select_v3);

        textSelect.setTextIsSelectable(true);
        textSelect2.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.context_menu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.cm_option_1:
                        Toast.makeText(getApplicationContext(), "Option 1 Selected...", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.cm_option_2:
                        Toast.makeText(getApplicationContext(), "Option 2 Selected...", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.cm_option_3:
                        Toast.makeText(getApplicationContext(), "Option 3 Selected...", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return true;
                }
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });
        registerForContextMenu(textSelect3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.about_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ab_message:
                Toast.makeText(this, "Hallo ...", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.floating_context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.fcm_option_1:
                Toast.makeText(getApplicationContext(), "Floating option 1", Toast.LENGTH_SHORT) .show();
                return true;
            case R.id.fcm_option_2:
                Toast.makeText(getApplicationContext(), "Floating option 2", Toast.LENGTH_SHORT) .show();
                return true;
            case R.id.fcm_option_3:
                Toast.makeText(getApplicationContext(), "Floating option 3", Toast.LENGTH_SHORT) .show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
