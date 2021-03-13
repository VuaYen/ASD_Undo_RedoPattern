package bank.command;


import bank.service.AccountService;

public class TransferFundsCommand implements ICommand {
	
	private long fromAccount;
	private long toAccount;
	private double amount;
	private String description;
	private AccountService accountService;

	public TransferFundsCommand(long fromAccount, long toAccount, double amount, String description,
			AccountService accountService) {
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
		this.description = description;
		this.accountService = accountService;
	}



	public void execute() {
		// TODO Auto-generated method stub
		accountService.transferFunds(fromAccount, toAccount, amount, description);
	}

	public void unexecute() {
		// TODO Auto-generated method stub
		accountService.transferFunds(toAccount, fromAccount, amount, description);
	}

}
