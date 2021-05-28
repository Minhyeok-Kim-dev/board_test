package com.edgc.common.base.model.network;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Client와 데이터 송수신에 사용되는 Custom Header class입니다.
 *  
 *  
 * Package 구성
 * - domain package > model > network 
 * 
 * 
 * @author MINHYEOK.KIM
 *
 * @param <T> 송수신에 사용되는 data type
 *   - 주로 BaseApiRequest 상속 class, BaseApiResponse 상속 class가 사용됩니다.
 */
@Getter
@Setter
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
