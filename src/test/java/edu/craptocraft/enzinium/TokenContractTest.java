package edu.craptocraft.enzinium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import java.security.PublicKey;

import org.junit.Before;
import org.junit.Test;


public class TokenContractTest {
    Address rick;
    Address morty;
    Address tom;
    TokenContract contract;


    @Before
    public void constructorTest() {

        rick = new Address();
        rick.generateKeyPair();

        morty = new Address();
        morty.generateKeyPair();

        contract = new TokenContract(rick);
        contract.setName("Ricknillos");
        contract.setSymbol("RNiLL");
        contract.setTotalSupply(500);
        contract.setTokenPrice(5d);
        contract.addOwner(rick.getPK(), 500d);
        
    }

    @Test
    public void addOwner_test() {

        contract.addOwner(rick.getPK(), 500d);
        assertEquals(1, contract.getBalances().size());

        contract.addOwner(morty.getPK(), 200d);
        assertEquals(2, contract.getBalances().size());
    }

    @Test
    public void numOwnersTest() {
        assertEquals(1, contract.numOwners());
        assertNotEquals(3, contract.numOwners());
    }

    @Test
    public void balanceOfTest() {
        assertEquals(500d, contract.balanceOf(rick.getPK()), 0);
    
    }

    @Test
    public void transferTest(){
        contract.transfer(morty.getPK(), 10);
        assertEquals(490d, contract.balanceOf(rick.getPK()), 0);    
    }

    // @Test
    // public void requireTest() {
    //     ricknillos.require(rick.balance>1);
    //     assertThrows(true, ricknillos.require(rick.balance<1));
    // }
}
