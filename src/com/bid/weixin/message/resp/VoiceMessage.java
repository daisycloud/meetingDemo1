package com.bid.weixin.message.resp;
/**
* ����: VoiceMessage
* ����: ������Ϣ
* ������Ա�� yyzeng
* ����ʱ�䣺  2017-2-14
* �����汾��V1.0  
 */
public class VoiceMessage extends BaseMessage {
    // ����
    private Voice Voice;

    public Voice getVoice() {
        return Voice;
    }

    public void setVoice(Voice voice) {
        Voice = voice;
    }
}