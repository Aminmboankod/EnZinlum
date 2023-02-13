package edu.craptocraft.enzinium;

public class TokenContract {

    public String name;
    public String symbol;
    public Integer totalSupply;
    public Double tokenPrice;
    private Address owner;

    public TokenContract(Address address) {
        this.owner = new Address();
    }

    public String getName() {
        return this.name;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int getTotalSupply() {
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
        return String.format("Name: %s \n Symbol: %s \n TotalSupply: %s \n Price: %s", 
                                getName(), getSymbol(), getTotalSupply(), getPrice());
    }
    
}
