package ir.zohoorchi.accounting.account.domain;

import java.math.BigInteger;

public record Money (BigInteger value) {

	public static Money ZERO = Money.of(0L);

	public boolean isPositiveOrZero(){
		return this.value.compareTo(BigInteger.ZERO) >= 0;
	}

	public boolean isNegative(){
		return this.value.compareTo(BigInteger.ZERO) < 0;
	}

	public boolean isPositive(){
		return this.value.compareTo(BigInteger.ZERO) > 0;
	}

	public boolean isGreaterThanOrEqualTo(Money money){
		return this.value.compareTo(money.value) >= 0;
	}

	public boolean isGreaterThan(Money money){
		return this.value.compareTo(money.value) >= 1;
	}

	public static Money of(long value) {
		return new Money(BigInteger.valueOf(value));
	}

	public static Money add(Money a, Money b) {
		return new Money(a.value.add(b.value));
	}

	public Money minus(Money money){
		return new Money(this.value.subtract(money.value));
	}

	public Money plus(Money money){
		return new Money(this.value.add(money.value));
	}

	public static Money subtract(Money a, Money b) {
		return new Money(a.value.subtract(b.value));
	}

	public Money negate(){
		return new Money(this.value.negate());
	}

}
