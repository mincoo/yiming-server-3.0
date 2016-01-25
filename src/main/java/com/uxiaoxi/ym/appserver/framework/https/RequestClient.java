/**
 * RequestClient.java
 */
package com.uxiaoxi.ym.appserver.framework.https;


import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.uxiaoxi.ym.appserver.framework.json.JSONObject;





/**
 * @author renhao
 *
 * 2015-1-12
 */
public class RequestClient {

    /**
     * 通过get方式调用
     * 
     * @param url
     * @return
     */
    public String callApiByGet(String url) {

        StringBuffer sb = new StringBuffer();
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        
//        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);

        try {
            HttpResponse httpResponseG = httpClient.execute(httpGet);

            HttpEntity httpEntityG = httpResponseG.getEntity();

            InputStreamReader insr = new InputStreamReader(
                    httpEntityG.getContent());
            // 读取服务器的响应内容并显示
            int respInt = insr.read();

            while (respInt != -1) {
                sb.append((char) respInt);
                respInt = insr.read();
            }

            EntityUtils.consume(httpEntityG);
            

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpGet.releaseConnection();
        }

        return sb.toString();
    }

    /**
     * 通过post方式调用
     * 
     * @param url
     * @param json
     * @return
     */
    public String callApiByPost(String url, List<NameValuePair> params) {
        StringBuffer sb = new StringBuffer();
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);

        try {
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params,Consts.UTF_8);
            httpPost.setEntity(entity);

            HttpResponse httpResponseP = httpClient.execute(httpPost);
            HttpEntity httpEntityP = httpResponseP.getEntity();
            InputStreamReader insr = new InputStreamReader(
                    httpEntityP.getContent());
            // 读取服务器的响应内容并显示
            int respInt = insr.read();

            while (respInt != -1) {
                sb.append((char) respInt);
                respInt = insr.read();
            }

            EntityUtils.consume(httpEntityP);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpPost.releaseConnection();
        }
        return sb.toString();
    }

    /**
     * 通过post方式调用
     * 
     * @param url
     * @param json
     * @return
     */
    public String callApiByPost(String url, JSONObject json) {
        StringBuffer sb = new StringBuffer();
//        DefaultHttpClient httpClient = new DefaultHttpClient();
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);

        try {
            StringEntity entity = new StringEntity(json.toString(),Consts.UTF_8);
            entity.setContentEncoding(Consts.UTF_8.toString());
            entity.setContentType("application/json");
            httpPost.setEntity(entity);

            HttpResponse httpResponseP = httpClient.execute(httpPost);
            HttpEntity httpEntityP = httpResponseP.getEntity();
            InputStreamReader insr = new InputStreamReader(
                    httpEntityP.getContent());
            // 读取服务器的响应内容并显示
            int respInt = insr.read();

            while (respInt != -1) {
                sb.append((char) respInt);
                respInt = insr.read();
            }

            EntityUtils.consume(httpEntityP);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpPost.releaseConnection();
        }
        return sb.toString();
    }
    
    
    /**
     * 通过post方式调用
     * 
     * @param url
     * @param json
     * @return
     */
    public String callApiByPost(String url, String param) {
        StringBuffer sb = new StringBuffer();
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);

        try {
            StringEntity entity = new StringEntity(param,Consts.UTF_8);
            entity.setContentEncoding(Consts.UTF_8.toString());
            entity.setContentType("application/json");
            httpPost.setEntity(entity);

            HttpResponse httpResponseP = httpClient.execute(httpPost);
            HttpEntity httpEntityP = httpResponseP.getEntity();
            InputStreamReader insr = new InputStreamReader(
                    httpEntityP.getContent());
            // 读取服务器的响应内容并显示
            int respInt = insr.read();

            while (respInt != -1) {
                sb.append((char) respInt);
                respInt = insr.read();
            }

            EntityUtils.consume(httpEntityP);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpPost.releaseConnection();
        }
        return sb.toString();
    }
}
