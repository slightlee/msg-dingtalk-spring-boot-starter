package com.demain.dingtalk.enums;

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
