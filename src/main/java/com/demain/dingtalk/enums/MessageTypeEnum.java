package com.demain.dingtalk.enums;

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

/**
 * 消息类型枚举
 *
 * @author demain_lee
 * @since 0.0.1
 * @see <a href=
 * "https://open.dingtalk.com/document/orgapp/custom-robots-send-group-messages">...</a>
 */
public enum MessageTypeEnum {

	/**
	 * 文本类型消息
	 */
	TEXT("text", "文本类型消息"),
	/**
	 * 链接类型消息
	 */
	LINK("link", "链接类型消息"),
	/**
	 * markdown类型消息
	 */
	MARKDOWN("markdown", "markdown类型消息"),
	/**
	 * actionCard类型消息
	 */
	ACTIONCARD("actionCard", "actionCard类型消息"),
	/**
	 * feedCard类型消息
	 */
	FEEDCARD("feedCard", "feedCard类型消息"),

	;

	/**
	 * 消息类型值
	 */
	private final String val;

	/**
	 * 消息类型描述
	 */
	private final String desc;

	MessageTypeEnum(String val, String desc) {
		this.val = val;
		this.desc = desc;
	}

	public String getVal() {
		return val;
	}

}
