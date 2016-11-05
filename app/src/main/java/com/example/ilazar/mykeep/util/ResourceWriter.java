package com.example.ilazar.mykeep.util;

import android.util.JsonWriter;

import java.io.IOException;

public interface ResourceWriter<E> {
    void write(E e, JsonWriter writer) throws IOException;
}
