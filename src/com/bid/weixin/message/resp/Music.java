package com.bid.weixin.message.resp;

/**
* ����: Music
* ����: ����model 
* ������Ա�� yyzeng
* ����ʱ�䣺  2017-2-14
* �����汾��V1.0  
 */
public class Music {
    // ���ֱ���
    private String Title;
    // ��������
    private String Description;
    // ��������
    private String MusicUrl;
    // �������������ӣ�WIFI��������ʹ�ø����Ӳ�������
    private String HQMusicUrl;
    // ����ͼ��ý��id��ͨ���ϴ���ý���ļ��õ���id
    private String ThumbMediaId;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getMusicUrl() {
        return MusicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        MusicUrl = musicUrl;
    }

    public String getHQMusicUrl() {
        return HQMusicUrl;
    }

    public void setHQMusicUrl(String musicUrl) {
        HQMusicUrl = musicUrl;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
}