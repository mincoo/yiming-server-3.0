/**
 * TestSms.java
 */
package com.uxiaoxi.ym.appserver.sms;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.uxiaoxi.ym.appserver.framework.https.RequestClient;




/**
 * @author renhao
 *
 * 2015-1-12
 */
public class TestSms {

    /**
     * 服务http地址 
     */
    private static String BASE_URI = "http://yunpian.com";
    /**
     * 服务版本号
     */
    private static String VERSION = "v1";
    
    /**
     * 编码格式
     */
    private static String ENCODING = "UTF-8";
    
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
    public static String sendSms(String apikey, String text, String mobile) throws IOException{
        
        
        RequestClient client = new RequestClient();
        
        List<NameValuePair> params = new ArrayList<NameValuePair>();  
        params.add(new BasicNameValuePair("apikey", apikey));
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
    public static String tplSendSms(String apikey, long tpl_id, String tpl_value, String mobile) throws IOException{
       
        RequestClient client = new RequestClient();
        
        List<NameValuePair> params = new ArrayList<NameValuePair>();  
        params.add(new BasicNameValuePair("apikey", apikey));
        params.add(new BasicNameValuePair("tpl_id", String.valueOf(tpl_id)));  
        params.add(new BasicNameValuePair("tpl_value", tpl_value));  
        params.add(new BasicNameValuePair("mobile", mobile)); 
        
        String res = client.callApiByPost(URI_TPL_SEND_SMS,params);
        
        return res;
    }
    
    public static void main(String[] args) throws IOException {
        //修改为您的apikey
//        String apikey = "ac560542d11bbacca360edc08699c784";
        
        String apikey = "e422559cdf4b1059751031b2c128edb1";
        
        //修改为您要发送的手机号
        String mobile = "";
        
        /**************** 查账户信息调用示例 *****************/
//        System.out.println(TestSms.getUserInfo(apikey));
        
        /**************** 使用通用接口发短信 *****************/
        //设置您要发送的内容
//        String text = "您的验证码是1234【云片网】";
        //发短信调用示例
//        System.out.println(TestSms.sendSms(apikey, text, mobile));
        
        /**************** 使用模板接口发短信 *****************/
        //设置模板ID，如使用1号模板:您的验证码是#code#【#company#】
        long tpl_id=764973l;
        //设置对应的模板变量值
//        String tpl_value="#code#=1234&#company#=艾曼德";
        //模板发送的调用示例
//        System.out.println(TestSms.tplSendSms(apikey, tpl_id, "#1#=1", mobile));
//        String text = "【研修班组委会】尊敬的参会代表，您好！2015唐山市中小学校长“教育改革与创新”高级研修班25日的报道时间为早7:00——8:00（西山口大舞台），大会议程及通知通过易明校信APP传达，请务必安装。下载链接http://fir.im/ymxx。用户名为您的手机号，密码123456";
        
//        String text = "【研修班组委会】尊敬的参会代表，您好！明德气象站提醒您关注天气变化：会议期间（4.25—4.26），唐山气温较高，平均温度 30℃/15℃，25日的报到时间为早7:00——8:00（西山口大舞台），大会议程及通知通过易明校信APP传达，请务必安装。下载链接http://fir.im/ymxx。用户名为您的手机号，密码123456";
        String text = "【世纪明德】通知：高校代表会时间： 4月26日本周日18：30—20：00，地点：清华科技园创新大厦A座二楼会议室。收到请回复姓名致阎莉手机15210150706，晚安~";


        
        File file = new File("D:/dxmd.xlsx");
      FileInputStream in = new FileInputStream(file);
      int n =1 ;
      try {
        Workbook wb = WorkbookFactory.create(in);
        Sheet sheet = wb.getSheetAt(0);
        int i = 1;
        Row row = sheet.getRow(i);
        StringBuffer b = new StringBuffer();
        while (row != null && StringUtils.isNotBlank(TestSms.getStringCellValue(row.getCell(1)))) {
            b.append(TestSms.getStringCellValue(row.getCell(1)));
            if(n < 100 && sheet.getRow(i+1)!= null && StringUtils.isNotBlank(TestSms.getStringCellValue( sheet.getRow(i+1).getCell(1)))) {
                b.append(",");
                n++;
            } else {
                n=1;
                System.out.println(TestSms.sendSms(apikey,text, b.toString()));
//                System.out.println( b.toString());
                b = new StringBuffer();
            }
            
            i++;
            row = sheet.getRow(i);
        }
        
        
    } catch (InvalidFormatException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
      
//        System.out.println(TestSms.sendSms(apikey,text, mobile));
    }

    
    // 
    public static String getStringCellValue(Cell cell) {

        String value = null;
        if (cell != null) {
            int cellType = cell.getCellType();
            switch (cellType) {

            case Cell.CELL_TYPE_STRING:
                value = cell.getStringCellValue().trim();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                DecimalFormat df = new DecimalFormat("#");
                value = df.format(cell.getNumericCellValue());
                break;
            }
        }

        return value;
    }

}

