package ir.zohoorchi.accounting.account.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
public class Transaction {

	@Getter
	private final Money amount;

	@Getter
	private final LocalDate creationTime;

	@Getter
	private final Journal journal;

	@Getter
	private TransactionStatus status;

}
