public class BalanceService {

    private int balance = 0;

    public void add(int count) {
        balance += count;
    }

    public void withdraw(int count) {
        System.out.println("Withdraw balance");
        balance -= count;
    }

    public int getBalance() {
        return balance;
    }
}
