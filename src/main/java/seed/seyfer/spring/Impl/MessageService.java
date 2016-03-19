package seed.seyfer.spring.Impl;

import org.springframework.stereotype.Component;
import seed.seyfer.spring.IMessageService;

/**
 * Created by seyfer on 3/14/16.
 */
@Component
public class MessageService implements IMessageService {

    public String getMessage() {
        return "Hello Spring!";
    }
}
