package edu.craptocraft.enzinium;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Address {

    public PublicKey publicKey = null;
    private PrivateKey privateKey = null;
    public Double balance = 0d;
    public String symbol= "EZI";

    public Address() {
        
    }

    public PublicKey getPublicKey() {
        return this.publicKey;
    }

    public PrivateKey gPrivateKey() {
        return this.privateKey;
    }

    public void setPublicKey(PublicKey key) {
        this.publicKey = key;
    }

    public void setPrivateKey(PrivateKey key) {
        this.privateKey = key;
    }

    public void generateKeyPair() {
        KeyPair pair =  GenSig.generateKeyPair();
        this.publicKey = pair.getPublic();
        this.privateKey = pair.getPrivate();
    }

    @Override
    public String toString() {
        return "Address: "+ this.publicKey.hashCode() + " balance: "+this.balance + this.symbol;
    }
    
}