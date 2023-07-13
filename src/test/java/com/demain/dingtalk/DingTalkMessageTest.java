package com.demain.dingtalk;

import com.demain.dingtalk.markdown.MarkdownBuilder;
import com.demain.dingtalk.message.DingTalkLinkMessage;
import com.demain.dingtalk.message.DingTalkMarkdownMessage;
import com.demain.dingtalk.message.DingTalkTextMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 钉钉机器人消息测试
 *
 * @author demain_lee
 * @since 2023/7/13
 */
public class DingTalkMessageTest {

	DingTalkSend dingTalkSend;

	@BeforeEach
	void before() throws NoSuchAlgorithmException, InvalidKeyException {
		dingTalkSend = new DingTalkSend(
				"https://oapi.dingtalk.com/robot/send?access_token=1baa692fa0c8a2400a9b05da0aa35fa47d320455769c702e632af8ba56bfd874");
		dingTalkSend.setSecret("xxx");
	}

	/**
	 * 文本类型消息
	 */
	@Test
	public void dingTalkTEXTMessageSend() throws IOException {
		DingTalkTextMessage dingTalkTextMessage = new DingTalkTextMessage();
		dingTalkTextMessage.setContent("测试机器人监控报警消息通知999");
		// dingTalkTextMessage.setAtMobiles("176xxxxx");
		DingTalkResponse response = dingTalkSend.sendMessage(dingTalkTextMessage);
		System.out.println(response.toString());
		Assertions.assertTrue(response.isSuccess());
	}

	/**
	 * 链接类型消息
	 */
	@Test
	public void dingTalkLinkMessageSend() throws IOException {
		DingTalkLinkMessage dingTalkLinkMessage = new DingTalkLinkMessage();
		dingTalkLinkMessage.setText("测试机器人链接消息text");
		dingTalkLinkMessage.setTitle("测试机器人链接消息title");
		dingTalkLinkMessage.setPicUrl("https://www.baidu.com/img/bd_logo1.png");
		dingTalkLinkMessage.setMessageUrl("https://www.baidu.com");
		DingTalkResponse response = dingTalkSend.sendMessage(dingTalkLinkMessage);
		System.out.println(response.toString());
		Assertions.assertTrue(response.isSuccess());
	}

	/**
	 * markdown类型消息
	 */
	@Test
	public void dingTalkMarkDownMessageSend() throws IOException {
		DingTalkMarkdownMessage dingTalkMarkdownMessage = new DingTalkMarkdownMessage();
		dingTalkMarkdownMessage.setTitle("测试机器人markdown消息title");

		MarkdownBuilder markdownBuilder = new MarkdownBuilder();
		markdownBuilder.title1("一级标题");
		markdownBuilder.quote("引用换行引用换行引用换行引用换行引用换行引用换行");
		markdownBuilder.quoteBreak("22222222222引用换行引用换行引用换行引用换行引用换行引用换行");
		markdownBuilder.code("java",
				"\tpublic static void main(String[] args) {\n" + "\t\tSystem.out.println(\"Hello World!\");\n" + "\t}");
		String content = markdownBuilder.build();
		dingTalkMarkdownMessage.setText(content);
		DingTalkResponse response = dingTalkSend.sendMessage(dingTalkMarkdownMessage);
		System.out.println(response.toString());
		Assertions.assertTrue(response.isSuccess());
	}

}
