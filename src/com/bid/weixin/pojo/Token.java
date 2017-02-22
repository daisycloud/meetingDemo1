package com.bid.weixin.pojo;
/**
* 类名: Token
* 描述: 凭证
* 开发人员： yyzeng
* 创建时间：  207-2-16
* 发布版本：V1.0  
 */
public class Token {

	// 接口访问凭证
	private String accessToken;
	// 凭证有效期，单位秒
	private int expiresIn;
	
	public String getAccessToken(){
		return accessToken;
	}
	 
	public void setAccessToken(String accessToken) {
	        this.accessToken = accessToken;
	  }
	
	public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}
