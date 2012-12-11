package de.doubleslash.coffee.client;

import de.doubleslash.coffee.domain.Bestellung;
import de.doubleslash.coffee.domain.Kaffee;
import de.doubleslash.coffee.domain.KaffeeGroesse;
import de.doubleslash.coffee.service.KaffeeMacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by IntelliJ IDEA.
 */
public class TestClient {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"test-spring-context.xml"});
        KaffeeMacher kaffeeMacher = context.getBean(KaffeeMacher.class);

        Bestellung meineBestellung = new Bestellung(KaffeeGroesse.BECHER);

        Kaffee kaffee = kaffeeMacher.tassKaff(meineBestellung);

        System.out.println("Der Kaffee ist : " + kaffee);
    }
}
