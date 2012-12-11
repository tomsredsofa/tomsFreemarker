package de.doubleslash.coffee.service;

import de.doubleslash.coffee.domain.Becher;
import de.doubleslash.coffee.domain.Bestellung;
import de.doubleslash.coffee.domain.KaffeeGroesse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 */
@RunWith(MockitoJUnitRunner.class)
public class KaffeeMacherTest {

    @Mock
    private BecherService mockBecherService;
    @Captor
    private ArgumentCaptor<KaffeeGroesse> kaffeeGroesseCaptor;

    private KaffeeMacher kaffeeMacher;

    @Before
    public void setUp() throws Exception {
        kaffeeMacher = new KaffeeMacher();
        kaffeeMacher.setBecherService(mockBecherService);
    }

    @Test
    public void testBasicTassKaff() throws Exception {
        when(mockBecherService.frischenBecher(Matchers.<KaffeeGroesse>any()))
                .thenReturn(new Becher(KaffeeGroesse.NORMAL));

        Bestellung bestellung = new Bestellung(KaffeeGroesse.TASSE);
        kaffeeMacher.tassKaff(bestellung);
    }

    @Test
    public void testTassKaffMitCaptor() throws Exception {
        when(mockBecherService.frischenBecher(kaffeeGroesseCaptor.capture()))
                .thenReturn(new Becher(KaffeeGroesse.NORMAL));

        Bestellung bestellung = new Bestellung(KaffeeGroesse.TASSE);
        kaffeeMacher.tassKaff(bestellung);

        assertEquals("Die Methode frischenBecher ist mit der falschen KaffeeGroesse aufgerufen worden",
                KaffeeGroesse.TASSE,
                kaffeeGroesseCaptor.getValue());
    }

    @Test
    public void testMehrereTassKaffZweimalAufrufen() throws Exception {
        when(mockBecherService.frischenBecher(Matchers.<KaffeeGroesse>any()))
                .thenReturn(new Becher(KaffeeGroesse.NORMAL), new Becher(KaffeeGroesse.EIMER));

        List<Bestellung> bestellungen = new ArrayList<>();
        bestellungen.add(new Bestellung(KaffeeGroesse.NORMAL));
        bestellungen.add(new Bestellung(KaffeeGroesse.EIMER));

        kaffeeMacher.mehrereTassKaff(bestellungen);

        verify(mockBecherService, times(2)).frischenBecher(Matchers.<KaffeeGroesse>any());
//        verifyNoMoreInteractions(mockBecherService);
    }

    @Test
    public void testTassKaffMitVoid() throws Exception {
        when(mockBecherService.frischenBecher(Matchers.<KaffeeGroesse>any()))
                .thenReturn(new Becher(KaffeeGroesse.NORMAL));
//        doNothing().when(mockBecherService).printBecherPool();

        Bestellung bestellung = new Bestellung(KaffeeGroesse.TASSE);
        kaffeeMacher.tassKaff(bestellung);

        verify(mockBecherService).frischenBecher(Matchers.<KaffeeGroesse>any());
        verify(mockBecherService).printBecherPool();
        verifyNoMoreInteractions(mockBecherService);
    }
}
