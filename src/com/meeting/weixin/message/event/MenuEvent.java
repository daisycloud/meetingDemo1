package com.meeting.weixin.message.event;

/**
* 类名: MenuEvent 
* 描述: 自定义菜单事件
* 创建时间：2017-2-13
* 发布版本：V1.0
 */

public class MenuEvent  extends BaseEvent {

	 // 事件KEY值，与自定义菜单接口中KEY值对应
	private String EventKey;
	
	public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }
	
}
