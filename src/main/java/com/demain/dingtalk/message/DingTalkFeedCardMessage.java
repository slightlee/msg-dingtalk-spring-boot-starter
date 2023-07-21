package com.demain.dingtalk.message;

import com.demain.dingtalk.DingTalkParams;
import com.demain.dingtalk.enums.MessageTypeEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * feedCard类型消息
 *
 * @author demain_lee
 * @since 0.0.1
 */
public class DingTalkFeedCardMessage extends AbstractDingTalkMessage {

	private List<DingTalkParams.Links> lks = new ArrayList<>();

	/**
	 * 内容列表
	 */
	public DingTalkFeedCardMessage addLinks(String title, String messageURL, String picURL) {
		DingTalkParams.Links links = new DingTalkParams.Links(title, messageURL, picURL);
		lks.add(links);
		return this;
	}

	public DingTalkFeedCardMessage addLinks(List<DingTalkParams.Links> links) {
		lks.addAll(links);
		return this;
	}

	@Override
	public MessageTypeEnum getMsgType() {
		return MessageTypeEnum.FEEDCARD;
	}

	@Override
	public DingTalkParams generateParams(DingTalkParams params) {
		DingTalkParams.FeedCard feedCard = new DingTalkParams.FeedCard();
		feedCard.setLinks(lks);
		params.setFeedCard(feedCard);
		return params;
	}

}
