package de.doubleslash.coffee.domain;

/**
 * Created with IntelliJ IDEA.
 */
public enum KaffeeGroesse {
    GARKEIN(0),
    WINZIG(90),
    KLEIN(120),
    NORMAL(180),
    TASSE(200),
    BECHER(250),
    EIMER(500);

    private int milliLiter;

    private KaffeeGroesse(int mills) {
        milliLiter = mills;
    }

    public int getMilliLiter() {
        return milliLiter;
    }

}
