package com.bid.weixin.pojo;
/**
* ����: Token
* ����: ƾ֤
* ������Ա�� yyzeng
* ����ʱ�䣺  207-2-16
* �����汾��V1.0  
 */
public class Token {

	// �ӿڷ���ƾ֤
	private String accessToken;
	// ƾ֤��Ч�ڣ���λ��
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
