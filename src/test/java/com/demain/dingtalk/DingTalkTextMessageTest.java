package com.demain.dingtalk;

import com.demain.dingtalk.message.DingTalkTextMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 钉钉机器人文本消息测试
 *
 * @author demain_lee
 * @since 0.0.1
 */
public class DingTalkTextMessageTest {

	DingTalkSend dingTalkSend;

	@BeforeEach
	void before() throws NoSuchAlgorithmException, InvalidKeyException {
		dingTalkSend = new DingTalkSend(
				"https://oapi.dingtalk.com/robot/send?access_token=1baa692fa0c8a2400a9b05da0aa35fa47d320455769c702e632af8ba56bfd874");
		dingTalkSend.setSecret("xxxxxx");
	}

	@Test
	public void send() throws IOException {
		DingTalkTextMessage dingTalkTextMessage = new DingTalkTextMessage();
		dingTalkTextMessage.setContent("测试机器人监控报警消息通知999");
		// dingTalkTextMessage.setAtMobiles("176xxxxx");
		DingTalkResponse response = dingTalkSend.sendMessage(dingTalkTextMessage);
		System.out.println(response.toString());
		Assertions.assertTrue(response.isSuccess());
	}

}
