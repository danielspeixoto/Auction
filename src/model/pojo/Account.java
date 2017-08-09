package model.pojo;

public class Account {
	private double balance;
	private double frozenBalance;
	
	public Account(double balance) {
		this.balance = balance;
		this.frozenBalance = 0;
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
	
}
