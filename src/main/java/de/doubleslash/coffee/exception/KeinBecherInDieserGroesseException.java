package de.doubleslash.coffee.exception;

/**
 * Created with IntelliJ IDEA.
 */
public class KeinBecherInDieserGroesseException extends Exception {

    public KeinBecherInDieserGroesseException() {
        super("Kein Becher in dieser Größe mehr da!");
    }
}
