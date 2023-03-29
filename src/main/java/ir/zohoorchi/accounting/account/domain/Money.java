package ir.zohoorchi.accounting.account.domain;

import java.math.BigInteger;

public record Money (long value) {

	public static Money ZERO = Money.of(0L);

	public boolean isPositiveOrZero(){
		return this.value >= 0;
	}

	public boolean isNegative(){
		return this.value < 0;
	}

	public boolean isPositive(){
		return this.value > 0;
	}

	public boolean isGreaterThanOrEqualTo(Money money){
		return this.value >= money.value;
	}

	public boolean isGreaterThan(Money money){
		return this.value > money.value;
	}

	public static Money of(long value) {
		return new Money(value);
	}

	public static Money add(Money a, Money b) {
		BigInteger newValue = BigInteger.valueOf(a.value).add(BigInteger.valueOf(b.value));
		return new Money(newValue.longValueExact());
	}

	public static Money subtract(Money a, Money b) {
		BigInteger newValue = BigInteger.valueOf(a.value).subtract(BigInteger.valueOf(b.value));
		return new Money(newValue.longValueExact());
	}

	public static long diff(Money a, Money b) {
		return subtract(a, b).value;
	}

	public Money minus(Money money){
		return subtract(this, money);
	}

	public Money plus(Money money){
		return add(this, money);
	}

	public Money negate(){
		return new Money(this.value * (-1));
	}

}
