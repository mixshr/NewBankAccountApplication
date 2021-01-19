package bancaccountapp;

public class Checking extends Account {
    // List properties specific to a Checking account
    private int debitCardNumber;
    private int debitCarPin;

    // Constructor to initialize checking account properties
    public Checking(String name, String sSN, double initDeposit){
        super(name, sSN, initDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }

    @Override
    public void setRate() {
      rate = getBaseRate() * .15;
    }

    // List any methods specific to thr checking account
    private void setDebitCard(){
        debitCardNumber = (int)(Math.random() * Math.pow(10, 12));
        debitCarPin = (int)(Math.random() * Math.pow(10, 4));
    }

    public void showInfo(){
        super.showInfo();
        System.out.println("YOUR CHEECKING ACCOUNT FEATURES" +
                "\n DEBIT CARD NUMBER: " + debitCardNumber +
                "\n DEBIT CARD PIN: " + debitCarPin
        );
    }
}
