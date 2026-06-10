public abstract class Account {
    int accountNumber;
    String ownerName;

    private double balance;
    public Account(){
        throw new IllegalArgumentException("Account Number and Name is required.");
    }

    public Account(int accountNumber, String name){
        this(accountNumber,name,0);
    }

    public Account(int accountNumber, String ownerName, float balance){
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        if(balance < 0){
            this.balance = 0;
        }
        else{
            this.balance = balance;
        }
    }

    public void deposit(float amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Deposit Amount should be greater than 0.");
        }
        else {
            this.balance += amount;

        }
    }
    public double withdraw(double amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Amount to be withdrawn must be greater than 0.");
        }
        else {
            if(this.balance < amount){
                throw new IllegalArgumentException("Insufficient Balance.");
            }
            else{
                this.balance -= amount;
            }
        }
        return this.balance;
    }
    public double getBalance(){
        return  this.balance;
    }

    public void displayBalance(){
        System.out.println("Account Balance: " + getBalance());
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

}
