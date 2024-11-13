package com.example.test;

import androidx.room.*;
import android.content.Context;
import java.util.ArrayList;

public class DB {

    @Entity
    public class Message {
        @PrimaryKey(autoGenerate = true)
        public int id;

        @ColumnInfo(name="contents")
        public String title;

        @ColumnInfo(name="color")
        public String color;
    }

    @Dao
    public interface MessageDao {
        @Query("SELECT * FROM Message")
        ArrayList<Message> getAll();

        @Insert
        public void insertMessage(Message message);

        @Query("DELETE FROM Message")
        void deleteAll();
    }

    @Database(entities = {Message.class}, version = 1)
    public abstract class AppDatabase extends RoomDatabase {

        private AppDatabase instance;

        public abstract MessageDao messageDao();

        public synchronized AppDatabase getInstance(Context context) {
            if (instance == null) {
                instance = Room.databaseBuilder(context.getApplicationContext(),
                                AppDatabase.class, "app_database")
                        .fallbackToDestructiveMigration()  // 스키마 변경 시 데이터 삭제
                        .build();
            }
            return instance;
        }
    }
}
