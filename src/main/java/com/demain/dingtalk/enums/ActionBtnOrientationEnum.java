package com.demain.dingtalk.enums;

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
