package com.bid.weixin.message.resp;
/**
* 类名: VoiceMessage
* 描述: 语音消息
* 开发人员： yyzeng
* 创建时间：  2017-2-14
* 发布版本：V1.0  
 */
public class VoiceMessage extends BaseMessage {
    // 语音
    private Voice Voice;

    public Voice getVoice() {
        return Voice;
    }

    public void setVoice(Voice voice) {
        Voice = voice;
    }
}