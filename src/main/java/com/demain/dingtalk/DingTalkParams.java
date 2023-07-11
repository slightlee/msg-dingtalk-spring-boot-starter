package com.demain.dingtalk;

import java.util.List;

/**
 * 钉钉消息发送参数
 *
 * @author demain_lee
 * @since 0.0.1
 */
public class DingTalkParams {

	/**
	 * 消息类型
	 */
	private String msgtype;

	/**
	 * 文本类型消息
	 */
	private Text text;

	/**
	 * 被@的群成员信息
	 */
	private At at;

	/**
	 * 链接类型消息
	 */
	private Link link;

	/**
	 * markdown类型消息
	 */
	private Markdown markdown;

	/**
	 * actionCard类型消息
	 */
	private ActionCard actionCard;

	/**
	 * feedCard类型消息
	 */
	private FeedCard feedCard;

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	public At getAt() {
		return at;
	}

	public void setAt(At at) {
		this.at = at;
	}

	public Link getLink() {
		return link;
	}

	public void setLink(Link link) {
		this.link = link;
	}

	public Markdown getMarkdown() {
		return markdown;
	}

	public void setMarkdown(Markdown markdown) {
		this.markdown = markdown;
	}

	public ActionCard getActionCard() {
		return actionCard;
	}

	public void setActionCard(ActionCard actionCard) {
		this.actionCard = actionCard;
	}

	public FeedCard getFeedCard() {
		return feedCard;
	}

	public void setFeedCard(FeedCard feedCard) {
		this.feedCard = feedCard;
	}

	public static class Text {

		/**
		 * 文本消息的内容
		 */
		private String content;

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

	}

	public static class At {

		/**
		 * 是否@所有人 true 是 false 否
		 */
		private boolean isAtAll;

		/**
		 * 被@的群成员手机号
		 */
		private String[] atMobiles;

		/**
		 * 被@的群成员userId
		 */
		private String[] atUserIds;

		public boolean isAtAll() {
			return isAtAll;
		}

		public void setAtAll(boolean atAll) {
			isAtAll = atAll;
		}

		public String[] getAtMobiles() {
			return atMobiles;
		}

		public void setAtMobiles(String[] atMobiles) {
			this.atMobiles = atMobiles;
		}

		public String[] getAtUserIds() {
			return atUserIds;
		}

		public void setAtUserIds(String[] atUserIds) {
			this.atUserIds = atUserIds;
		}

	}

	public static class Link {

		/**
		 * 消息标题
		 */
		private String title;

		/**
		 * 消息内容。如果太长只会部分展示
		 */
		private String text;

		/**
		 * 点击消息跳转的URL
		 */
		private String messageUrl;

		/**
		 * 链接消息内的图片地址
		 */
		private String picUrl;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public String getMessageUrl() {
			return messageUrl;
		}

		public void setMessageUrl(String messageUrl) {
			this.messageUrl = messageUrl;
		}

		public String getPicUrl() {
			return picUrl;
		}

		public void setPicUrl(String picUrl) {
			this.picUrl = picUrl;
		}

	}

	public static class Markdown {

		/**
		 * 消息会话列表中展示的标题，非消息体的标题。
		 */
		private String title;

		/**
		 * markdown类型消息的文本内容
		 */
		private String text;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

	}

	public static class ActionCard {

		/**
		 * 是否显示消息发送者头像 0-正常发消息者头像，1-隐藏发消息者头像
		 */
		private String hideAvatar;

		/**
		 * 消息内按钮排列方式 0-按钮竖直排列，1-按钮横向排列
		 */
		private String btnOrientation;

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
		 * 消息内不止一个按钮时，该参数必填
		 */
		private List<Button> btns;

		public String getHideAvatar() {
			return hideAvatar;
		}

		public void setHideAvatar(String hideAvatar) {
			this.hideAvatar = hideAvatar;
		}

		public String getBtnOrientation() {
			return btnOrientation;
		}

		public void setBtnOrientation(String btnOrientation) {
			this.btnOrientation = btnOrientation;
		}

		public String getSingleURL() {
			return singleURL;
		}

		public void setSingleURL(String singleURL) {
			this.singleURL = singleURL;
		}

		public String getSingleTitle() {
			return singleTitle;
		}

		public void setSingleTitle(String singleTitle) {
			this.singleTitle = singleTitle;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public List<Button> getBtns() {
			return btns;
		}

		public void setBtns(List<Button> btns) {
			this.btns = btns;
		}

	}

	static class Button {

		/**
		 * 按钮上显示的文本
		 */
		private String title;

		/**
		 * 点击按钮触发的URL
		 */
		private String actionURL;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getActionURL() {
			return actionURL;
		}

		public void setActionURL(String actionURL) {
			this.actionURL = actionURL;
		}

	}

	static class FeedCard {

		/**
		 * feedCard消息的内容列表
		 */
		private List<Links> links;

		public List<Links> getLinks() {
			return links;
		}

		public void setLinks(List<Links> links) {
			this.links = links;
		}

	}

	static class Links {

		/**
		 * 消息会话列表中展示的标题，非消息体的标题。
		 */
		private String title;

		/**
		 * 消息点击链接地址，当发送消息为小程序时支持小程序跳转链接
		 */
		private String messageURL;

		/**
		 * 图片地址
		 */
		private String picURL;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getMessageURL() {
			return messageURL;
		}

		public void setMessageURL(String messageURL) {
			this.messageURL = messageURL;
		}

		public String getPicURL() {
			return picURL;
		}

		public void setPicURL(String picURL) {
			this.picURL = picURL;
		}

	}

}
