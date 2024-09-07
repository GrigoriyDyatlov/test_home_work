public class CreditAccount implements Account {
    protected long creditLimit;
    protected long balance;

    public CreditAccount(long creditLimit) {
        if (creditLimit < 0) {
            this.creditLimit = creditLimit;
            this.balance = 0;
        } else {
            System.out.println("Error");
        }
    }

    @Override
    public boolean add(long amount) {
        if (amount > 0 & (amount + balance) < 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean pay(long amount) {
        amount = Math.abs(amount);
        if ((amount - balance) >= creditLimit) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean transfer(Account fromAccount, Account toAccount, long amount) {
        if (fromAccount.pay(amount)) {
            if (toAccount.add(amount)) {
                return true;
            } else {
                fromAccount.add(amount);
                return false;
            }
        } else {
            return false;
        }
    }
    @Override
    public long getBalance() {
        return balance;
    }
}
