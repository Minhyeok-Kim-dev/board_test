package com.edgc.common.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 날짜 처리 관련 util class
 * @author Minhyeok Kim
 *
 */
public class DateUtil {
	/**
	 * now
	 * 
	 * 현재 시간 datetime형 문자열로 반환 
	 * @return datetime형식 문자열 (yyyy-MM-dd HH:mm:ss)
	 */
	public static String now() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
	
	/**
	 * now
	 * 
	 * 현재 시간 pattern 적용 문자열로 반환 
	 * @return pattern 적용 문자열 (ex: yyyyMMdd)
	 */
	public static String now(String pattern) {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
	}
}
