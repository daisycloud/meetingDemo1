package com.meeting.weixin.message.resp;

/**
* 类名: TextMessage 
* 描述: 文本消息
* 创建时间：2017-2-13
* 发布版本：V1.0
 */

public class TextMessage extends BaseMessage {
	
	 // 回复的消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
