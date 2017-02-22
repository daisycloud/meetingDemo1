package com.bid.weixin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bid.weixin.pojo.SNSUserInfo;
import com.bid.weixin.pojo.WeixinOauth2Token;
import com.bid.weixin.util.AdvancedUtil;

/**
* ����: OAuthServlet
* ����: ��Ȩ��Ļص�������
* ����ʱ�䣺  2017-2-22
* �����汾��V1.0  
 */
 
public class OAuthServlet  extends HttpServlet {
	private static final long serialVersionUID  =  -1847238807216447030L;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		// �û�ͬ����Ȩ���ܻ�ȡ��code
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		
		// �û�ͬ����Ȩ
		if(!"authdeny".equals(code)){
			// ��ȡ��ҳ��Ȩaccess_token
			 WeixinOauth2Token weixinOauth2Token = AdvancedUtil.getOauth2AccessToken("wx66d0b73341fc520a", "192b9ccd6e2ac8c9ae90d7025404c379", code);
			// ��ҳ��Ȩ�ӿڷ���ƾ֤
			String accessToken = weixinOauth2Token.getAccessToken();
			// �û���ʶ
			String openId = weixinOauth2Token.getOpenId();
			// ��ȡ�û���Ϣ
			 SNSUserInfo snsUserInfo = AdvancedUtil.getSNSUserInfo(accessToken, openId);
			
			// ����Ҫ���ݵĲ���
			request.setAttribute("snsuserInof", snsUserInfo);
			request.setAttribute("state",state);
		}
		
		//��תindex.jsp
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
