package com.demain.dingtalk.message;

import com.demain.dingtalk.DingTalkParams;
import com.demain.dingtalk.enums.ActionBtnOrientationEnum;
import com.demain.dingtalk.enums.ActionHideAvatarEnum;
import com.demain.dingtalk.enums.MessageTypeEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * actionCard类型消息
 *
 * @author demain_lee
 * @since 0.0.1
 */
public class DingTalkActionCardMessage extends AbstractDingTalkMessage {

	/**
	 * 是否显示消息发送者头像 0-正常发消息者头像，1-隐藏发消息者头像 默认正常
	 */
	private String hideAvatar = ActionHideAvatarEnum.SHOW.getVal();

	/**
	 * 消息内按钮排列方式 0-按钮竖直排列，1-按钮横向排列 默认横向排列
	 */
	private String btnOrientation = ActionBtnOrientationEnum.HORIZONTAL.getVal();

	/**
	 * 点击singleTitle按钮触发的URL 消息内只有一个按钮时，该参数必填
	 */
	private String singleURL;

	/**
	 * 单个按钮的方案 (设置此项和singleURL后btns无效) 说明 消息内只有一个按钮时，该参数必填
	 */
	private String singleTitle;

	/**
	 * actionCard类型消息的正文内容，支持markdown语法
	 */
	private String text;

	/**
	 * 消息会话列表中展示的标题，非消息体的标题。
	 */
	private String title;

	/**
	 * 消息内不止一个按钮时，该参数必填 ，如果 btns 数量大于2 默认横向排列顺序会失效变成竖直排列
	 */
	private List<DingTalkParams.Button> btns = new ArrayList();

	/**
	 * 添加按钮 建议使用此方法添加按钮
	 * @param title 按钮标题
	 * @param actionURL 点击按钮触发的URL 添加按钮
	 */
	public DingTalkActionCardMessage addButton(String title, String actionURL) {
		DingTalkParams.Button button = new DingTalkParams.Button(title, actionURL);
		btns.add(button);
		return this;
	}

	/**
	 * 添加按钮 建议使用此方法添加按钮
	 * @param button 按钮
	 */
	public DingTalkActionCardMessage addButtons(DingTalkParams.Button... button) {
		btns.addAll(Arrays.asList(button));
		return this;
	}

	@Override
	public MessageTypeEnum getMsgType() {
		return MessageTypeEnum.ACTIONCARD;
	}

	@Override
	public DingTalkParams generateParams(DingTalkParams params) {

		DingTalkParams.ActionCard actionCard = new DingTalkParams.ActionCard();
		actionCard.setHideAvatar(hideAvatar);
		actionCard.setBtnOrientation(btnOrientation);
		actionCard.setText(text);
		actionCard.setTitle(title);
		/*
		 * singleTitle、singleURL 消息内只有一个按钮时，该参数必填
		 */
		if (btns.size() > 1) {
			actionCard.setBtns(btns);
		}
		else {
			actionCard.setSingleURL(singleURL);
			actionCard.setSingleTitle(singleTitle);
		}
		params.setActionCard(actionCard);
		return params;
	}

	/**
	 * @param text 消息内容
	 * @param title 消息标题
	 */
	public DingTalkActionCardMessage(String text, String title) {
		this.text = text;
		this.title = title;
	}

	/**
	 * @param singleURL 单个按钮的方案 (设置此项和singleURL后btns无效) 说明 消息内只有一个按钮时，该参数必填
	 * @param singleTitle 点击singleTitle按钮触发的URL 消息内只有一个按钮时，该参数必填
	 * @param text 消息内容
	 * @param title 消息标题
	 */
	public DingTalkActionCardMessage(String singleURL, String singleTitle, String text, String title) {
		this.singleURL = singleURL;
		this.singleTitle = singleTitle;
		this.text = text;
		this.title = title;
	}

	/**
	 * 此种方式不建议使用，建议使用 {@link #addButton(String, String)} 或
	 * {@link #addButtons(DingTalkParams.Button...)} 方式
	 * @param text 消息内容
	 * @param title 消息标题
	 * @param btns 消息内不止一个按钮时，该参数必填
	 */
	public DingTalkActionCardMessage(String text, String title, List<DingTalkParams.Button> btns) {
		this.text = text;
		this.title = title;
		this.btns = btns;
	}

