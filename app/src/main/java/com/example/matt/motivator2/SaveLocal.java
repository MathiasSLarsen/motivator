package com.example.matt.motivator2;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Matt on 09-11-2017.
 */

public class SaveLocal {
    private Context context;

    public SaveLocal(Context context) {
        this.context = context;
    }

    protected SharedPreferences open() {
        return context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
    }

    protected SharedPreferences.Editor edit() {
        return open().edit();
    }
}
