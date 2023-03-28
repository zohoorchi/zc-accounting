package ir.zohoorchi.accounting.account.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
public class Account {

	@Getter
	private AccountId id;

	@Getter
	private Money amount;

	@Getter
	private AccountOwner owner;

	@Getter
	private Money totalIncome;

	@Getter
	private Money totalOutcome;

	@Getter
	private Money debt;

	@Getter
	private Money credit;


	/**
	 * Tries to withdraw a certain value of money from this account.
	 * @return true if the withdrawal was successful, false if not.
	 */
	public boolean withdraw(Money money) {

		if (!mayWithdraw(money)) {
			return false;
		}
		amount = amount.minus(money);
		totalOutcome = totalOutcome.plus(money);
		return true;
	}

	/**
	 * Tries to deposit a certain amount of money to this account.
	 * @return true if the deposit was successful, false if not.
	 */
	public boolean deposit(Money money) {
		if (money.isNegative())
			return false;
		amount = amount.plus(money);
		totalIncome = totalIncome.plus(money);
		return true;
	}

	private boolean mayWithdraw(Money money) {
		return money.isPositiveOrZero() && amount.minus(money).isPositiveOrZero();
	}

	public record AccountId(long value) {
	}

}
