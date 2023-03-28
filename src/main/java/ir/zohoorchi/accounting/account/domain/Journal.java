package ir.zohoorchi.accounting.account.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Journal {

	@Getter
	private JournalId id;

	public record JournalId(long id) {

	}
}
