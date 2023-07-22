package com.demain.dingtalk;

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
