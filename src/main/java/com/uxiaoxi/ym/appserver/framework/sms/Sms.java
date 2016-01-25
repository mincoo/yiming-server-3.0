/**
 * TestSms.java
 */
package com.uxiaoxi.ym.appserver.framework.sms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.uxiaoxi.ym.appserver.framework.https.RequestClient;




/**
 * @author renhao
 *
 * 2015-1-12
 */
public class Sms {
    
    /**
     * 注册时 短信模版id
     * 
     * 【#company#】感谢您注册#app#，您的验证码是#code#
     * 
     */
    public static final Long  REGISTER_TPLID = 5l;
    
    /**
     * 找回密码时 短信模版id
     * 
     * 【#company#】正在找回密码，您的验证码是#code#
     */
    public static final Long  FINDPWD_TPLID = 7l;
    
    /**
     * 
     * 【#company#】您的验证码是#code#。如非本人操作，请忽略本短信
     * 
     * 修改手机时 短信模版id
     */
    public static final Long  CHANGEPHONE_TPLID = 2l;
    
    /**
     * appkey
     */
    private static final String APIKEY = "ac560542d11bbacca360edc08699c784";
    
    
    /**
     * 服务http地址
     */
    private static String BASE_URI = "http://yunpian.com";
    /**
     * 服务版本号
     */
    private static String VERSION = "v1";
    
    /**
     * 查账户信息的http地址
     */
    private static String URI_GET_USER_INFO = BASE_URI + "/" + VERSION + "/user/get.json";
    /**
     * 通用发送接口的http地址
     */
    private static String URI_SEND_SMS = BASE_URI + "/" + VERSION + "/sms/send.json";
    /**
     * 模板发送接口的http地址
     */
    private static String URI_TPL_SEND_SMS = BASE_URI + "/" + VERSION + "/sms/tpl_send.json";
    
    /**
     * 取账户信息
     * @return json格式字符串
     * @throws IOException 
     */
    public static String getUserInfo(String apikey) throws IOException{
        
        RequestClient client = new RequestClient();
        
        String res = client.callApiByGet(URI_GET_USER_INFO+"?apikey="+apikey);
        
//        JSONObject json;
//        
//        try {
//            json = new JSONObject(res);
//            
//            msg.setErrcode(json.getLong("errcode"));
//            msg.setErrmsg(json.getString("errmsg"));
//            
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
        
        return res;
        
        
    }
    /**
     * 发短信
     * @param apikey apikey
     * @param text　短信内容　
     * @param mobile　接受的手机号
     * @return json格式字符串
     * @throws IOException 
     */
    public static String sendSms(String text, String mobile) throws IOException{
        
        
        RequestClient client = new RequestClient();
        
        List<NameValuePair> params = new ArrayList<NameValuePair>();  
        params.add(new BasicNameValuePair("apikey", APIKEY));
        params.add(new BasicNameValuePair("text", text));  
        params.add(new BasicNameValuePair("mobile", mobile)); 
        
        String res = client.callApiByPost(URI_SEND_SMS,params);
        
        return res;
        
    }
    
    /**
     * 通过模板发送短信
     * @param apikey apikey
     * @param tpl_id　模板id
     * @param tpl_value　模板变量值　
     * @param mobile　接受的手机号
     * @return json格式字符串
     * @throws IOException 
     */
    public static String tplSendSms(long tpl_id, String tpl_value, String mobile) throws IOException{
       
        RequestClient client = new RequestClient();
        
        List<NameValuePair> params = new ArrayList<NameValuePair>();  
        params.add(new BasicNameValuePair("apikey", APIKEY));
        params.add(new BasicNameValuePair("tpl_id", String.valueOf(tpl_id)));  
        params.add(new BasicNameValuePair("tpl_value", tpl_value));  
        params.add(new BasicNameValuePair("mobile", mobile)); 
        
        String res = client.callApiByPost(URI_TPL_SEND_SMS,params);
        
        return res;
    }
    
    public static void main(String[] args) throws IOException {
        //修改为您要发送的手机号
        String mobile = "15010151186";
        
        /**************** 查账户信息调用示例 *****************/
//        System.out.println(TestSms.getUserInfo(apikey));
        
        /**************** 使用通用接口发短信 *****************/
        //设置您要发送的内容
//        String text = "您的验证码是1234【云片网】";
        //发短信调用示例
//        System.out.println(TestSms.sendSms(apikey, text, mobile));
        
        /**************** 使用模板接口发短信 *****************/
        //设置模板ID，如使用1号模板:您的验证码是#code#【#company#】
        long tpl_id=1;
        //设置对应的模板变量值
        String tpl_value="#code#=1234&#company#=艾曼德";
        //模板发送的调用示例
        System.out.println(Sms.tplSendSms(tpl_id, tpl_value, mobile));
    }
}
