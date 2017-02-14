package com.meeting.weixin.message.req;

/**
* 类名: VideoMessage
* 描述: 请求消息之视频消息
* 创建时间：2017-2-13
* 发布版本：V1.0
 */

public class VideoMessage  extends BaseMessage{

	 // 媒体ID
    private String MediaId;
    // 视频格式
    private String ThumbMediaId;

    public String getMediaId() {
        return MediaId;
    }
    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
    public String getThumbMediaId() {
        return ThumbMediaId;
    }
    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
    
}
