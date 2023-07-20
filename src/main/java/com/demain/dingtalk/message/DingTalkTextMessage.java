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
	private final String content;

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

	/**
	 * 设置文本消息的内容
	 * @param content 文本消息的内容
	 */
	public DingTalkTextMessage(String content) {
		this.content = content;
	}

	/**
	 * 设置文本消息的内容
	 * @param content 文本消息的内容
	 * @param isAtAll 是否@所有人
	 */
	public DingTalkTextMessage(String content, boolean isAtAll) {
		super(isAtAll);
		this.content = content;
	}

	/**
	 * 设置文本消息的内容
	 * @param content 文本消息的内容
	 * @param mobiles 被@的群成员手机号
	 * @param userIds 被@的群成员userId
	 */
	public DingTalkTextMessage(String content, String[] mobiles, String[] userIds) {
		super(mobiles, userIds);
		this.content = content;
	}

	/**
	 * 设置文本消息的内容
	 * @param content 文本消息的内容
	 * @param isAtAll 是否@所有人 如果 isAtAll 为 true，则忽略 mobiles 和 userIds
	 * @param mobiles 被@的群成员手机号
	 * @param userIds 被@的群成员userId
	 */
	public DingTalkTextMessage(String content, boolean isAtAll, String[] mobiles, String[] userIds) {
		super(isAtAll, mobiles, userIds);
		this.content = content;
	}

}
