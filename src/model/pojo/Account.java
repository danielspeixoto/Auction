package model.pojo;

public class Account {
	private int userId;
	private double balance;
	private double frozenBalance;
	
	public Account() {
		this.balance = 0;
		this.frozenBalance = 0;
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
	
	@Override
    public String toString() {
        return  userId +
                "," + balance +
                "," + frozenBalance;
    }
	
}
