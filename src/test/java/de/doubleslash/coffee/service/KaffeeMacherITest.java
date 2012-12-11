package de.doubleslash.coffee.service;

import de.doubleslash.coffee.domain.Bestellung;
import de.doubleslash.coffee.domain.Kaffee;
import de.doubleslash.coffee.domain.KaffeeGroesse;
import de.doubleslash.coffee.domain.NullKaffee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 */
public class KaffeeMacherITest {

    @Test
    public void testTassKaff() {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"test-spring-context.xml"});
        KaffeeMacher kaffeeMacher = context.getBean(KaffeeMacher.class);

        Bestellung meineBestellung = new Bestellung(KaffeeGroesse.BECHER);

        Kaffee kaffee = kaffeeMacher.tassKaff(meineBestellung);

        assertTrue("Kaffee sollte ein NullKaffee sein.", kaffee instanceof NullKaffee);
        System.out.println("Der Kaffee ist : " + kaffee);
    }
}
