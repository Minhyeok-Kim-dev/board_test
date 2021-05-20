package com.edgc.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 날짜 처리 관련 util class
 * @author Minhyeok Kim
 *
 */
public class DateUtil {
	/**
	 * 현재 시간 datetime형 문자열로 반환 
	 * @return datetime형식 문자열 (yyyy-MM-dd HH:mm:ss)
	 */
	public static String now() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
}
