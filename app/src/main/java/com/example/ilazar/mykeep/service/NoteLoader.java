package com.example.ilazar.mykeep.service;

import android.content.Context;
import android.util.Log;

import com.example.ilazar.mykeep.content.Note;
import com.example.ilazar.mykeep.net.NoteRestClient;
import com.example.ilazar.mykeep.util.OkAsyncTaskLoader;

import java.util.List;

public class NoteLoader extends OkAsyncTaskLoader<List<Note>> {
    private static final String TAG = NoteLoader.class.getSimpleName();
    private final NoteRestClient mNoteRestClient;
    private List<Note> notes;

    public NoteLoader(Context context, NoteRestClient noteRestClient) {
        super(context);
        mNoteRestClient = noteRestClient;
    }

    @Override
    public List<Note> tryLoadInBackground() throws Exception {
        Log.d(TAG, "tryLoadInBackground");
        notes = mNoteRestClient.getAll();
        return notes;
    }

    @Override
    protected void onStartLoading() {
        if (notes != null) {
            Log.d(TAG, "onStartLoading - deliver result");
            deliverResult(notes);
        }

        if (takeContentChanged() || notes == null) {
            Log.d(TAG, "onStartLoading - force load");
            forceLoad();
        }
    }
}
