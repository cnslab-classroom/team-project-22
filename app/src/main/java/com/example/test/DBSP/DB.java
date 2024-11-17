package com.example.test.DBSP;

import android.content.Context;
import androidx.room.*;
import java.util.*;


@Database(entities = {Message.class}, version = 2)
public abstract class DB extends RoomDatabase {
    private static DB db;
    private static String DATABASE_NAME = "MessageDB";

    public abstract MessageDao messageDao();

    public synchronized static void makeDB(Context context) {
        if (db == null) {
            db = Room.databaseBuilder(context.getApplicationContext(), DB.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
    }

    public synchronized static void insertMessage(Message message) {
        MessageDao dbAccess = db.messageDao();
        dbAccess.insert(message);
    }

    public synchronized static Queue<Message> getAllMessage() {
        MessageDao dbAccess = db.messageDao();

        List<Message> list = dbAccess.getAll();
        new Thread(dbAccess::deleteAll).start();

        return new LinkedList<>(list);
    }

    public synchronized static void deleteAllMessage() {
        MessageDao dbAccess = db.messageDao();
        new Thread(dbAccess::deleteAll).start();
    }
}





