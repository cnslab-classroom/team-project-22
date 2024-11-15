package com.example.test.DBSP;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface MessageDao {
    @Query("SELECT * FROM message_table")
    List<Message> getAll();

    @Insert
    void insert(Message message);

    @Query("DELETE FROM message_table")
    void deleteAll();
}
