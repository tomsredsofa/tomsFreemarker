package de.doubleslash.coffee.domain;

import de.doubleslash.coffee.exception.KeinBecherInDieserGroesseException;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 */
public class BecherPoolAlwaysThrows implements BecherPool {
    @Override
    public Becher leiheBecher(KaffeeGroesse kaffeeGroesse) throws KeinBecherInDieserGroesseException {
        throw new KeinBecherInDieserGroesseException();
    }

    @Override
    public Map<KaffeeGroesse, Integer> getInventory() {
        return null;
    }

    @Override
    public Map<String, String> getSimpleSortedInventory() {
        return null;
    }
}
