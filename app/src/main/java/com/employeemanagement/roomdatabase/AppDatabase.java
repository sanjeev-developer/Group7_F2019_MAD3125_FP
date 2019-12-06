package com.employeemanagement.roomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract UserDao userModel();

    public static AppDatabase getInMemoryDatabase(Context context) {
        if (null == INSTANCE) {
            INSTANCE = Room.databaseBuilder(context,
                    AppDatabase.class, "MyTestDB").build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
