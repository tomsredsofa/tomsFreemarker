package de.doubleslash.coffee.domain;

/**
 * Created with IntelliJ IDEA.
 */
public class Becher {

    private KaffeeGroesse kaffeeGroesse;

    public Becher(KaffeeGroesse kaffeeGroesse) {
        this.kaffeeGroesse = kaffeeGroesse;
    }

    public KaffeeGroesse getKaffeeGroesse() {
        return kaffeeGroesse;
    }

    public void setKaffeeGroesse(KaffeeGroesse kaffeeGroesse) {
        this.kaffeeGroesse = kaffeeGroesse;
    }
}
