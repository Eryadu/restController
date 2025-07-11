package io.pragra.designpattern.decoratorDesign;

import org.springframework.stereotype.Component;

@Component
public interface NotificationService {
    void send (String message);
}
