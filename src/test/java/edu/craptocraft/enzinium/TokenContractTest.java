package edu.craptocraft.enzinium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;


public class TokenContractTest {
    Address rick = null;
    Address morty = null;
    TokenContract ricknillos = null;


    @Before
    public void constructorTest() {

        rick = new Address();
        rick.generateKeyPair();
        ricknillos = new TokenContract(rick);
        ricknillos.addOwner(rick.getPK(), 500d);
        
    }

    @Test
    public void addOwner_test() {

        ricknillos.addOwner(rick.getPK(), 0d);
        assertEquals(1, ricknillos.balances.size());
    }
}
