package seed.seyfer.example.application;

import org.springframework.stereotype.Component;

/**
 * Created by seyfer on 3/14/16.
 */
@Component
public class MessageService implements IMessageService {

    public String getMessage() {
        return "Hello Spring!";
    }
}
