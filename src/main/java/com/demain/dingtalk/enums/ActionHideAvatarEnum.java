package com.demain.dingtalk.enums;

/**
 * 是否显示消息发送者头像 枚举
 *
 * @author demain_lee
 * @since 0.0.1
 * @see <a href=
 * "https://open.dingtalk.com/document/orgapp/custom-robots-send-group-messages">...</a>
 */
public enum ActionHideAvatarEnum {

	/**
	 * 正常发消息者头像
	 */
	SHOW("0", "正常发消息者头像"),

	/**
	 * 隐藏发消息者头像
	 */
	HIDE("1", "隐藏发消息者头像"),

	;

	/**
	 * 是否显示值
	 */
	private final String val;

	/**
	 * 排列方式描述
	 */
	private final String desc;

	ActionHideAvatarEnum(String val, String desc) {
		this.val = val;
		this.desc = desc;
	}

	public String getVal() {
		return val;
	}

}
