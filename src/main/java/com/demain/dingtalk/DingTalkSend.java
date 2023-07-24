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

import com.demain.dingtalk.message.DingTalkMessage;
import com.sun.nio.sctp.IllegalReceiveException;
import okhttp3.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 钉钉消息发送
 *
 * @author demain_lee
 * @since 0.0.1
 */
public class DingTalkSend {

	/**
	 * 默认的请求发起客户端
	 */
	private static final OkHttpClient HTTP_CLIENT = new OkHttpClient.Builder().build();

	/**
	 * 请求content-type
	 */
	private static final MediaType MEDIA_TYPE = MediaType.parse("application/json");

	private final OkHttpClient client = HTTP_CLIENT;

	/**
	 * 请求路径
	 */
	private final String url;

	/**
	 * 密钥
	 */
	private String secret;

	private final Mac mac;

	public DingTalkSend(String url) throws NoSuchAlgorithmException {
		this.url = url;
		mac = Mac.getInstance("HmacSHA256");
	}

	/**
	 * 发送消息 根据参数值判断使用哪种发送方式
	 *
	 */
	public DingTalkResponse sendMessage(DingTalkMessage message) throws IOException {
		if (StringUtils.isEmpty(secret)) {
			return sendNormalMessage(message);
		}
		else {
			return sendSecretMessage(message);
		}
	}

	/**
	 * 未使用 加签 安全设置 直接发送
	 */
	public DingTalkResponse sendNormalMessage(DingTalkMessage message) throws IOException {
		return request(message, false);
	}

	/**
	 * 使用 加签 安全设置 发送
	 */
	public DingTalkResponse sendSecretMessage(DingTalkMessage message) throws IOException {
		return request(message, true);
	}

	/**
	 * 设置密钥
	 */
	public DingTalkSend setSecret(String secret) throws InvalidKeyException {
		if (StringUtils.isNoneBlank(secret)) {
			this.secret = secret;
			mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
		}
		return this;
	}

	/**
	 * 获取签名后的请求路径
	 * @param timestamp 当前时间戳
	 */
	public String secret(long timestamp) throws UnsupportedEncodingException {
		byte[] secretBytes = (timestamp + "\n" + secret).getBytes(StandardCharsets.UTF_8);
		byte[] signData = mac.doFinal(secretBytes);
		String sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)), "UTF-8");
		return String.format("%s&timestamp=%s&sign=%s", url, timestamp, sign);
	}

	/**
	 * 发起消息请求
	 * @param dingTalkMessage 消息内容
	 * @param isSecret 是否签名 true 签名
	 * @return java.lang.String
	 * @see <a href=
	 * "https://open.dingtalk.com/document/robots/customize-robot-security-settings">自定义机器人安全设置
	 * 签名、IP段</a>
	 */
	public DingTalkResponse request(DingTalkMessage dingTalkMessage, boolean isSecret) throws IOException {
		String message = dingTalkMessage.generateMsg();

		String requestUrl = isSecret ? secret(System.currentTimeMillis()) : getUrl();
		RequestBody requestBody = RequestBody.create(message, MEDIA_TYPE);

		Request request = new Request.Builder().url(requestUrl).post(requestBody).build();

		Call call = client.newCall(request);

		try (Response response = call.execute()) {
			ResponseBody responseBody = response.body();
			if (responseBody == null) {
				throw new IllegalReceiveException("钉钉发送消息接口返回值为 null!");
			}
			String dingTalkResponse = responseBody.string();
			return DingTalkResponse.of(dingTalkResponse);
		}
	}

	public String getUrl() {
		return url;
	}

}
