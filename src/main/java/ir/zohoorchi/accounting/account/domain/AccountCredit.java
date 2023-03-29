package ir.zohoorchi.accounting.account.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Builder(toBuilder = true)
public class AccountCredit {

	@Getter
	@NonNull
	final Account creditor;

	@Getter
	@NonNull
	final Account.AccountId debtor;

	@Getter
	@NonNull
	final BillingCycle billingCycle;

	@Getter
	@NonNull
	Money value;

}
