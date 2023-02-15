package edu.craptocraft.enzinium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;


public class TokenContractTest {
    Address rick;
    Address morty;
    Address tom;
    TokenContract contract;


    @Before
    public void testConstructor() {

        rick = new Address();
        rick.generateKeyPair();

        morty = new Address();
        morty.generateKeyPair();

        tom = new Address();
        tom.generateKeyPair();

        contract = new TokenContract(rick);
        contract.setName("Ricknillos");
        contract.setSymbol("RNiLL");
        contract.setTotalSupply(500);
        contract.setTokenPrice(5d);
        contract.addOwner(rick.getPK(), 500d);
        
    }

    @Test
    public void testAddOwner() {

        contract.addOwner(rick.getPK(), 500d);
        assertEquals(1, contract.getBalances().size());

        contract.addOwner(morty.getPK(), 200d);
        assertEquals(2, contract.getBalances().size());
    }

    @Test
    public void testNumOwners() {
        assertEquals(1, contract.numOwners());
        assertNotEquals(3, contract.numOwners());
    }

    @Test
    public void testBalanceOf() {
        assertEquals(500d, contract.balanceOf(rick.getPK()), 0);
    
    }

    @Test
    public void testTransfer(){
        contract.transfer(morty.getPK(), 10);
        assertEquals(490d, contract.balanceOf(rick.getPK()), 0); 
        
        contract.transfer(morty.getPK(), tom.getPK(), 1d);
        assertEquals(9d, contract.balanceOf(morty.getPK()), 0);
    }


    @Test
    public void testTotalTokensSold() {
        contract.transfer(morty.getPK(), 10);
        assertEquals(10, contract.totalTokensSold(), 0);
    }




}
