package de.doubleslash.coffee.service;

import de.doubleslash.coffee.domain.Becher;
import de.doubleslash.coffee.domain.BecherPool;
import de.doubleslash.coffee.domain.BecherPoolImpl;
import de.doubleslash.coffee.domain.KaffeeGroesse;
import de.doubleslash.coffee.exception.BecherAlleException;
import de.doubleslash.coffee.exception.KeinBecherInDieserGroesseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 */
@Service
public class BecherService {

    @Autowired
    private BecherPool becherPool;

    public Becher frischenBecher(KaffeeGroesse kaffeeGroesse) throws BecherAlleException,
            KeinBecherInDieserGroesseException {
        return becherPool.leiheBecher(kaffeeGroesse);
    }

    public void printBecherPool() {
        System.out.println(becherPool.toString());
    }

    public void setBecherPool(BecherPoolImpl becherPool) {
        this.becherPool = becherPool;
    }

    public BecherPool getBecherPool() {
        return becherPool;
    }
}
