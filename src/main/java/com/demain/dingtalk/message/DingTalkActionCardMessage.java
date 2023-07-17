package com.demain.dingtalk.message;

import com.demain.dingtalk.DingTalkParams;
import com.demain.dingtalk.enums.ActionBtnOrientationEnum;
import com.demain.dingtalk.enums.ActionHideAvatarEnum;
import com.demain.dingtalk.enums.MessageTypeEnum;

import java.util.ArrayList;
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
     * 消息内不止一个按钮时，该参数必填
     */
    private List<DingTalkParams.Button> btns = new ArrayList();

    /**
     * 添加按钮
     */
    public DingTalkActionCardMessage addButton(String title, String actionURL) {
        DingTalkParams.Button button = new DingTalkParams.Button();
        button.setTitle(title);
        button.setActionURL(actionURL);
        btns.add(button);
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
        } else {
            actionCard.setSingleURL(singleURL);
            actionCard.setSingleTitle(singleTitle);
        }
        params.setActionCard(actionCard);
        return params;
    }

    public void setHideAvatar(String hideAvatar) {
        this.hideAvatar = hideAvatar;
    }

    public void setBtnOrientation(String btnOrientation) {
        this.btnOrientation = btnOrientation;
    }

    public void setSingleURL(String singleURL) {
        this.singleURL = singleURL;
    }

    public void setSingleTitle(String singleTitle) {
        this.singleTitle = singleTitle;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
