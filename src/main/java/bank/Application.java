package bank;

import java.util.Collection;

import bank.command.DepositCommand;
import bank.command.HistoryList;
import bank.command.TransferFundsCommand;
import bank.command.WithdrawCommand;
import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.service.AccountService;
import bank.service.IAccountService;



public class Application {
	public static void main(String[] args) {
		IAccountService accountService = new AccountService();
		HistoryList historyList = new HistoryList();
		// create 2 accounts;
		accountService.createAccount(1263862, "Frank Brown");
		accountService.createAccount(4253892, "John Doe");
		//use account 1;
		DepositCommand deposit = new DepositCommand(1263862, 240, (AccountService) accountService);
		deposit.execute();
		historyList.addCommand(deposit);

		deposit =new DepositCommand(1263862,529,(AccountService) accountService);
		deposit.execute();
		historyList.addCommand(deposit);

		//accountService.deposit(1263862, 240);
//		accountService.deposit(1263862, 529);
//		accountService.withdraw(1263862, 230);
		WithdrawCommand withdraw = new WithdrawCommand(1263862,230,(AccountService) accountService);
		withdraw.execute();
		historyList.addCommand(withdraw);
		//use account 2;
		DepositCommand deposit1= new DepositCommand(4253892,12450,(AccountService) accountService);
		deposit1.execute();
		historyList.addCommand(deposit1);
		TransferFundsCommand transfer= new TransferFundsCommand(4253892,1263862,100,"payment of invoice 10232",(AccountService) accountService);
		transfer.execute();
		historyList.addCommand(transfer);
		//		accountService.deposit(4253892, 12450);
//		accountService.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");
		// show balances
		
		Collection<Account> accountlist = accountService.getAllAccounts();
		Customer customer = null;
		for (Account account : accountlist) {
			customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountnumber());
			System.out.println("Account Holder: " + customer.getName());
			System.out.println("-Date-------------------------"
							+ "-Description------------------"
							+ "-Amount-------------");
			for (AccountEntry entry : account.getEntryList()) {
				System.out.printf("%30s%30s%20.2f\n", entry.getDate()
						.toString(), entry.getDescription(), entry.getAmount());
			}
			System.out.println("----------------------------------------"
					+ "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:",
					account.getBalance());
		}
		// undo
		historyList.undo();

		System.out.println("-----------------------After undo-------------------");
		for (Account account : accountlist) {
			customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountnumber());
			System.out.println("Account Holder: " + customer.getName());
			System.out.println("-Date-------------------------"
					+ "-Description------------------"
					+ "-Amount-------------");
			for (AccountEntry entry : account.getEntryList()) {
				System.out.printf("%30s%30s%20.2f\n", entry.getDate()
						.toString(), entry.getDescription(), entry.getAmount());
			}
			System.out.println("----------------------------------------"
					+ "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:",
					account.getBalance());
		}
	}

}


