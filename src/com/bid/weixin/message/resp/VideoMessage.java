package com.bid.weixin.message.resp;

/**
* ����: VideoMessage
* ����: ��Ƶ��Ϣ
* ������Ա�� yyzeng
* ����ʱ�䣺  2017-2-14
* �����汾��V1.0  
 */
public class VideoMessage extends BaseMessage {
    // ��Ƶ
    private Video Video;

    public Video getVideo() {
        return Video;
    }

    public void setVideo(Video video) {
        Video = video;
    }
}