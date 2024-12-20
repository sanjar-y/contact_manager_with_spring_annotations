package conact_manager;

import conact_manager.controller.ContactController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        ContactController controller = (ContactController) context.getBean("contactController");
        controller.start();
    }
}