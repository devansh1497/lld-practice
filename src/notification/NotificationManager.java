package notification;

import notification.model.Message;
import notification.model.Topic;
import notification.model.User;
import notification.service.EmailNotificationService;
import notification.service.NotificationService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NotificationManager {

    private List<Topic> topics = new ArrayList<>();

    public void addTopic(String name) {
        topics.add(new Topic(name));
    }

    public void subsribe(String name, NotificationService subsriber) {
        Topic t = topics.stream().filter(topic -> topic.getName().equals(name)).collect(Collectors.toList()).get(0);
        t.subsribe(subsriber);
    }

    public void sendMessage(String topicName, Message message, User user) {
        Topic t = topics.stream().filter(topic -> topic.getName().equals(topicName)).collect(Collectors.toList()).get(0);
        for (NotificationService subscriber : t.getSubscribers()) {
            subscriber.send(message, user);
        }
    }
}
