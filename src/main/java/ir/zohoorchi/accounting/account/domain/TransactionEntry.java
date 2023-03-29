package ir.zohoorchi.accounting.account.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class TransactionEntry {

	@Getter
	Transaction transaction;

	@Getter
	Account account;

	@Getter
	Money amount;

}
