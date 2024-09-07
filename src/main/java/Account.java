public interface Account {
    boolean add(long amount);

    boolean pay(long amount);

    boolean transfer(Account fromAccount, Account toAccount, long amount);
 long getBalance ();
}
