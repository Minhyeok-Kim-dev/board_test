package com.edgc.common.base.model.network;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Header<T> {
	private LocalDateTime transactionTime;
	private boolean success;
	private String code;
	private String message;
	
	private T data;
	
	// OK
	@SuppressWarnings("unchecked")
	public static<T> Header<T> OK() {
		return (Header<T>) Header.builder()
				.transactionTime(LocalDateTime.now())
				.success(true)
				.code("200")
				.message("OK")
				.build();
	}
	
	// Data OK
	@SuppressWarnings("unchecked")
	public static<T> Header<T> OK(T data) {
		return (Header<T>) Header.builder()
				.transactionTime(LocalDateTime.now())
				.success(true)
				.code("200")
				.message("OK")
				.data(data)
				.build();
	}
	
	// Data OK
	@SuppressWarnings("unchecked")
	public static<T> Header<T> Error() {
		return (Header<T>) Header.builder()
				.transactionTime(LocalDateTime.now())
				.success(false)
				.message("ERROR")
				.build();
	}
}
