//Note.java
package com.example.test;

public class Note {

    private String date;  // 쪽지 날짜
    private String content;  // 쪽지 내용

    // 생성자
    public Note(String date, String content) {
        this.date = date;
        this.content = content;
    }

    // 날짜를 반환하는 메서드
    public String getDate() {
        return date;
    }

    // 내용을 반환하는 메서드
    public String getContent() {
        return content;
    }

    // 날짜와 내용 설정하는 setter 메서드 (선택 사항)
    public void setDate(String date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

