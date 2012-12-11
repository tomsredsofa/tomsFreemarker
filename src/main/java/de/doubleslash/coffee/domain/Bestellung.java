package de.doubleslash.coffee.domain;

/**
 * Created with IntelliJ IDEA.
 */
public class Bestellung {

    private KaffeeGroesse kaffeeGroesse;

    public Bestellung(KaffeeGroesse kaffeeGroesse) {
        this.kaffeeGroesse = kaffeeGroesse;
    }

    public KaffeeGroesse getKaffeeGroesse() {
        return kaffeeGroesse;
    }

    public void setKaffeeGroesse(KaffeeGroesse kaffeeGroesse) {
        this.kaffeeGroesse = kaffeeGroesse;
    }
}
