package ir.zohoorchi.accounting.account.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
public class BillingCycle implements Comparable<BillingCycle> {

	@Getter
	int cycleNumber;

	@Getter
	LocalDateTime from;

	@Getter
	LocalDateTime to;

	@Override
	public int compareTo(BillingCycle o) {
		return this.cycleNumber - o.cycleNumber;
	}
}
