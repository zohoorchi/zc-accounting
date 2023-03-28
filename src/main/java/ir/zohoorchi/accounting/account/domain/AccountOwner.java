package ir.zohoorchi.accounting.account.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class AccountOwner {

	@Getter
	private AccountOwnerId id;

	public record AccountOwnerId (long value) {
	}
}
