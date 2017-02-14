package com.meeting.weixin.message.req;

/**
* 类名: VoiceMessage
* 描述: 请求消息之语音消息
* 创建时间：2017-2-13
* 发布版本：V1.0
 */

public class VoiceMessage extends BaseMessage {

	 // 媒体ID
    private String MediaId;
    // 语音格式
    private String Format;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }
    
}
