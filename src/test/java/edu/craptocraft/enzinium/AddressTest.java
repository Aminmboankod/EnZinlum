package edu.craptocraft.enzinium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class AddressTest {
    @Test
    public void constructorTest() {
        Address rick = new Address();
        rick.generateKeyPair();
        assertNotNull(rick);
        assertNotNull(rick.hashCode());
        assertNotNull(rick.toString());
        
    }
}
