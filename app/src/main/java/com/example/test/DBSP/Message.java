package com.example.test.DBSP;

import androidx.room.*;

@Entity(tableName = "message_table")
public class Message {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name="contents")
    public String contents;

    @ColumnInfo(name="color")
    public String color;


    public Message(String contents, String color){
        this.contents = contents;
        this.color = color.toLowerCase();
    }

    public String getColor() {
        return color;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
