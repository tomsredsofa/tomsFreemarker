package de.doubleslash.coffee.domain;

/**
 * Created with IntelliJ IDEA.
 */
public class NullKaffee implements Kaffee {

    private String warum;

    public NullKaffee(String warum) {
        this.warum = warum;
    }

    @Override
    public KaffeeGroesse getKaffeeGroesse() {
        return KaffeeGroesse.GARKEIN;
    }

    @Override
    public String toString() {
        return "Kein Kaffee weil " + warum;
    }

    public String getWarum() {
        return warum;
    }
}
