package com.meeting.weixin.message.resp;

/**
* 类名: ImageMessage
* 描述: 图片消息
* 开发人员： yyzeng
* 创建时间：  2017-2-14
* 发布版本：V1.0  
 */

public class ImageMessage extends BaseMessage {
    
    private Image Image;

    public Image getImage() {
        return Image;
    }

    public void setImage(Image image) {
        Image = image;
    }
}
