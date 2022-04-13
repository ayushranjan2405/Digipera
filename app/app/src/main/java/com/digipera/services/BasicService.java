package com.digipera.services;

import android.content.Context;

public abstract class BasicService {
    protected final Context context;

    public BasicService(Context context){
        this.context = context;
    }

    public abstract void initialLoad();
}
