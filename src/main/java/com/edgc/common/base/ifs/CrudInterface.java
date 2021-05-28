package com.edgc.common.base.ifs;

import com.edgc.common.base.model.network.Header;
import com.edgc.common.base.model.network.request.BaseApiRequest;
import com.edgc.common.base.model.network.response.BaseApiResponse;

/**
 * CRUD interface입니다.
 * - return, parameter type은 Custom Header 클래스로 설정하였습니다.
 * - 프로젝트 특성에 따라 Header class 내용을 변경하며 사용할 수 있습니다.
 *     
 *
 * @author MINHYEOK.KIM
 *
 * @param <Req> BaseApiRequest 기반 class type 
 * @param <Res> BaseApiResponse 기반 class type
 */
public interface CrudInterface<Req extends BaseApiRequest, Res extends BaseApiResponse> {
	/*
	 * CRUD - default methods
	 */
	Header<Res> create(Header<Req> request);
	
	Header<Res> read(Long id);
	
	Header<Res> update(Header<Req> request);
	
	Header<Res> delete(Long id);
	
	/*
	 * custom methods
	 */
	Header<Res> readList(Header<Req> request);
}
