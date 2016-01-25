/**
 * TestHttp.java
 */
package com.uxiaoxi.ym.appserver.http;

import com.uxiaoxi.ym.appserver.framework.https.RequestClient;
import com.uxiaoxi.ym.appserver.framework.json.JSONArray;
import com.uxiaoxi.ym.appserver.framework.json.JSONException;
import com.uxiaoxi.ym.appserver.framework.json.JSONObject;

/**
 * @author renhao
 *
 * 2015年4月1日
 */
public class TestHttp {

    public static void main(String[] args) throws JSONException{
        
        RequestClient client = new RequestClient();
        
        JSONObject reqjson = new JSONObject();
        reqjson.append("version", "1.1.0");
        
        
        JSONArray jarray = new JSONArray();
        JSONObject jzjson = new JSONObject();
        jzjson.append("cell_id ", "30696");
        jzjson.append("location_area_code", "4136");
        jzjson.append("mobile_country_code", "460");
        jzjson.append("mobile_network_code", "0");
        jarray.put(jzjson);
        
        reqjson.append("cell_towers", jarray);
        
        
        String rt = client.callApiByPost("https://api.weibo.com/2/location/mobile/get_location.json?source=3050912148", reqjson);
        
        System.out.println(rt);
    }
}
