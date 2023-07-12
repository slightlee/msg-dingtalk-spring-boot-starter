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

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getMessageUrl() {
		return messageUrl;
	}

	public void setMessageUrl(String messageUrl) {
		this.messageUrl = messageUrl;
	}

}
