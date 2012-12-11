package de.doubleslash.coffee.service;

import de.doubleslash.coffee.domain.*;
import de.doubleslash.coffee.exception.BecherAlleException;
import de.doubleslash.coffee.exception.KeinBecherInDieserGroesseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 */
@Service
public class KaffeeMacher {

    @Autowired
    private BecherService becherService;

    public Kaffee tassKaff(Bestellung bestellung) {
        Becher becher;
        try {
            becher = becherService.frischenBecher(bestellung.getKaffeeGroesse());
        } catch (BecherAlleException | KeinBecherInDieserGroesseException e) {
            return new NullKaffee(e.getMessage());
        }

        becherService.printBecherPool();

        return new TollerKaffee(becher.getKaffeeGroesse());
    }

    public List<Kaffee> mehrereTassKaff(List<Bestellung> bestellungen) {
        ArrayList<Kaffee> kaffees = new ArrayList<>();
        for (Bestellung bestellung : bestellungen) {
            kaffees.add(tassKaff(bestellung));
        }

        return kaffees;
    }

    public void setBecherService(BecherService becherService) {
        this.becherService = becherService;
    }
}
