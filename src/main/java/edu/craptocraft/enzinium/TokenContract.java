package edu.craptocraft.enzinium;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class TokenContract {

    public String name;
    public String symbol;
    public Integer totalSupply;
    public Double tokenPrice;
    private Address owner;
    public Map balances = new HashMap<Address, Double>();

    public TokenContract(Address address) {
        this.owner = new Address();
    }

    public String getName() {
        return this.name;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int totalSupply() {
        return this.totalSupply;
    }

    public double getPrice() {
        return this.tokenPrice;
    }

    public Address getOwner() {
        return this.owner;
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
        return String.format("Name: %s \n Symbol: %s \n TotalSupply: %s \n Price: %s", getName(), getSymbol(), totalSupply(), getPrice());
    }

    public void addOwner(PublicKey publicKey, double balance) {
        balances.putIfAbsent(publicKey, balance);
    }


	public double getOwnerBalance(PublicKey pk) {
		return 0;
	}

	public Object getBalances() {
		return null;
	}

    public void assertNotNull(TokenContract ricknillos) {
    }
    

}













