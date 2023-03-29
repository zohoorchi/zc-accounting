package ir.zohoorchi.accounting.account.application.port.in;

import ir.zohoorchi.accounting.account.domain.Account;
import ir.zohoorchi.accounting.account.domain.Money;
import ir.zohoorchi.accounting.common.SelfValidating;
import jakarta.validation.constraints.NotNull;

public interface SendMoneyUseCase {

	SendMoneyResult sendMoney(SendMoneyCommand command);

	class SendMoneyCommand extends SelfValidating<SendMoneyCommand> {
		@NotNull
		Account.AccountId source;

		@NotNull
		Account.AccountId target;

		@NotNull
		Money amount;

		@NotNull
		SendMoneyType sendType;

		public SendMoneyCommand(
				Account.AccountId source,
				Account.AccountId target,
				Money amount, SendMoneyType sendType) {
			this.source = source;
			this.target = target;
			this.amount = amount;
			this.sendType = sendType;
			this.validateSelf();
		}

		public SendMoneyCommand(
				Account.AccountId source,
				Account.AccountId target,
				Money amount) {
			this(source, target, amount, SendMoneyType.CASH);
		}

	}

	class SendMoneyResult {
		boolean success;
		Money sentCash;
		Money sentCredit;
	}

	enum SendMoneyType {
		CASH,
		CREDIT,
		CASH_OR_CREDIT
	}

}
