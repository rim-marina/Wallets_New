import java.util.HashMap;
import java.util.Map;

class Wallet {
    private String nameOfWallet;
    private String currency;
    private double budget;
    private double balance;

    public void setNameOfWallet(String nameOfWallet){this.nameOfWallet = nameOfWallet;}
    public String getNameOfWallet(){return nameOfWallet;}

    public void setCurrency(String currency){this.currency = currency;}
    public String getCurrency(){return currency;}

    public void setBudget(double budget){this.budget = budget;}
    public double getBudget(){return budget;}

    public void setBalance(double balance){ this.balance = balance;}
    public double getBalance(){ return balance;}

    Wallet(){}

    Wallet (String currency, double balance){

    }



}
