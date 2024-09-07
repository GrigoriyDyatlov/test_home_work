public class SinpleAccount implements Account {
    protected long simpleAcctBlc;

    public SinpleAccount() {
        this.simpleAcctBlc = 0;
    }

    @Override
    public boolean add(long amount) {
        if (amount > 0) {
            simpleAcctBlc += amount;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean pay(long amount) {
        amount = Math.abs(amount);
        if ((simpleAcctBlc - amount) >= 0) {
            simpleAcctBlc -= amount;
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
    public long getBalance(){
        return simpleAcctBlc;
    }
}

