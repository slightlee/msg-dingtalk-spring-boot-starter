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
