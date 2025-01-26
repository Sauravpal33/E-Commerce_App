package com.example.ecommerce_app.Database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;

@Database(entities = {Product_Table.class,Cart_Table.class},exportSchema = false,version = 4)
public abstract class RoomDatabase extends androidx.room.RoomDatabase {
    private static final String db = "Favourite_db";
    private static RoomDatabase instance;

    public static synchronized RoomDatabase getDB(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context, RoomDatabase.class,db)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract DAO dao();
    public abstract Cart_Dao cartDao();
}
