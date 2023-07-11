package com.demain.dingtalk.message;

import com.demain.dingtalk.DingTalkParams;
import com.demain.dingtalk.enums.MessageTypeEnum;

/**
 * 文本类型消息
 *
 * @author demain_lee
 * @since 0.0.1
 */
public class DingTalkTextMessage extends AbstractDingTalkMessage {

	/**
	 * 文本消息的内容
	 */
	private String content;

	@Override
	public MessageTypeEnum getMsgType() {
		return MessageTypeEnum.TEXT;
	}

	@Override
	public DingTalkParams generateParams(DingTalkParams params) {
		DingTalkParams.Text text = new DingTalkParams.Text();
		text.setContent(content);
		params.setText(text);
		return params;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
