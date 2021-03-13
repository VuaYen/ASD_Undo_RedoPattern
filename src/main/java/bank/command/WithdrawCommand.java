package bank.command;


import bank.service.AccountService;

public class WithdrawCommand implements ICommand {
	
	private long accountNumber;
	private double amount;
	private AccountService accountService;

	public WithdrawCommand(long accountNumber, double amount, AccountService accountService) {
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.accountService = accountService;
	}

	public void execute() {
		// TODO Auto-generated method stub
		accountService.withdraw(accountNumber, amount);
	}

	public void unexecute() {
		// TODO Auto-generated method stub
		accountService.withdraw(accountNumber, -amount);
	}

}
