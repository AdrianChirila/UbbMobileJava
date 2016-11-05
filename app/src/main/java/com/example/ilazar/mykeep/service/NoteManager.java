package com.example.ilazar.mykeep.service;

import android.content.Context;
import android.util.Log;

import com.example.ilazar.mykeep.content.Note;
import com.example.ilazar.mykeep.net.NoteRestClient;
import com.example.ilazar.mykeep.util.OkCancellableCall;
import com.example.ilazar.mykeep.util.OnErrorListener;
import com.example.ilazar.mykeep.util.OnSuccessListener;

import java.util.List;

public class NoteManager {
    private static final String TAG = NoteManager.class.getSimpleName();

    private List<Note> mNotes;
    private OnNoteUpdateListener mOnUpdate;

    private final Context mContext;
    private NoteRestClient mNoteRestClient;

    public NoteManager(Context context) {
        mContext = context;
    }

    public List<Note> getNotes() throws Exception { //sync method
        Log.d(TAG, "getNotes...");
        mNotes = mNoteRestClient.getAll();
        return mNotes;
    }

    public NoteLoader getNoteLoader() {
        Log.d(TAG, "getNoteLoader...");
        return new NoteLoader(mContext, mNoteRestClient);
    }

    public void addNote(String text, OnSuccessListener<Note> onSuccessListener, OnErrorListener onErrorListener) {
        mNoteRestClient.addNoteAsync(text, onSuccessListener, onErrorListener);
    }

    public void setOnUpdate(OnNoteUpdateListener onUpdate) {
        mOnUpdate = onUpdate;
    }

    public void setNoteRestClient(NoteRestClient noteRestClient) {
        mNoteRestClient = noteRestClient;
    }

    public OkCancellableCall getNotesAsync(OnSuccessListener<List<Note>> onSuccessListener, OnErrorListener onErrorListener) {
        return mNoteRestClient.getAllAsync(onSuccessListener, onErrorListener);
    }

    public interface OnNoteUpdateListener {
        void updated();
    }
}
