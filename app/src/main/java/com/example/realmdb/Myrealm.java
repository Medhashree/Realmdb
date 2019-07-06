package com.example.realmdb;

import android.app.Application;

import io.realm.Realm;


public class Myrealm extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // The default Realm file is "default.realm" in Context.getFilesDir();
        // we'll change it to "myrealm.realm"
        Realm.init(this);
    }
}