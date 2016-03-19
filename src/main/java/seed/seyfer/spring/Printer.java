package seed.seyfer.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by seyfer on 3/14/16.
 */
@Component
public class Printer {

    @Autowired
    IMessageService messageService;

    public void printMessage() {
        System.out.println(messageService.getMessage());
    }

}
