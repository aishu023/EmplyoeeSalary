
import java.util.ArrayList;
import java.util.List;

class Account {
    private int balance;

    public Account() {
        this.balance = 0;
    }

    public synchronized String deposit(int money) {
        balance += money;
        return "Depositing $" + money;
    }

    public synchronized String withdraw(int money) {
        if (balance >= money) {
            balance -= money;
            return "Withdrawing $" + money;
        } else {
            return "Withdrawing $" + money + " (Insufficient Balance)";
        }
    }

    public synchronized int getBalance() {
        return balance;
    }
}

class Transaction {
    private Account account;
    private List<String> transactions;

    public Transaction(Account account) {
        this.account = account;
        this.transactions = new ArrayList<>();
    }

    public synchronized void deposit(int money) {
        String transaction = account.deposit(money);
        transactions.add(transaction);
    }

    public synchronized void withdraw(int money) {
        String transaction = account.withdraw(money);
        transactions.add(transaction);
    }

    public synchronized List<String> getTransaction() {
        return transactions;
    }
}


