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

import com.demain.dingtalk.config.DingTalkConfiguration;
import com.demain.dingtalk.message.DingTalkTextMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * 钉钉消息发送测试
 *
 * @author demain_lee
 * @since 0.0.1
 */
@SpringBootTest(classes = { DingTalkConfiguration.class })
public class ConfigurationDingTalkMessageTest {

	private final DingTalkSend dingTalkSend;

	@Autowired
	public ConfigurationDingTalkMessageTest(DingTalkSend dingTalkSend) {
		this.dingTalkSend = dingTalkSend;
	}

	@Test
	void dingTalkTEXTMessageSend() throws IOException {
		DingTalkTextMessage dingTalkTextMessage1 = new DingTalkTextMessage("文本通知消息1");
		DingTalkResponse response = dingTalkSend.sendMessage(dingTalkTextMessage1);
		System.out.println(response.toString());
		Assertions.assertTrue(response.isSuccess());
	}

}