	/**
	 * @param hideAvatar 是否显示消息发送者头像 0-正常发消息者头像，1-隐藏发消息者头像 默认正常
	 * @param btnOrientation 消息内按钮排列方式 0-按钮竖直排列，1-按钮横向排列 默认横向排列
	 * @param singleURL 点击singleTitle按钮触发的URL 消息内只有一个按钮时，该参数必填
	 * @param singleTitle 单个按钮的方案 (设置此项和singleURL后btns无效) 说明 消息内只有一个按钮时，该参数必填
	 * @param text 消息内容
	 * @param title 消息标题
	 */
	public DingTalkActionCardMessage(String hideAvatar, String btnOrientation, String singleURL, String singleTitle,
			String text, String title) {
		this.hideAvatar = hideAvatar;
		this.btnOrientation = btnOrientation;
		this.singleURL = singleURL;
		this.singleTitle = singleTitle;
		this.text = text;
		this.title = title;
	}

	/**
	 * @param isAtAll 是否@所有人
	 * @param hideAvatar 是否显示消息发送者头像 0-正常发消息者头像，1-隐藏发消息者头像 默认正常
	 * @param btnOrientation 消息内按钮排列方式 0-按钮竖直排列，1-按钮横向排列 默认横向排列
	 * @param text 消息内容
	 * @param title 消息标题
	 */
	public DingTalkActionCardMessage(boolean isAtAll, String hideAvatar, String btnOrientation, String text,
			String title) {
		super(isAtAll);
		this.hideAvatar = hideAvatar;
		this.btnOrientation = btnOrientation;
		this.text = text;
		this.title = title;
	}

	/**
	 * @param isAtAll 是否@所有人 actionCard类型消息@所有人无效
	 * @param hideAvatar 是否显示消息发送者头像 0-正常发消息者头像，1-隐藏发消息者头像 默认正常
	 * @param btnOrientation 消息内按钮排列方式 0-按钮竖直排列，1-按钮横向排列 默认横向排列
	 * @param singleURL 点击singleTitle按钮触发的URL 消息内只有一个按钮时，该参数必填
	 * @param singleTitle 单个按钮的方案 (设置此项和singleURL后btns无效) 说明 消息内只有一个按钮时，该参数必填
	 * @param text 消息内容
	 * @param title 消息标题
	 */
	public DingTalkActionCardMessage(boolean isAtAll, String hideAvatar, String btnOrientation, String singleURL,
			String singleTitle, String text, String title) {
		super(isAtAll);
		this.hideAvatar = hideAvatar;
		this.btnOrientation = btnOrientation;
		this.singleURL = singleURL;
		this.singleTitle = singleTitle;
		this.text = text;
		this.title = title;
	}

	/**
	 * @param mobiles 手机号码列表 actionCard类型消息@人无效
	 * @param userIds 用户id列表
	 * @param hideAvatar 是否显示消息发送者头像 0-正常发消息者头像，1-隐藏发消息者头像 默认正常
	 * @param btnOrientation 消息内按钮排列方式 0-按钮竖直排列，1-按钮横向排列 默认横向排列
	 * @param singleURL 点击singleTitle按钮触发的URL 消息内只有一个按钮时，该参数必填
	 * @param singleTitle 单个按钮的方案 (设置此项和singleURL后btns无效) 说明 消息内只有一个按钮时，该参数必填
	 * @param text 消息内容
	 * @param title 消息标题
	 */
	public DingTalkActionCardMessage(String[] mobiles, String[] userIds, String hideAvatar, String btnOrientation,
			String singleURL, String singleTitle, String text, String title) {
		super(mobiles, userIds);
		this.hideAvatar = hideAvatar;
		this.btnOrientation = btnOrientation;
		this.singleURL = singleURL;
		this.singleTitle = singleTitle;
		this.text = text;
		this.title = title;
	}

	/**
	 * @param mobiles 手机号码列表 actionCard类型消息@人无效
	 * @param userIds 用户id列表
	 * @param hideAvatar 是否显示消息发送者头像 0-正常发消息者头像，1-隐藏发消息者头像 默认正常
	 * @param btnOrientation 消息内按钮排列方式 0-按钮竖直排列，1-按钮横向排列 默认横向排列
	 * @param text 消息内容
	 * @param title 消息标题
	 */
	public DingTalkActionCardMessage(String[] mobiles, String[] userIds, String hideAvatar, String btnOrientation,
			String text, String title) {
		super(mobiles, userIds);
		this.hideAvatar = hideAvatar;
		this.btnOrientation = btnOrientation;
		this.text = text;
		this.title = title;
	}

}
