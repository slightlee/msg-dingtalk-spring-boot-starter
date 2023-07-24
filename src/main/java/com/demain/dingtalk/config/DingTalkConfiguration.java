package com.demain.dingtalk.config;

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

import com.demain.dingtalk.DingTalkProperties;
import com.demain.dingtalk.DingTalkSend;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Ø 自动配置类
 *
 * @author demain_lee
 * @since 0.0.1
 */
@Configuration
@EnableConfigurationProperties(DingTalkProperties.class)
public class DingTalkConfiguration {

	private final DingTalkProperties dingTalkProperties;

	public DingTalkConfiguration(DingTalkProperties dingTalkProperties) {
		this.dingTalkProperties = dingTalkProperties;
	}

	@Bean
	@ConditionalOnMissingBean
	public DingTalkSend getDingTalkSend() throws NoSuchAlgorithmException, InvalidKeyException {
		return new DingTalkSend(dingTalkProperties.getUrl()).setSecret(dingTalkProperties.getSecret());
	}

}
