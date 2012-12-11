package de.doubleslash.coffee.domain;

import java.util.Comparator;

/**
 * Created by IntelliJ IDEA.
 */
public class KaffeeGroessenStringComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        KaffeeGroesse kaffeeGroesse1 = null;
        boolean oneIsEnum = true;
        try {
            kaffeeGroesse1 = KaffeeGroesse.valueOf(o1);
        } catch (Exception e) {
            oneIsEnum = false;
        }

        KaffeeGroesse kaffeeGroesse2 = null;
        boolean twoIsEnum = true;
        try {
            kaffeeGroesse2 = KaffeeGroesse.valueOf(o2);
        } catch (Exception e) {
            twoIsEnum = false;
        }

        if (oneIsEnum && twoIsEnum) {
            return kaffeeGroesse1.compareTo(kaffeeGroesse2);
        }
        if (oneIsEnum) {
            return 1;
        }
        if (twoIsEnum) {
            return -1;
        }

        return o1.compareTo(o2);
    }
}
