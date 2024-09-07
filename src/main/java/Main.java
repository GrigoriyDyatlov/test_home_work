//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Account debitScore = new SinpleAccount();
        Account creditScore = new CreditAccount(-200000);
        debitScore.add(500000);
        debitScore.pay(4500);
        creditScore.pay(10000);
        creditScore.add(5500);
        debitScore.transfer(debitScore, creditScore, 5500);
        debitScore.add(4000);
        creditScore.transfer(debitScore, creditScore, 200000);
        debitScore.transfer(debitScore, creditScore, 1000000);
    }
}