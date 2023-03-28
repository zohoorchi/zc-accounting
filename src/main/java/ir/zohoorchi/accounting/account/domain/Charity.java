package ir.zohoorchi.accounting.account.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Charity {

	@Getter
	private CharityId id;

	@Getter
	private String name;

	public record CharityId(long value) {

	}
}
