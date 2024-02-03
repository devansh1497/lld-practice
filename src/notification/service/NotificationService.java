package notification.service;

import notification.model.Message;
import notification.model.User;

public interface NotificationService {

    void send(Message message, User user);
}
