package com.edgc.common.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * Session 처리 관련 util class입니다.
 * 
 * @author MINHYEOK.KIM
 */
public class SessionUtil {
	/**
	 * 세션 attribute명에 해당하는 attribute를 반환합니다.
	 * @param name
	 * @return session object
	 * @throws Exception
	 */
	public static Object getAttribute(String name) throws Exception {
		return (Object)RequestContextHolder.getRequestAttributes().getAttribute(name, RequestAttributes.SCOPE_SESSION);
	}
	
	/**
	 * 세션 attribute를 설정합니다.
	 * @param name - 속성명
	 * @param object - 속성값
	 * @throws Exception
	 */
	public static void setAttribute(String name, Object object) throws Exception {
		RequestContextHolder.getRequestAttributes().setAttribute(name, object, RequestAttributes.SCOPE_SESSION);
	}
	
	/**
	 * 세션 attribute명에 해당하는 attribute를 삭제합니다. 
	 * @param name - attribute명
	 * @throws Exception
	 */
	public static void removeAttribute(String name) throws Exception {
		RequestContextHolder.getRequestAttributes().removeAttribute(name, RequestAttributes.SCOPE_SESSION);
	}
	
	/**
	 * session id를 반환합니다.
	 * @return session id
	 * @throws Exception
	 */
	public static String getSessionId() throws Exception {
		return RequestContextHolder.getRequestAttributes().getSessionId();
	}
}
