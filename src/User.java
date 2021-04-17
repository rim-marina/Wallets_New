import inputData.WholeBudget;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class User implements Buy, Sell, ShowInfo{
    WholeBudget budget = new WholeBudget();
    Map<String, Wallet> usersWallet = new HashMap<>();

    void enter(){                                                       //вход в программу
        System.out.println("You are welcome!");
        openMainMenu();
    }

    void openMainMenu(){                                                //главное меню
        System.out.println(1 + " - Create new or choose wallet");
        System.out.println(2 + " - Delete wallet");
        System.out.println(3 + " - Show all my wallets");
        byte choice = new Scanner(System.in).nextByte();
        switch(choice){
            case 1: chooseWalletOrCreate();
            case 2: deleteWallet();
            case 3: {showWallets();
                openMainMenu();}
        }
    }

    void chooseWalletOrCreate(){                                                    //меню создания/выбора кошелька
        System.out.println("Do you want create new wallet(1) or choose yours(2)");
        byte choice = new Scanner(System.in).nextByte();
        switch (choice){
            case 1:
                createNewWallet();
                break;
            case 2:
                openWallet(chooseWallet());
                break;
            default:
                incorrectInput();
                chooseWalletOrCreate();
                break;
        }
    }

    void createNewWallet(){                             //создание нового кошелька
        System.out.println("You create new wallet");
        String currency = chooseCurrency();
        double balance = enterYourBalance();
        Wallet wallet = new Wallet(currency, balance);
        wallet.setNameOfWallet(enterName());
        wallet.setBalance(balance);
        wallet.setCurrency(currency);
        showBalance(wallet);
        usersWallet.putIfAbsent(wallet.getNameOfWallet(), wallet);
        openMainMenu();
    }

    void deleteWallet(){
        if(!usersWallet.isEmpty() && isBalancePositive(usersWallet.get(enterName()))){
            usersWallet.remove(enterName());
            }else {
            incorrectInput();
        }
        openMainMenu();
    }

    boolean isBalancePositive(Wallet wallet){
        return wallet.getBalance()>=0;
    }

    String enterName(){                                     //ввод имени кошелька
        System.out.println("Enter name your wallet");
        String name = new Scanner(System.in).next();
        return name;
    }

    double enterYourBalance(){                                  //ввод начального балланса
        System.out.println("Enter your balance");
        double balance = new Scanner(System.in).nextDouble();
        if (balance<0) {
            incorrectInput();
            enterYourBalance();
        }
        return balance;
    }

    Wallet chooseWallet(){                                      //выбирает кошелек по вводу имени
        Wallet choosingWallet = new Wallet();
        if(!usersWallet.isEmpty()){
            System.out.println("Enter name your wallet");
            String name = new Scanner(System.in).next();
            for (Map.Entry<String, Wallet> entry : usersWallet.entrySet()) {
                if (usersWallet.containsKey(name)) {
                    choosingWallet = entry.getValue();
                } else {
                    incorrectInput();
                    openMainMenu();
                }
            }
        }else {
            System.out.println("You don`t have wallets");
            openMainMenu();
        }
        return choosingWallet;
    }

    void openWallet(Wallet wallet) {         //меню кошелька
        System.out.println(1 + " - Show information");
        System.out.println(2 + " - Buy");
        System.out.println(3 + " - Sell");
        System.out.println(4 + " - AutoSettings");
        System.out.println(5 + " - Change balance");
        System.out.println(0 + " - Back in main menu");
        byte choice = new Scanner(System.in).nextByte();
        switch (choice) {
            case 1:
                showInfo(wallet);
                break;
            case 2:
                toBuy(wallet);
                break;
            case 3:
                toSell(wallet);
                break;
            case 4:
            case 0:
                openMainMenu();
        }
    }

    @Override
    public void toBuy(Wallet wallet) {          //покупает
        System.out.println("Enter purchase amount:");
        double amount = new Scanner(System.in).nextDouble();
        if (amount<=0){
            incorrectInput();
            toBuy(wallet);
        }else{
            wallet.setBalance(wallet.getBalance() + amount);
            showBalance(wallet);
            currencyBudgetAfterBuying(wallet.getCurrency(), amount);
            showBudget(wallet.getCurrency(), budget);
        }
        openWallet(wallet);
    }

    @Override
    public void toSell(Wallet wallet) {
        System.out.println("Enter the sale amount:");
        double amount = new Scanner(System.in).nextDouble();
        if (amount<=0 || amount>wallet.getBalance()){
            incorrectInput();
            toSell(wallet);
        }else if(amount<wallet.getBalance()) {
            wallet.setBalance(wallet.getBalance() - amount);
            showBalance(wallet);
            currencyBudgetAfterSelling(wallet.getCurrency(), amount);
            showBudget(wallet.getCurrency(), budget);
        }
        openWallet(wallet);
    }

    void currencyBudgetAfterBuying(String currency, double amount){
        if(currency.equals(budget.getDOLLAR())){
            budget.setDollarBudget(budget.getDollarBudget() - amount);
        }else if(currency.equals(budget.getEURO())){
            budget.setEuroBudget(budget.getEuroBudget() - amount);
        }else if(currency.equals(budget.getZLOTY())){
            budget.setZlotyBudget(budget.getZlotyBudget() - amount);
        }
    }

    void currencyBudgetAfterSelling(String currency, double amount){
        if(currency.equals(budget.getDOLLAR())){
            budget.setDollarBudget(budget.getDollarBudget() + amount);
        }else if(currency.equals(budget.getEURO())){
            budget.setEuroBudget(budget.getEuroBudget() + amount);
        }else if(currency.equals(budget.getZLOTY())){
            budget.setZlotyBudget(budget.getZlotyBudget() + amount);
        }
    }

    void showInfo(Wallet wallet){               //показывает информауию о кошельке и бюджете
        showBalance(wallet);
        showBudget(wallet.getCurrency(), budget);
        openWallet(wallet);
    }

    void showWallets(){                     //показывает все кошельки
        if(!usersWallet.isEmpty()){
            for (Map.Entry<String, Wallet> entry : usersWallet.entrySet()) {
                System.out.println("Your wallet " + entry.getKey() + " has " + entry.getValue().getBalance() +
                        " " + entry.getValue().getCurrency());
            }
        }else{
            incorrectInput();       //??
            openMainMenu();
            }
    }

    String chooseCurrency(){                                //выбор валюты
        System.out.println("Choose currency:");
        System.out.println(1 + " - USD");
        System.out.println(2 + " - EUR");
        System.out.println(3 + " - PLN");
        System.out.println(0 + " - back");
        String currency = null;
        byte choice = new Scanner(System.in).nextByte();
        switch(choice){
            case 1:
                currency = budget.getDOLLAR();
                break;
            case 2:
                currency = budget.getEURO();
                break;
            case 3:
                currency = budget.getZLOTY();
                break;
            case 0:
                enterName();
                break;
            default:
                incorrectInput();
                chooseWalletOrCreate();
                break;
        }
        return currency;
    }

    void incorrectInput(){          //некорректный ввод
        System.out.println("Incorrect input. Try again.");
    }

}
