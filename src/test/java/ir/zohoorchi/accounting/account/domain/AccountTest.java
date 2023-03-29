package ir.zohoorchi.accounting.account.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

	@Test
	void withdrawOfCash_WhenCashIsNotSufficient_ReturnsFalse() {
		Account a = AccountMother.defaultAccount().build();
		Money firstCash = a.getCash();
		boolean withdrawResult = a.withdrawOfCash(a.getCash().plus(Money.of(1)));
		assertFalse(withdrawResult);
		assertEquals(firstCash, a.getCash());
	}

	@Test
	void withdrawOfCash_WhenMoneyIsNegative_ReturnsFalse() {
		Account a = AccountMother.defaultAccount().build();
		Money firstCash = a.getCash();
		boolean withdrawResult = a.withdrawOfCash(Money.of(-1));
		assertFalse(withdrawResult);
		assertEquals(firstCash, a.getCash());
	}

	@Test
	void withdrawOfCash_WhenCashIsSufficient_Succeed() {
		Account a = AccountMother.defaultAccount().build();
		Money withdrawValue = Money.of(1);
		Money firstCash = a.getCash();
		boolean withdrawResult = a.withdrawOfCash(withdrawValue);
		assertTrue(withdrawResult);
		assertEquals(a.getCash(), firstCash.minus(withdrawValue));
	}

	@Test
	void depositOfCash_WhenMoneyIsNegative_ReturnsFalse() {
		Account a = AccountMother.defaultAccount().build();
		Money firstCash = a.getCash();
		boolean depositResult = a.depositOfCash(Money.of(-1));
		assertFalse(depositResult);
		assertEquals(firstCash, a.getCash());
	}

	@Test
	void depositOfCash_WhenCashIsPositive_Succeed() {
		Account a = AccountMother.defaultAccount().build();
		Money depositValue = Money.of(1);

		Account b = a.toBuilder()
				.cash(a.getCash().plus(depositValue))
				.build();

		boolean depositResult = a.depositOfCash(depositValue);
		assertTrue(depositResult);
		assertTrue(a.isSame(b));
	}

	@Test
	void isSame_WhenCashsAreNotEquals_ReturnsFalse() {
		Account a = AccountMother.defaultAccount().build();
		Account b = AccountMother.defaultAccount().cash(a.getCash().plus(Money.of(10))).build();
		assertFalse(a.isSame(b));
	}

	@Test
	void isSame_WhenCreditsAreNotEquals_ReturnsFalse() {
		Account a = AccountMother.defaultAccount().build();
		Account b = AccountMother.defaultAccount().credit(a.getCredit().plus(Money.of(10))).build();
		assertFalse(a.isSame(b));
	}

	@Test
	void isSame_WhenOnlyMoneyFieldsAreEquals_ReturnsTrue() {
		Account a = AccountMother.defaultAccount().build();
		Account b = AccountMother.defaultAccount()
				.id(new Account.AccountId(a.getId().value()+1))
				.owner(new AccountOwner(new AccountOwner.AccountOwnerId(a.getOwner().getId().value()+1)))
				.build();
		assertTrue(a.isSame(b));
	}

}