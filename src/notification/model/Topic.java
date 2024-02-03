package notification.model;

import notification.service.EmailNotificationService;
import notification.service.NotificationService;

import java.util.ArrayList;
import java.util.List;

public class Topic {

    private String name;
    private List<NotificationService> subscribers;

    public Topic(String name) {
        this.name = name;
        this.subscribers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<NotificationService> getSubscribers() {
        return subscribers;
    }

    public void subsribe(NotificationService subsriber) {
        subscribers.add(subsriber);
    }
}
