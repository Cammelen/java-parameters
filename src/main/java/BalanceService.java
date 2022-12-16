public class BalanceService {

    private int balance = 0;

    public void add(int count) {
        balance += count;
    }

    public void withdraw(int count) {
        balance -= count;
    }

    public int getBalance() {
        return balance;
    }
}
