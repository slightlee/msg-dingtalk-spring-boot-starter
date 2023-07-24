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
 * 消息内按钮排列方式 枚举
 *
 * @author demain_lee
 * @since 0.0.1
 * @see <a href=
 * "https://open.dingtalk.com/document/orgapp/custom-robots-send-group-messages">...</a>
 */
public enum ActionBtnOrientationEnum {

	/**
	 * 按钮竖向排列
	 */
	VERTICAL("0", "按钮竖向排列"),

	/**
	 * 按钮横向排列
	 */
	HORIZONTAL("1", "按钮横向排列"),

	;

	/**
	 * 排列方式值
	 */
	private final String val;

	/**
	 * 排列方式描述
	 */
	private final String desc;

	ActionBtnOrientationEnum(java.lang.String val, java.lang.String desc) {
		this.val = val;
		this.desc = desc;
	}

	public String getVal() {
		return val;
	}

}
