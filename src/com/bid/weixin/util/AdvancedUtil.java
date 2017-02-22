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
	 * 获取网页授权凭证
	 * 
	 * @param appId 公众账号的唯一标识
	 * @param appSecret 公众账号的密钥
	 * @param code
	 * @return WeixinAouth2Token
	 */
	 public static WeixinOauth2Token getOauth2AccessToken(String appId, String appSecret, String code) {
		WeixinOauth2Token wat = null;
		
		// 拼接请求地址
		String requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
		requestUrl = requestUrl.replace("APPID", appId);
		requestUrl = requestUrl.replace("SECRET", appSecret);
		requestUrl = requestUrl.replace("CODE", code);
		// 获取网页授权凭证
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
  				//log.error("获取网页授权凭证失败 errcode:{} erromsg:{}", erroCode, erroMsg);
				
			}
		}
		 return wat;
	}

	 /**
	     * 通过网页授权获取用户信息
	     * 
	     * @param accessToken 网页授权接口调用凭证
	     * @param openId 用户标识
	     * @return SNSUserInfo
	     */

	 @SuppressWarnings( { "deprecation", "unchecked" })
	 public static SNSUserInfo getSNSUserInfo(String accessToken, String openId){
		 SNSUserInfo snsUserInfo = null;
		 // 拼接请求地址
		 String requestUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";
		 requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
		 // 通过网页授权获取用户信息
		 JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
		 
		 if(null != jsonObject){
			 try{
				 snsUserInfo = new SNSUserInfo();
				 // 用户标识
				 snsUserInfo.setOpenId(jsonObject.getString("openid"));
				 // 昵称
				 snsUserInfo.setNickname(jsonObject.getString("nickname"));
				 // 性别(1是男性，2是女性，0是未知)
				 snsUserInfo.setSex(jsonObject.getInt("sex"));
				 // 用户所在国家
				 snsUserInfo.setCountry(jsonObject.getString("country"));
				 // 所在省份
				 snsUserInfo.setProvince(jsonObject.getString("province"));
				 // 所在城市
				 snsUserInfo.setCity(jsonObject.getString("city"));
				 // 用户头像
				 snsUserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
				 // 用户特权信息
				 snsUserInfo.setPrivilegeList(JSONArray.toList(jsonObject.getJSONArray("privilege"), List.class));
			}catch(Exception e){
				snsUserInfo = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				//log.error("获取用户信息失败 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		 }
		 
		 return snsUserInfo;
	 }
	 
	 /**
	     * 发送https请求
	     * 
	     * @param requestUrl 请求地址
	     * @param requestMethod 请求方式（GET、POST）
	     * @param outputStr 提交的数据
	     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	     */
	 
	 
	 
	 
	 
	 
	 
	 
}
