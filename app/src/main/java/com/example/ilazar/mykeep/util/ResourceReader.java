package com.example.ilazar.mykeep.util;

import android.util.JsonReader;

import java.io.IOException;

public interface ResourceReader<E> {
    E read(JsonReader reader) throws IOException;
}
