package notification.model;

import java.time.LocalDateTime;

public class Message {

    private String title;
    private String body;
    private LocalDateTime timeStamp;

    public Message(String title, String body) {
        this.title = title;
        this.body = body;
        this.timeStamp = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    @Override
    public String toString() {
        return "Message{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
