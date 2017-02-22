package com.bid.weixin.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import com.bid.weixin.util.MyX509TrustManager;

public class TokenTest {

	 public static void main(String[] args) throws Exception {
		//�޸�appID��secret
	        String tokenUrl="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx66d0b73341fc520a&secret=192b9ccd6e2ac8c9ae90d7025404c379";
	        //��������
	        URL url = new URL(tokenUrl);
	        HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
	        
	        // ����SSLContext���󣬲�ʹ������ָ�������ι�������ʼ��
	        TrustManager[] tm = { new MyX509TrustManager() };
	        SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
	        sslContext.init(null, tm, new java.security.SecureRandom());
	        // ������SSLContext�����еõ�SSLSocketFactory����
	        SSLSocketFactory ssf = sslContext.getSocketFactory();
	        
	        httpUrlConn.setSSLSocketFactory(ssf);
	        httpUrlConn.setDoOutput(true);
	        httpUrlConn.setDoInput(true);
	        
	        // ��������ʽ��GET/POST��
	        httpUrlConn.setRequestMethod("GET");
	        
	        // ȡ��������
	        InputStream inputStream = httpUrlConn.getInputStream();
	        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
	        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
	        //��ȡ��Ӧ����
	        StringBuffer buffer = new StringBuffer();
	        String str = null;
	        while ((str = bufferedReader.readLine()) != null) {
	            buffer.append(str);
	        }
	        bufferedReader.close();
	        inputStreamReader.close();
	        // �ͷ���Դ
	        inputStream.close();
	        httpUrlConn.disconnect();
	        //������ؽ��
	        System.out.println(buffer);
	}
}
