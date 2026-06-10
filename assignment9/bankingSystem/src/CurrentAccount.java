public class CurrentAccount extends Account{
    private float overdraftLimit;

    public  CurrentAccount(int accountNumber,String ownerName,float balance,float overdraftLimit){
        super(accountNumber,ownerName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double withdraw(double amount) {
        if(amount <= getBalance() + overdraftLimit){
            setBalance(getBalance() - amount);
        }
        else{
            throw new IllegalArgumentException("Overdraft Limit exceeded.");
        }
        return this.getBalance();
    }
}
