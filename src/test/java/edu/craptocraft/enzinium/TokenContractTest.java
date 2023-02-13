package edu.craptocraft.enzinium;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TokenContractTest {

    @Test
    public void constructorTest() {
        Address rick = new Address();
        rick.generateKeyPair();
        TokenContract ricknillos = new TokenContract(rick);
        ricknillos.setName("Ricknillos");
        ricknillos.setSymbol("RNiLL");
        ricknillos.setTotalSupply(100);
        ricknillos.setTokenPrice(5d);

        assertNotNull(ricknillos);
    }
}
