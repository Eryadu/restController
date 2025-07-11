package io.pragra.designpattern.decoratorDesign;

import org.springframework.stereotype.Service;

@Service
public class EmailNotification implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Sending email to " + message);
    }
}
