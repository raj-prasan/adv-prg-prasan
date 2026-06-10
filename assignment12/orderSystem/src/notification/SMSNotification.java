package notification;

public class SMSNotification implements NotificationService {
    public void send(String message) {
        System.out.println("SMS sent: " + message);
    }
}
