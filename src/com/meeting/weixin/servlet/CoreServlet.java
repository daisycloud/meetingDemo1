package com.meeting.weixin.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meeting.weixin.util.SignUtil;
import com.meeting.weixin.service.CoreService;
/**
 * 类名: CoreServlet
 * 描述: 来接收微信服务器传来信息
 * 创建时间：2017-2-10 
 * 发布版本：V1.0 
 */
public class CoreServlet extends HttpServlet {
	 private static final long serialVersionUID = 4323197796926899691L;
	
	/**
     * 确认请求来自微信服务器
     */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			
			//微信加密签名
			String signature = request.getParameter("signature");
			//时间戳
			String timestamp = request.getParameter("timestamp");
			//随机数
			String nonce = request.getParameter("nonce");
			//随机字符串
			String echostr = request.getParameter("echostr");
			
			PrintWriter out = response.getWriter();
			
			//通过检验
			if( SignUtil.checkSignature(signature, timestamp, nonce)){
				out.print(echostr);
				System.out.println("验证通过");
			}else{
				System.out.println("验证不通过");
			}
					        
			out.close();
			out = null;
	}


	
	/*处理微信服务器发来的消息*/
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		System.out.println("POST");
		
        // 消息的接收、处理、响应
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 调用核心业务类接收消息、处理消息
        String respXml = CoreService.processRequest(request);

        // 响应消息
        PrintWriter out = response.getWriter();
        out.print(respXml);
        out.close();
    }
	
	
}
