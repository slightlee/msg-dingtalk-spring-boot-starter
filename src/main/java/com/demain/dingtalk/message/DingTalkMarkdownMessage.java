package com.demain.dingtalk.message;

import com.demain.dingtalk.DingTalkParams;
import com.demain.dingtalk.enums.MessageTypeEnum;

/**
 * markdown类型消息
 *
 * @author demain_lee
 * @since 0.0.1
 */
public class DingTalkMarkdownMessage extends AbstractDingTalkMessage {

	/**
	 * 消息会话列表中展示的标题，非消息体的标题。
	 */
	private String title;

	/**
	 * markdown类型消息的文本内容
	 */
	private String text;

	@Override
	public MessageTypeEnum getMsgType() {
		return MessageTypeEnum.MARKDOWN;
	}

	@Override
	public DingTalkParams generateParams(DingTalkParams params) {
		DingTalkParams.Markdown markdown = new DingTalkParams.Markdown();
		markdown.setTitle(title);
		markdown.setText(text);
		params.setMarkdown(markdown);
		return params;
	}

	/**
	 * @param title 消息会话列表中展示的标题，非消息体的标题。
	 * @param text markdown类型消息的文本内容
	 */
	public DingTalkMarkdownMessage(String title, String text) {
		this.title = title;
		this.text = text;
	}

	/**
	 * @param isAtAll 是否@所有人
	 * @param title 消息会话列表中展示的标题，非消息体的标题。
	 * @param text markdown类型消息的文本内容
	 */
	public DingTalkMarkdownMessage(boolean isAtAll, String title, String text) {
		super(isAtAll);
		this.title = title;
		this.text = text;
	}

	/**
	 * 注：链接消息根据手机号、用户id@功能不生效！！！
	 * @param mobiles 手机号码列表
	 * @param userIds 用户id列表
	 * @param title 消息会话列表中展示的标题，非消息体的标题。
	 * @param text markdown类型消息的文本内容
	 */
	public DingTalkMarkdownMessage(String[] mobiles, String[] userIds, String title, String text) {
		super(mobiles, userIds);
		this.title = title;
		this.text = text;
	}

	/**
	 * 注：链接消息根据手机号、用户id@功能不生效！！！
	 * @param isAtAll 是否@所有人
	 * @param mobiles 手机号码列表
	 * @param userIds 用户id列表
	 * @param title 消息会话列表中展示的标题，非消息体的标题。
	 * @param text markdown类型消息的文本内容
	 */
	public DingTalkMarkdownMessage(boolean isAtAll, String[] mobiles, String[] userIds, String title, String text) {
		super(isAtAll, mobiles, userIds);
		this.title = title;
		this.text = text;
	}

}
