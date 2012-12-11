package de.doubleslash.coffee.domain;

import de.doubleslash.coffee.exception.KeinBecherInDieserGroesseException;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 */
public interface BecherPool {
    Becher leiheBecher(KaffeeGroesse kaffeeGroesse) throws KeinBecherInDieserGroesseException;
    Map<KaffeeGroesse, Integer> getInventory();
    Map<String, String> getSimpleSortedInventory();
}
