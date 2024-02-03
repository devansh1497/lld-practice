package notification.service;

import notification.model.Message;
import notification.model.User;

public class EmailNotificationService implements NotificationService {
    @Override
    public void send(Message message, User user) {
        System.out.println("Send email with: "+message.toString() +" to "+user.getEmail());
    }
}
