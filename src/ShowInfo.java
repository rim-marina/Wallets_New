import inputData.WholeBudget;

import static inputData.WholeBudget.*;

interface ShowInfo {
    default void showBalance(Wallet wallet){
        System.out.println("Your balance is " + wallet.getBalance() + " " + wallet.getCurrency());
    }
    default void showBudget(String currency, WholeBudget budget){
        if (currency == getDOLLAR()) {
            System.out.println(budget.getDollarBudget());
        } else if (currency == getEURO()){
            System.out.println(budget.getEuroBudget());
        } else if (currency == getZLOTY()){
            System.out.println(budget.getZlotyBudget());
        }
    };
}
