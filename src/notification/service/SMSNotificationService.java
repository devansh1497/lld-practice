package notification.service;

import notification.model.Message;
import notification.model.User;

public class SMSNotificationService implements NotificationService {
    @Override
    public void send(Message message, User user) {
        System.out.println("Send SMS with: "+message.toString() + " to "+ user.getPhoneNumber());
    }
}
