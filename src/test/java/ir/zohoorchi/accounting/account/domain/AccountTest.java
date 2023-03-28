package ir.zohoorchi.accounting.account.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

	@Test
	void withdraw_WhenAmountIsNotSufficient_ReturnsFalse() {
		Account a = AccountMother.defaultAccount().build();
		Money firstAmount = a.getAmount();
		boolean withdrawResult = a.withdraw(a.getAmount().plus(Money.of(1)));
		assertFalse(withdrawResult);
		assertEquals(firstAmount, a.getAmount());
	}

	@Test
	void withdraw_WhenMoneyIsNegative_ReturnsFalse() {
		Account a = AccountMother.defaultAccount().build();
		Money firstAmount = a.getAmount();
		boolean withdrawResult = a.withdraw(Money.of(-1));
		assertFalse(withdrawResult);
		assertEquals(firstAmount, a.getAmount());
	}

	@Test
	void withdraw_WhenAmountIsSufficient_Succeed() {
		Account a = AccountMother.defaultAccount().build();
		Money withdrawValue = Money.of(1);
		Money firstAmount = a.getAmount();
		Money firstOutcome =  a.getTotalOutcome();
		Money firstIncome =  a.getTotalIncome();
		boolean withdrawResult = a.withdraw(withdrawValue);
		assertTrue(withdrawResult);
		assertEquals(a.getAmount(), firstAmount.minus(withdrawValue));
		assertEquals(a.getTotalOutcome(), firstOutcome.plus(withdrawValue));
		assertEquals(a.getTotalIncome(), firstIncome);
	}

	@Test
	void deposite_WhenMoneyIsNegative_ReturnsFalse() {
		Account a = AccountMother.defaultAccount().build();
		Money firstAmount = a.getAmount();
		boolean depositResult = a.deposit(Money.of(-1));
		assertFalse(depositResult);
		assertEquals(firstAmount, a.getAmount());
	}

	@Test
	void withdraw_WhenAmountIsPositive_Succeed() {
		Account a = AccountMother.defaultAccount().build();
		Money depositValue = Money.of(1);
		Money firstAmount = a.getAmount();
		Money firstOutcome =  a.getTotalOutcome();
		Money firstIncome =  a.getTotalIncome();
		boolean depositResult = a.deposit(depositValue);
		assertTrue(depositResult);
		assertEquals(a.getAmount(), firstAmount.plus(depositValue));
		assertEquals(a.getTotalOutcome(), firstOutcome);
		assertEquals(a.getTotalIncome(), firstIncome.plus(depositValue));
	}
}