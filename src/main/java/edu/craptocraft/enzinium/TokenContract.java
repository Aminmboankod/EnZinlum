package edu.craptocraft.enzinium;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;


public class TokenContract {

    public String name;
    public String symbol;
    public Integer totalSupply;
    public Double tokenPrice;
    public Address owner;
    private final Map<PublicKey, Double> balances = new HashMap();
    private PublicKey ownerPK;

    public TokenContract(Address owner) {
        this.owner = owner;
        this.ownerPK = owner.getPK();
    }

    public String getName() {
        return this.name;
    }

    public int totalSupply() {
        return this.totalSupply;
    }

    public double getPrice() {
        return this.tokenPrice;
    }

    public Map<PublicKey, Double> getBalances() {
        return this.balances;
    }

    public Address getOwner() {
        return this.owner;
    }

    public String symbol() {
        return this.symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setTotalSupply(int total) {
        this.totalSupply = total;
    }

    public void setTokenPrice(double price) {
        this.tokenPrice = price;
    }

    @Override
    public String toString(){
        return String.format("Name: %s \n Symbol: %s \n TotalSupply: %s \n Price: %s", getName(), symbol(), totalSupply(), getPrice());
    }

    public void addOwner(PublicKey publicKey, double balance) {
        getBalances().putIfAbsent(publicKey, balance);
    }


    public Object numOwners() {
        return balances.size();
    }

    public double balanceOf(PublicKey publicKey) {

        return this.getBalances().containsKey(publicKey) ? this.getBalances().get(publicKey): 0d;
    }


    public void transfer(PublicKey destinKey, double units) {
        try {
            require(balanceOf(this.ownerPK) >= units);
            this.getBalances().replace(this.ownerPK, this.getBalances().get(this.ownerPK) - units);
            this.getBalances().put( destinKey, balanceOf(destinKey) + units );

        } catch (Exception a) {
            //falla silenciosamente
        }
    }

    public void transfer(PublicKey senderKey, PublicKey destinKey, double units) {
        try {
            require(balanceOf(senderKey) >= units);
            this.getBalances().replace(senderKey, this.getBalances().get(senderKey) - units);
            this.getBalances().put( destinKey, balanceOf(destinKey) + units);
        } catch (Exception a) {
            //falla silenciosamente
        }
	}

    public void require(boolean holds) throws Exception {
        if (!holds) {
            throw new Exception();
        } 

    }


    

}













