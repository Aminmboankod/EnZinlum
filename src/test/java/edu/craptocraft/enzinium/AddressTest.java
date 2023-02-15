package edu.craptocraft.enzinium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class AddressTest {
    Address rick;
    Address morty;
    Address tom;

    @Before
    public void setupTest() {
        rick = new Address();
        rick.generateKeyPair();



        morty = new Address();
        morty.generateKeyPair();

        tom = new Address();
        tom.generateKeyPair();
        
    }

        //      * Vamos a comprar entradas con nuestra moneda enZinium.
    //      * 
    //      * Añade 20 enZiniums a la direccion de Morty:
    //      * 
    //      * transferEZI()
    //      * @param address del receptor
    //      * @param cantidad de enZiniums
    //      * Añade la cantidad de EZi al balance de EZI en
    //      * la dirección del receptor.
    //      */


    @Test
    public void testConstructor() {
        assertNotNull(rick);
        assertNotNull(rick.hashCode());
        assertNotNull(rick.toString());
    }
    @Test
    public void testTransferEZI() {
        morty.transferEZI(20d);
        assertEquals(20d, morty.getBalance(), 0);


    }
}
