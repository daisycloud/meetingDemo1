package com.meeting.weixin.message.resp;
/**
* ����: Video
* ����: ��Ƶmodel 
* ������Ա�� yyzeng
* ����ʱ�䣺  2017-2-14
* �����汾��V1.0  
 */
public class Video {
    // ý���ļ�id
    private String MediaId;
    // ����ͼ��ý��id
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