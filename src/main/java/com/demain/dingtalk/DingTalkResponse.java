package com.demain.dingtalk;

/*-
 * #%L
 * msg-dingtalk-spring-boot-starter
 * %%
 * Copyright (C) 2023 demain (lmm_work@163.com)
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

/**
 * 钉钉返回信息
 *
 * @author demain_lee
 * @since 0.0.1
 */
public class DingTalkResponse {

	public static final Long SUCCESS_CODE = 0L;

	public DingTalkResponse(String res) throws IOException {
		Map<?, ?> resMap = new ObjectMapper().readValue(res.getBytes(), Map.class);
		this.response = res;
		this.code = ((Number) resMap.get("errcode")).longValue();
		this.message = (String) resMap.get("errmsg");
		this.success = SUCCESS_CODE.equals(this.code);
	}

	public static DingTalkResponse of(String res) throws IOException {
		return new DingTalkResponse(res);
	}

	private final Long code;

	/**
	 * 值为ok表示无异常
	 */
	private final String message;

	/**
	 * 钉钉返回信息
	 */
	private final String response;

	/**
	 * 是否发送成功
	 */
	private final boolean success;

	@Override
	public String toString() {
		return response;
	}

	public Long getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String getResponse() {
		return response;
	}

	public boolean isSuccess() {
		return success;
	}

}
