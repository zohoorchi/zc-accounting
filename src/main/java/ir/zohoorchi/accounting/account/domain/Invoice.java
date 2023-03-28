package ir.zohoorchi.accounting.account.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDateTime;

@AllArgsConstructor
public class Invoice {

	@Getter
	private InvoiceId id;

	@Getter
	@NonNull
	private final AccountOwner payer;

	@Getter
	@NonNull
	private final Money amount;

	@Getter
	private InvoiceStatus status;

	@Getter
	@NonNull
	private final LocalDateTime creationTime;

	@Getter
	@NonNull
	private LocalDateTime updateTime;

	public record InvoiceId(long value) {

	}
}
