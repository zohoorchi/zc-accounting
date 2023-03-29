package ir.zohoorchi.accounting.account.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
@AllArgsConstructor
@Builder(toBuilder = true)
public class Account {

	@Getter
	private AccountId id;

	@Getter
	private AccountOwner owner;

	@Getter
	private Money cash;

	@Getter
	private Money credit;

	/**
	 * Tries to withdraw a certain value of money from this account cash.
	 * @return true if the withdrawal was successful, false if not.
	 */
	public boolean withdrawOfCash(Money money) {

		if (!mayWithdrawOfCash(money)) {
			return false;
		}
		cash = cash.minus(money);
		return true;
	}

	/**
	 * Tries to deposit a certain amount of money to this account cash.
	 * @return true if the deposit was successful, false if not.
	 */
	public boolean depositOfCash(Money money) {
		if (money.isNegative())
			return false;
		cash = cash.plus(money);
		return true;
	}

	public boolean withdrawOfCredit(Money money) {
		if (!mayWithdrawOfCredit(money)) {
			return false;
		}
		credit = credit.minus(money);
		return true;
	}

	public boolean depositOfCredit(Money money) {
		if (money.isNegative())
			return false;
		credit = credit.plus(money);
		return true;
	}

	protected boolean mayWithdrawOfCredit(Money money) {
		return money.isPositiveOrZero();
	}

	protected boolean mayWithdrawOfCash(Money money) {
		return money.isPositiveOrZero() && cash.minus(money).isPositiveOrZero();
	}

	public record AccountId(long value) {
	}

	public boolean isSame(Account another) {
		return cash.equals(another.cash) &&
				credit.equals(another.credit);
	}

}
