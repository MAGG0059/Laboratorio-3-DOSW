package edu.dosw.lab.testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.dosw.lab.testing.reto4.Banco;

public class BancoTest {

    @Test
    void testBancoEnumValues() {
        assertEquals("01", Banco.BANCOLOMBIA.getCodigo());
        assertEquals("02", Banco.DAVIVIENDA.getCodigo());
    }

    @Test
    void testBancoEnumValuesCount() {

        assertEquals(2, Banco.values().length);
    }
}