package com.demain.dingtalk;

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
