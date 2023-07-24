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
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * 钉钉消息抽象类
 *
 * @author demain_lee
 * @since 0.0.1
 */
public abstract class AbstractDingTalkMessage implements DingTalkMessage {

	/**
	 * 是否@所有人 默认 false
	 */
	private boolean isAtAll = false;

	/**
	 * 被@的群成员手机号
	 */
	private final Set<String> mobiles = new HashSet<>();

	/**
	 * 被@的群成员userId
	 */
	private final Set<String> userIds = new HashSet<>();

	public AbstractDingTalkMessage() {
	}

	/**
	 * @param isAtAll 是否@所有人
	 */
	public AbstractDingTalkMessage(boolean isAtAll) {
		this.isAtAll = isAtAll;
	}

	/**
	 * @param mobiles 被@的群成员手机号
	 * @param userIds 被@的群成员userId
	 */
	public AbstractDingTalkMessage(String[] mobiles, String[] userIds) {
		Optional.ofNullable(mobiles).map(Arrays::asList).ifPresent(this.mobiles::addAll);
		Optional.ofNullable(userIds).map(Arrays::asList).ifPresent(this.userIds::addAll);
	}

	/**
	 * @param isAtAll 是否@所有人
	 * @param mobiles 被@的群成员手机号
	 * @param userIds 被@的群成员userId
	 */
	public AbstractDingTalkMessage(boolean isAtAll, String[] mobiles, String[] userIds) {
		this.isAtAll = isAtAll;
		Optional.ofNullable(mobiles).map(Arrays::asList).ifPresent(this.mobiles::addAll);
		Optional.ofNullable(userIds).map(Arrays::asList).ifPresent(this.userIds::addAll);
	}

	/**
	 * 获取消息类型
	 * @return 消息类型
	 */
	public abstract MessageTypeEnum getMsgType();

	/**
	 * 组装消息
	 * @param params 钉钉消息发送参数
	 * @return 钉钉消息发送参数
	 */
	public abstract DingTalkParams generateParams(DingTalkParams params);

	@Override
	public String generateMsg() {

		DingTalkParams.At at = new DingTalkParams.At();
		at.setAtAll(isAtAll);
		at.setAtMobiles(mobiles.toArray(new String[0]));
		at.setAtUserIds(userIds.toArray(new String[0]));

		DingTalkParams dingTalkParams = new DingTalkParams();
		dingTalkParams.setMsgtype(getMsgType().getVal());
		dingTalkParams.setAt(at);

		DingTalkParams params = generateParams(dingTalkParams);
		return new Gson().toJson(params);
	}

}
