package com.example.ilazar.mykeep;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.ilazar.mykeep.content.Note;
import com.example.ilazar.mykeep.util.OnErrorListener;
import com.example.ilazar.mykeep.util.OnSuccessListener;

import java.util.List;

/**
 * Created by Adrian on 11/5/2016.
 */

public class AddNoteActivity extends AppCompatActivity {

    public static final String TAG = AddNoteActivity.class.getSimpleName();

    private KeepApp mApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApp = (KeepApp) getApplication();
        setContentView(R.layout.add_note_activity);

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        FloatingActionButton addBtn = (FloatingActionButton) findViewById(R.id.add_btn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            EditText textNote = (EditText) findViewById(R.id.text_content);
            @Override
            public void onClick(View view) {
                final View finalView = view;
                mApp.getNoteManager().addNote(textNote.getText().toString(), new OnSuccessListener<Note>() {
                    @Override
                    public void onSuccess(Note note) {
                        Log.d(TAG, "Note was added succesfull");
                        Snackbar.make(finalView, "Note was added :" + note.getText(), Snackbar.LENGTH_SHORT)
                                .setAction("Action", null).show();
                    }
                }, new OnErrorListener() {
                    @Override
                    public void onError(Exception e) {
                        Log.d(TAG, "Cold not add note");
                    }
                });
            }
        });

        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
