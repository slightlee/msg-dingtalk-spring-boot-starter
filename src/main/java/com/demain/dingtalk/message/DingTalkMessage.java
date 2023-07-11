package com.demain.dingtalk.message;

/**
 * 钉钉消息接口
 *
 * @author demain_lee
 * @since 0.0.1
 */
public interface DingTalkMessage {

	/**
	 * 生成钉钉消息发送参数
	 * @return 钉钉文档要求的 jsonString
	 */
	String generateMsg();

}
