package com.lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankAccount {

    private static final Logger logger = LoggerFactory.getLogger(BankAccount.class);

    private final String accountId;
    private double balance;

    public BankAccount(String accountId, double initialBalance) {
        this.accountId = accountId;
        this.balance = initialBalance;
        logger.info("Account created: id={}, initialBalance={}", accountId, initialBalance);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            logger.error("Deposit failed: invalid amount={} for account={}", amount, accountId);
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
        logger.info("Deposit successful: account={}, amount={}, newBalance={}", accountId, amount, balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            logger.error("Withdrawal failed: invalid amount={} for account={}", amount, accountId);
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            logger.error("Withdrawal failed: insufficient funds account={}, requested={}, balance={}",
                    accountId, amount, balance);
            throw new IllegalStateException("Insufficient funds");
        }
        balance -= amount;
        logger.info("Withdrawal successful: account={}, amount={}, newBalance={}", accountId, amount, balance);
    }

    public double getBalance() {
        logger.debug("Balance queried: account={}, balance={}", accountId, balance);
        return balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public static void main(String[] args) {
        logger.info("=== BankSystem Demo ===");
        BankAccount account = new BankAccount("ACC-001", 1000.0);
        account.deposit(500.0);
        account.withdraw(200.0);
        logger.info("Final balance: {}", account.getBalance());
        logger.info("=== Done ===");
    }
}
