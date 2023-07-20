package com.demain.dingtalk.message;

import com.demain.dingtalk.DingTalkParams;
import com.demain.dingtalk.enums.MessageTypeEnum;

/**
 * 链接类型消息
 *
 * @author demain_lee
 * @since 0.0.1
 */
public class DingTalkLinkMessage extends AbstractDingTalkMessage {

	/**
	 * 链接消息的标题
	 */
	private String title;

	/**
	 * 链接消息的内容
	 */
	private String text;

	/**
	 * 链接消息的图片URL
	 */
	private String picUrl;

	/**
	 * 点击消息跳转的URL
	 */
	private String messageUrl;

	@Override
	public MessageTypeEnum getMsgType() {
		return MessageTypeEnum.LINK;
	}

	@Override
	public DingTalkParams generateParams(DingTalkParams params) {
		DingTalkParams.Link link = new DingTalkParams.Link();
		link.setTitle(title);
		link.setText(text);
		link.setPicUrl(picUrl);
		link.setMessageUrl(messageUrl);
		params.setLink(link);
		return params;
	}

	/**
	 * @param title 链接消息的标题
	 * @param text 链接消息的内容
	 * @param picUrl 链接消息的图片URL
	 * @param messageUrl 点击消息跳转的URL
	 */
	public DingTalkLinkMessage(String title, String text, String picUrl, String messageUrl) {
		this.title = title;
		this.text = text;
		this.picUrl = picUrl;
		this.messageUrl = messageUrl;
	}

	/**
	 * 注：链接消息@功能不生效！！！
	 * @param isAtAll 是否@所有人
	 * @param title 链接消息的标题
	 * @param text 链接消息的内容
	 * @param picUrl 链接消息的图片URL
	 * @param messageUrl 点击消息跳转的URL
	 */
	public DingTalkLinkMessage(boolean isAtAll, String title, String text, String picUrl, String messageUrl) {
		super(isAtAll);
		this.title = title;
		this.text = text;
		this.picUrl = picUrl;
		this.messageUrl = messageUrl;
	}

	/**
	 * 注：链接消息@功能不生效！！！
	 * @param mobiles 被@的群成员手机号
	 * @param userIds 被@的群成员userId
	 * @param title 链接消息的标题
	 * @param text 链接消息的内容
	 * @param picUrl 链接消息的图片URL
	 * @param messageUrl 点击消息跳转的URL
	 */
	public DingTalkLinkMessage(String[] mobiles, String[] userIds, String title, String text, String picUrl,
			String messageUrl) {
		super(mobiles, userIds);
		this.title = title;
		this.text = text;
		this.picUrl = picUrl;
		this.messageUrl = messageUrl;
	}

	/**
	 * 注：链接消息@功能不生效！！！
	 * @param isAtAll 是否@所有人
	 * @param mobiles 被@的群成员手机号
	 * @param userIds 被@的群成员userId
	 * @param title 链接消息的标题
	 * @param text 链接消息的内容
	 * @param picUrl 链接消息的图片URL
	 * @param messageUrl 点击消息跳转的URL
	 */
	public DingTalkLinkMessage(boolean isAtAll, String[] mobiles, String[] userIds, String title, String text,
			String picUrl, String messageUrl) {
		super(isAtAll, mobiles, userIds);
		this.title = title;
		this.text = text;
		this.picUrl = picUrl;
		this.messageUrl = messageUrl;
	}

}
