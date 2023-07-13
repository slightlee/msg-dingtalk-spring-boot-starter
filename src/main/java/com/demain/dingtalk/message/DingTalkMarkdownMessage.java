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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
