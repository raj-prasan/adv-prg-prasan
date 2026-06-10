public class SavingsAccount extends Account{
    private float interestRate;
    public  SavingsAccount(int accountNumber,String ownerName,float balance,float interestRate){
        super(accountNumber,ownerName, balance);
        this.interestRate = interestRate;;
    }
    public float getInterestRate(){
        return  interestRate;
    }
    public void setInterestRate(float newInterestRate){
        this.interestRate = newInterestRate;
    }

    @Override
    public void displayBalance() {
        System.out.println("Savings Account Balance: " + getBalance());
    }
}
