package ir.zohoorchi.accounting.account.application.service;

import ir.zohoorchi.accounting.account.application.port.in.SendMoneyUseCase;
import ir.zohoorchi.accounting.common.UseCase;

@UseCase
public class SendMoneyService implements SendMoneyUseCase {

	@Override
	public SendMoneyResult sendMoney(SendMoneyCommand command) {
		return null;
	}

}
