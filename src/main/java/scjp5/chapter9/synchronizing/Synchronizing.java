package java.scjp5.chapter9.synchronizing;

public class Synchronizing {

    public static void main(String[] args) {
        AccountDanger r = new AccountDanger();
        Thread one = new Thread(r, "Fred");
        Thread two = new Thread(r, "Lucy");
        one.start();
        two.start();

    }

}

class Account {
    private int balance = 50;

    public int getBalance() {
        return balance;
    }

    public void withDraw(int amount) {
        balance -= amount;
    }
}

class AccountDanger implements Runnable {

    private Account acct = new Account();

    @Override
    public void run() {
        for (int i = 0; i < 5; ++i) {
            makeWithdrawal(10);
            if (acct.getBalance() < 10) {
                System.out.println("account is overdrawn");
            }
        }
    }

    public synchronized void makeWithdrawal(int amt) {
        if (acct.getBalance() >= amt) {
            System.out.println(Thread.currentThread().getName()
                    + " is going to withdraw");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            acct.withDraw(10);
            System.out.println(Thread.currentThread().getName()
                    + " completes the withdraw");

        } else {
            System.out.println("Not enough in account for "
                    + Thread.currentThread().getName() + " to withdraw "
                    + acct.getBalance());
        }
    }
}
