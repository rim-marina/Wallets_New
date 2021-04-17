package inputData;

public class WholeBudget{
    private final static String DOLLAR = "USD";
    private final static String EURO = "EUR";
    private final static String ZLOTY = "PLN";

    private double dollarBudget = 5486215.56;
    private double euroBudget = 4851265.25;
    private double zlotyBudget = 45889954558.33;

    private double balanceDollar;
    private double balanceEuro;
    private double balanceZloty;

    public static String  getDOLLAR() {return DOLLAR;}
    public static String  getEURO() {return EURO;}
    public static String getZLOTY() {return ZLOTY;}

    public double getDollarBudget() {return dollarBudget;}
    public void setDollarBudget(double dollarBudget) {this.dollarBudget = dollarBudget;}

    public double getEuroBudget() {return euroBudget;}
    public void setEuroBudget(double euroBudget) {this.euroBudget = euroBudget;}

    public double getZlotyBudget() {return zlotyBudget;}
    public void setZlotyBudget(double zlotyBudget) {this.zlotyBudget = zlotyBudget;}

    public double getBalanceDollar() {return balanceDollar;}
    public void setBalanceDollar(double balanceDollar) {
        this.balanceDollar = balanceDollar;
    }

    public double getBalanceEuro() {return balanceEuro;}
    public void setBalanceEuro(double balanceEuro) {
        this.balanceEuro = balanceEuro;
    }

    public double getBalanceZloty() {return balanceZloty;}
    public void setBalanceZloty(double balanceZloty) {
        this.balanceZloty = balanceZloty;
    }

}