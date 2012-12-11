package de.doubleslash.coffee.domain;

/**
 * Created with IntelliJ IDEA.
 */
public class TollerKaffee implements Kaffee {
    private KaffeeGroesse kaffeeGroesse;

    public TollerKaffee(KaffeeGroesse kaffeeGroesse) {
        this.kaffeeGroesse = kaffeeGroesse;
    }

    @Override
    public KaffeeGroesse getKaffeeGroesse() {
        return kaffeeGroesse;
    }

    public String toString() {
        return  TollerKaffee.class.getSimpleName() + " in der Größe " + kaffeeGroesse + "(" + kaffeeGroesse
                .getMilliLiter() + "ml)";
    }
}
