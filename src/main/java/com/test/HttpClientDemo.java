package com.test;//package com.Future_Demo;
//
//import com.sun.deploy.net.HttpResponse;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpStatus;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.util.EntityUtils;
//import sun.net.www.http.HttpClient;
//
//import java.io.UnsupportedEncodingException;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.List;
//import java.util.Map;
//
//public class HttpClientDemo {
//    public static void main(String args[]) {
//        String urlNameString = "https://api.weixin.qq.com/sns/userinfo?access_token=TOKEN&openid=OPENID";
//        urlNameString=urlNameString.replace("TOKEN", token);
//        urlNameString=urlNameString.replace("OPENID",openid);
//        String result="";
//        try {
//            // 根据地址获取请求
//            HttpGet request = new HttpGet(urlNameString);//这里发送get请求
//            // 获取当前客户端对象
//            HttpClient httpClient = new HttpClient();
//            // 通过请求对象获取响应对象
//            HttpResponse response = httpClient.execute(request);
//
//            // 判断网络连接状态码是否正常(0--200都数正常)
//            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//                result= EntityUtils.toString(response.getEntity(),"utf-8");
//            }
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return result;
//    }
//}
