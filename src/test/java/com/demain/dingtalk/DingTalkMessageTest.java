package com.demain.dingtalk;

import com.demain.dingtalk.markdown.MarkdownBuilder;
import com.demain.dingtalk.message.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

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
		dingTalkSend.setSecret("SECbf85ca4ffb1d519c21619d08f1be72c9ba1675b1b8fda2ca0c1385788ffef486");
	}

	/**
	 * 文本类型消息
	 */
	@Test
	public void dingTalkTEXTMessageSend() throws IOException {
		DingTalkTextMessage dingTalkTextMessage1 = new DingTalkTextMessage("文本通知消息1");
		DingTalkTextMessage dingTalkTextMessage2 = new DingTalkTextMessage("文本通知消息2", true);
		DingTalkTextMessage dingTalkTextMessage3 = new DingTalkTextMessage("文本通知消息3", null, null);
		DingTalkTextMessage dingTalkTextMessage4 = new DingTalkTextMessage("文本通知消息4", true, null, null);
		String[] mobiles = { "176xxxx" };
		DingTalkTextMessage dingTalkTextMessage5 = new DingTalkTextMessage("文本通知消息5", true, mobiles, null);
		DingTalkResponse response = dingTalkSend.sendMessage(dingTalkTextMessage4);
		System.out.println(response.toString());
		Assertions.assertTrue(response.isSuccess());
	}

	/**
	 * 链接类型消息
	 */
	@Test
	public void dingTalkLinkMessageSend() throws IOException {
		DingTalkLinkMessage dingTalkLinkMessage1 = new DingTalkLinkMessage("链接消息1-title", "链接消息1-text",
				"https://www.baidu.com/img/bd_logo1.png", "https://www.baidu.com");
		DingTalkLinkMessage dingTalkLinkMessage2 = new DingTalkLinkMessage(true, "链接消息2-title", "链接消息2-text",
				"https://www.baidu.com/img/bd_logo1.png", "https://www.baidu.com");
		String[] mobiles = { "176xxx" };
		DingTalkLinkMessage dingTalkLinkMessage3 = new DingTalkLinkMessage(mobiles, null, "链接消息3-title", "链接消息3-text",
				"https://www.baidu.com/img/bd_logo1.png", "https://www.baidu.com");
		DingTalkLinkMessage dingTalkLinkMessage4 = new DingTalkLinkMessage(true, mobiles, null, "链接消息4-title",
				"链接消息4-text", "https://www.baidu.com/img/bd_logo1.png", "https://www.baidu.com");
		DingTalkResponse response = dingTalkSend.sendMessage(dingTalkLinkMessage4);
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

	/**
	 * actionCard类型消息
	 */
	@Test
	public void dingTalkActionCardMessageSend() throws IOException {
		DingTalkActionCardMessage dingTalkActionCardMessage = new DingTalkActionCardMessage();
		dingTalkActionCardMessage.setTitle("测试机器人天气消息推送");
		MarkdownBuilder markdownBuilder = new MarkdownBuilder();
		markdownBuilder.title1("天气消息推送");
		markdownBuilder.quoteBreak();
		markdownBuilder.forceLineBreak();
		markdownBuilder.append("北京  /  晴  /  23~35℃  /  南风<3级");
		markdownBuilder.quoteBreak();
		markdownBuilder.forceLineBreak();
		markdownBuilder.append(
				"![screenshot](https://pics4.baidu.com/feed/63d9f2d3572c11df898d5232d0111fdcf703c202.jpeg@f_auto?token=e30872960cc8a8007a8606949dd1b805)");
		String content = markdownBuilder.build();
		dingTalkActionCardMessage.setText(content);
		dingTalkActionCardMessage.setSingleTitle("单按钮标题");
		dingTalkActionCardMessage.setSingleURL("https://www.baidu.com");
		dingTalkActionCardMessage.addButton("按钮1",
				"https://weathernew.pae.baidu.com/weathernew/pc?query=%E5%8C%97%E4%BA%AC%E5%A4%A9%E6%B0%94&srcid=4982&forecast=long_day_forecast");
		dingTalkActionCardMessage.addButton("按钮2", "https://www.baidu.com");
		DingTalkResponse response = dingTalkSend.sendMessage(dingTalkActionCardMessage);
		System.out.println(response.toString());
		Assertions.assertTrue(response.isSuccess());

	}

	/**
	 * feeCard类型消息
	 */
	@Test
	public void dingTalkFeedCardMessageSend() throws IOException {
		DingTalkFeedCardMessage dingTalkFeedCardMessage = new DingTalkFeedCardMessage();
		// dingTalkFeedCardMessage.addLinks("测试机器人消息推送1", "https://www.baidu.com",
		// "https://www.baidu.com/img/bd_logo1.png");
		// dingTalkFeedCardMessage.addLinks("测试机器人消息推送2", "https://www.baidu.com",
		// "https://www.baidu.com/img/bd_logo1.png");

		List<DingTalkParams.Links> links = new ArrayList<>();
		links.add(new DingTalkParams.Links("测试机器人消息推送3", "https://www.baidu.com",
				"https://www.baidu.com/img/bd_logo1.png"));
		links.add(new DingTalkParams.Links("测试机器人消息推送4", "https://www.baidu.com",
				"https://www.baidu.com/img/bd_logo1.png"));
		dingTalkFeedCardMessage.addLinks(links);

		DingTalkResponse response = dingTalkSend.sendMessage(dingTalkFeedCardMessage);
		Assertions.assertTrue(response.isSuccess());
	}

}
