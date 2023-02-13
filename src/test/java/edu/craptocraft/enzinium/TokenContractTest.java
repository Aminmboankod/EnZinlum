package edu.craptocraft.enzinium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
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

        morty = new Address();
        morty.generateKeyPair();
        ricknillos = new TokenContract(rick);
        ricknillos.addOwner(rick.getPK(), 500d);
        
    }

    @Test
    public void addOwner_test() {

        ricknillos.addOwner(rick.getPK(), 0d);
        assertEquals(1, ricknillos.balances.size());

        ricknillos.addOwner(morty.getPK(), 200d);
        assertEquals(2, ricknillos.balances.size());
    }

    @Test
    public void numOwnersTest() {
        assertEquals(1, ricknillos.numOwners());
        assertNotEquals(3, ricknillos.numOwners());
    }
}
