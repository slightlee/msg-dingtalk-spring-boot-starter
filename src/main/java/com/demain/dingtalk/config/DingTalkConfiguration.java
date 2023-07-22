package com.demain.dingtalk.config;

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
