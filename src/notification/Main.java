package notification;

import notification.model.Message;
import notification.model.User;
import notification.service.EmailNotificationService;
import notification.service.SMSNotificationService;

public class Main {

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.addTopic("email");
        notificationManager.addTopic("sms");
        notificationManager.subsribe("email", new EmailNotificationService());
        notificationManager.subsribe("sms", new SMSNotificationService());
        User u1 = new User("devansh", "7073840161", "devanshsingh1997@gmail.com");
        Message message = new Message("Order palced", "thanks for placing your order # 1232");
        notificationManager.sendMessage("email",  message, u1);
        notificationManager.sendMessage("sms", message, u1);
    }
}
