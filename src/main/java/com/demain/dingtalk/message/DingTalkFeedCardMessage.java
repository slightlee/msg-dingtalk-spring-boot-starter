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
