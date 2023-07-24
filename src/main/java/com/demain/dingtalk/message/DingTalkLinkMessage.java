package com.demain.dingtalk.message;

/*-
 * #%L
 * msg-dingtalk-spring-boot-starter
 * %%
 * Copyright (C) 2023 demain (lmm_work@163.com)
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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
