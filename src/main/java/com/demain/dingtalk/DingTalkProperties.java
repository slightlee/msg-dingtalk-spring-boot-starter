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
