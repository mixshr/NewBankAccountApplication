package bancaccountapp;

public abstract class Account implements IBaseRate {

    // List common properties for savings and checking account
    private String name;
    private String sSN;
    private double balance;

    private static int index = 10000;
    protected String accountNumber;
    protected double rate;

    // Constructor to set base properties and initialize the account
    public Account(String name, String sSN, double initDeposit) {
        this.name = name;
        this.sSN = sSN;
        balance = initDeposit;

        // Set account number
        index++;
        this.accountNumber = setAccountNumber();
        setRate();
    }

    public abstract void setRate();

    private String setAccountNumber() {
        String lastTwoOfSSN = sSN.substring(sSN.length() - 2, sSN.length());
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * Math.pow(10, 3));
        return lastTwoOfSSN + uniqueID + randomNumber;
    }

    public void compound(){
        double accruedInterest = balance * (rate/100);
        balance += accruedInterest;
        System.out.println("ACCRUED INTEREST: $" + accruedInterest);
        printBalance();

    }

    // List common method transactions
    public void deposit(double amount){
        balance = balance + amount;
        System.out.println("DEPOSITING $" + amount);
    }

    public void withdraw(double amount){
        balance = balance - amount;
        System.out.println("WITDDRAWING $" + amount);
    }

    public void transfer(String toWhere, double amount){
        balance = balance - amount;
        System.out.println("TRANFERING $" + amount + " TO " + toWhere);
    }

    public void printBalance(){
        System.out.println("YOUR BALANCE IS NOW: $" + balance);
    }

    public void showInfo(){
        System.out.println(
                "\nNAME: " + name +
                "\nACCOUNT NUMBER: " + accountNumber +
                "\nBALACE: " + balance +
                "\nRATE: " + rate + "%"
        );
    }
}
