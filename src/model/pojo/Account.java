package model.pojo;

import mock.Database;

public class Account {
	private int userId;
	private double balance;
	private double frozenBalance;
	
	public Account() {
		this.balance = 0;
		this.frozenBalance = 0;
	}
	
	public Account(int userId, double balance, double frozenBalance) {
		this.userId = userId;
		this.balance = balance;
		this.frozenBalance = frozenBalance;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getFrozenBalance() {
		return frozenBalance;
	}

	public void setFrozenBalance(double frozenBalance) {
		this.frozenBalance = frozenBalance;
	}
	

    public void addFrozenBalance(double value) {
		frozenBalance += value;
		balance -= value;
    }

    public void removeFrozenBalance(double value) {
		frozenBalance -= value;
		balance += value;
	}

	public void addBalance(double value) {
		balance += value;
	}

	public void bidCompleted(double value) {
		frozenBalance -= value;
	}

	@Override
    public String toString() {
        return  userId + Database.SPLIT + userId +
                Database.SPLIT + balance +
                Database.SPLIT + frozenBalance;
    }
}
