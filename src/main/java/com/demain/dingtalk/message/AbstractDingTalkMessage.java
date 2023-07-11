package com.demain.dingtalk.message;

import com.demain.dingtalk.DingTalkParams;
import com.demain.dingtalk.enums.MessageTypeEnum;
import com.google.gson.Gson;

import java.util.Collections;
import java.util.HashSet;
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

	/**
	 * 添加被@的群成员手机号
	 * @param mobile 被@的群成员手机号
	 */
	public AbstractDingTalkMessage setAtMobiles(String... mobile) {
		Collections.addAll(mobiles, mobile);
		return this;
	}

	/**
	 * 添加被@的群成员userId
	 * @param userId 被@的群成员userId
	 */
	public AbstractDingTalkMessage setAtUserId(String... userId) {
		Collections.addAll(userIds, userId);
		return this;
	}

	/**
	 * 获取消息类型
	 */
	public abstract MessageTypeEnum getMsgType();

	/**
	 * 组装消息
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
