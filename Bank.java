import java.io.*;
import java.util.*;

public class Bank {
    private Map<String, Account> accounts;
    private static final String FILE_NAME = "accounts.dat";

    public Bank() {
        accounts = loadAccounts();
    }

    public void createAccount(String accNo, String name, double initialBalance) {
        if (accounts.containsKey(accNo)) {
            System.out.println("Account already exists!");
        } else {
            Account acc = new Account(accNo, name, initialBalance);
            accounts.put(accNo, acc);
            saveAccounts();
            System.out.println("✅ Account created successfully!");
        }
    }

    public void deposit(String accNo, double amount) {
        Account acc = accounts.get(accNo);
        if (acc != null) {
            acc.deposit(amount);
            saveAccounts();
        } else {
            System.out.println("❌ Account not found!");
        }
    }

    public void withdraw(String accNo, double amount) {
        Account acc = accounts.get(accNo);
        if (acc != null) {
            acc.withdraw(amount);
            saveAccounts();
        } else {
            System.out.println("❌ Account not found!");
        }
    }

    public void checkBalance(String accNo) {
        Account acc = accounts.get(accNo);
        if (acc != null) {
            acc.displayDetails();
        } else {
            System.out.println("❌ Account not found!");
        }
    }

    public void transfer(String fromAcc, String toAcc, double amount) {
        Account sender = accounts.get(fromAcc);
        Account receiver = accounts.get(toAcc);

        if (sender != null && receiver != null) {
            if (sender.getBalance() >= amount) {
                sender.withdraw(amount);
                receiver.deposit(amount);
                saveAccounts();
                System.out.println("💸 Transfer successful!");
            } else {
                System.out.println("❌ Insufficient balance!");
            }
        } else {
            System.out.println("❌ Invalid account(s)!");
        }
    }

    private void saveAccounts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(accounts);
        } catch (IOException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private Map<String, Account> loadAccounts() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (Map<String, Account>) ois.readObject();
        } catch (Exception e) {
            return new HashMap<>();
        }
    }
}
