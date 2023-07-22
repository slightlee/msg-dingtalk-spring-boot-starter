package com.demain.dingtalk;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 钉钉配置类
 *
 * @author demain_lee
 * @since 0.0.1
 */
@ConfigurationProperties(prefix = "msg.dingtalk")
public class DingTalkProperties {

	/**
	 * webhook地址
	 */
	private String url;

	/**
	 * 密钥
	 */
	private String secret;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

}
