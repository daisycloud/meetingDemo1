package com.bid.weixin.util;

import com.bid.weixin.pojo.WeixinOauth2Token;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.bid.weixin.pojo.SNSUserInfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import sun.rmi.runtime.Log;
import sun.util.logging.resources.logging;




public class AdvancedUtil {
	/**
	 * ��ȡ��ҳ��Ȩƾ֤
	 * 
	 * @param appId �����˺ŵ�Ψһ��ʶ
	 * @param appSecret �����˺ŵ���Կ
	 * @param code
	 * @return WeixinAouth2Token
	 */
	 public static WeixinOauth2Token getOauth2AccessToken(String appId, String appSecret, String code) {
		WeixinOauth2Token wat = null;
		
		// ƴ�������ַ
		String requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
		requestUrl = requestUrl.replace("APPID", appId);
		requestUrl = requestUrl.replace("SECRET", appSecret);
		requestUrl = requestUrl.replace("CODE", code);
		// ��ȡ��ҳ��Ȩƾ֤
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
		if(null != jsonObject){
			try{
				wat = new WeixinOauth2Token();
				wat.setAccessToken(jsonObject.getString("access_token"));
				wat.setExpiresIn(jsonObject.getInt("expires_in"));
				wat.setRefreshToken(jsonObject.getString("refresh_token"));
				wat.setOpenId(jsonObject.getString("openid"));
				wat.setScope(jsonObject.getString("scope"));
			}catch(Exception e){
				wat = null;
				int errorCode = jsonObject.getInt("errocode");
				String erroMsg = jsonObject.getString("errmsg");
  				//log.error("��ȡ��ҳ��Ȩƾ֤ʧ�� errcode:{} erromsg:{}", erroCode, erroMsg);
				
			}
		}
		 return wat;
	}

	 /**
	     * ͨ����ҳ��Ȩ��ȡ�û���Ϣ
	     * 
	     * @param accessToken ��ҳ��Ȩ�ӿڵ���ƾ֤
	     * @param openId �û���ʶ
	     * @return SNSUserInfo
	     */

	 @SuppressWarnings( { "deprecation", "unchecked" })
	 public static SNSUserInfo getSNSUserInfo(String accessToken, String openId){
		 SNSUserInfo snsUserInfo = null;
		 // ƴ�������ַ
		 String requestUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";
		 requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
		 // ͨ����ҳ��Ȩ��ȡ�û���Ϣ
		 JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
		 
		 if(null != jsonObject){
			 try{
				 snsUserInfo = new SNSUserInfo();
				 // �û���ʶ
				 snsUserInfo.setOpenId(jsonObject.getString("openid"));
				 // �ǳ�
				 snsUserInfo.setNickname(jsonObject.getString("nickname"));
				 // �Ա�(1�����ԣ�2��Ů�ԣ�0��δ֪)
				 snsUserInfo.setSex(jsonObject.getInt("sex"));
				 // �û����ڹ���
				 snsUserInfo.setCountry(jsonObject.getString("country"));
				 // ����ʡ��
				 snsUserInfo.setProvince(jsonObject.getString("province"));
				 // ���ڳ���
				 snsUserInfo.setCity(jsonObject.getString("city"));
				 // �û�ͷ��
				 snsUserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
				 // �û���Ȩ��Ϣ
				 snsUserInfo.setPrivilegeList(JSONArray.toList(jsonObject.getJSONArray("privilege"), List.class));
			}catch(Exception e){
				snsUserInfo = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				//log.error("��ȡ�û���Ϣʧ�� errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		 }
		 
		 return snsUserInfo;
	 }
	 
	 /**
	     * ����https����
	     * 
	     * @param requestUrl �����ַ
	     * @param requestMethod ����ʽ��GET��POST��
	     * @param outputStr �ύ������
	     * @return JSONObject(ͨ��JSONObject.get(key)�ķ�ʽ��ȡjson���������ֵ)
	     */
	 
	 
	 
	 
	 
	 
	 
	 
}
