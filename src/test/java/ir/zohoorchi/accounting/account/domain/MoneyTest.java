package ir.zohoorchi.accounting.account.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

	@Test
	void minus_whenUnderflow_Failed() {
		ArithmeticException exception = assertThrows(ArithmeticException.class,
				() -> Money.of(Long.MIN_VALUE).minus(Money.of(10)));
	}

	@Test
	void minus_whenOverflow_Failed() {
		assertThrows(ArithmeticException.class,
				() -> Money.of(Long.MAX_VALUE).minus(Money.of(-10)));
	}

	@Test
	void plus_whenOverflow_Failed() {
		assertThrows(ArithmeticException.class,
				() -> Money.of(Long.MAX_VALUE).plus(Money.of(10)));
	}

	@Test
	void plus_whenUnderflow_Failed() {
		assertThrows(ArithmeticException.class,
				() -> Money.of(Long.MIN_VALUE).plus(Money.of(-10)));
	}

}