package edu.craptocraft.enzinium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import edu.craptocraft.enzinium.TokenContractTest;

public class AddressTest {
    Address rick;
    Address morty;
    Address tom;
    TokenContract contract;

    @Before
    public void setupTest() {
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
        
        assertEquals(20d, morty.getBalance(), 0);
    }

    //     /** 
    //      * Morty Compra 2 entradas a 5 enZiniums cada una:
    //      * envia una transferencia al contrato de ricknillo 
    //      * por valor de 10 enZiniums:
    //      * 
    //      * send()
    //      * @param contrato
    //      * @param enziniums
    //      * Esta funcion envia esa cantidad de enziniums
    //      * al contrato (¡si la direccion dispone de suficientes enziniums!)
    //      * y actualiza el balance de Morty
    //      * morty.transferEZI(20d);
    //      * La funcion send() llama a la funcion payable() del contrato:
    //      * 
    //      * payable()
    //      * @param direccion del receptor de los tokens /entradas
    //      * @param cantidad de enziniums
    //      * Esta funcion calcula cuantas entradas se pueden comprar 
    //      * con esa cantidad de enziniums y llama a la funcion
    //      * transfer() del contrato para actualizar los balances 
    //      * de Morty (el receptor) y Rick (el vendedor, propietario
    //      * del contrato).
    //      * 
    //      * Finalmente, la funcion payable() del contrato le envia
    //      * los enZinium al propietario del contrato (Rick) mediante
    //      * la funcion transfer() de Address:
    //      * 
    //      * transferEZI()
    //      * @param address del receptor
    //      * @param cantidad de enZiniums
    //      * Actualiza el balance de EZI en la dirección del receptor
    //      * de esos enZiniums
    //      */


    @Test
    public void testSend() {
        morty.transferEZI(20d);
        morty.send(contract, 10d);
        assertEquals(10d, morty.getBalance(), 0);
        assertEquals(10d, contract.getOwner().balance, 0);
    }
}
