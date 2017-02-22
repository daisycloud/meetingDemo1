package com.bid.weixin.message.resp;

/**
* 类名: VideoMessage
* 描述: 视频消息
* 开发人员： yyzeng
* 创建时间：  2017-2-14
* 发布版本：V1.0  
 */
public class VideoMessage extends BaseMessage {
    // 视频
    private Video Video;

    public Video getVideo() {
        return Video;
    }

    public void setVideo(Video video) {
        Video = video;
    }
}