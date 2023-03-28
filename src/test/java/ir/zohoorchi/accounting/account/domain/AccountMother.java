package ir.zohoorchi.accounting.account.domain;

public class AccountMother {

	public static Account.AccountBuilder defaultAccount() {
		return Account.builder()
				.owner(new AccountOwner(new AccountOwner.AccountOwnerId(1)))
				.credit(Money.of(0))
				.debt(Money.of(0))
				.totalIncome(Money.of(100))
				.totalOutcome(Money.of(50))
				.amount(Money.of(50))
				.id(new Account.AccountId(2));
	}
}
