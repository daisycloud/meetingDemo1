package com.bid.weixin.message.resp;

/**
* ����: MusicMessage </br>
* ����: ������Ϣ </br>
* ������Ա�� yyzeng
* ����ʱ�䣺  2017-2-14
* �����汾��V1.0  
 */
public class MusicMessage extends BaseMessage {
    // ����
    private Music Music;

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        Music = music;
    }
}