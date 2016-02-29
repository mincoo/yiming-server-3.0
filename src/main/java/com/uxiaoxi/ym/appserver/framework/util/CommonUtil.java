/**
 * CommonUtil.java
 */
package com.uxiaoxi.ym.appserver.framework.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.uxiaoxi.ym.easemob.comm.Constants;

/**
 * @author renh
 * 
 *         2013-4-10
 */
public class CommonUtil {

    private static final String PASSWORD_KEY = "uxiaoxi.com";

    public static final String SEPARATE = ",";

    public static final String INIT_PASSWORD = "123456";

    /**
     * 上传表格时接受的文件类型
     */
    public static final String XLS = ".xls";
    public static final String XLSX = ".xlsx";

    /**
     * 自定义密码算法
     * 
     */
    public static String password(String password) {

        return StringUtil.md5(password + PASSWORD_KEY);
    }
    
    /**
     *
     * 生成参数签名
     * 
     * @param list
     * @param sign
     * @return
     */
    public static String sign(List<String> list) {

        // 排序
        Collections.sort(list);
        // 连接
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            buffer.append(list.get(i));
            if(i < list.size() -1 ) {
                buffer.append("&");
            }
        }
        // 返回md5
        return StringUtil.md5(buffer.toString());
    }
    
     
    /**
     * 生成组标签
     * 
     * @param gid
     * @return
     */
    public static String buildGtag(Long gid) {
        return "g"+gid;
    }
    
    public static void main(String []args){
        // a79fb1e47faa0dfcec370e8f51f58367  123456
//        System.out.println(CommonUtil.password("123456"));
//        System.out.println(StringUtil.getRandStr(6));
        
        List<String> list = new ArrayList<String>();
        
//        list.add("phone=15010151186");
//        list.add("passwd=123456");
//        list.add("callback=123");
        
        list.add("imgUrl=http://imgsrc.baidu.com/forum/pic/item/33235343fbf2b211ab4bbab6ca8065380dd78eff.jpg");
        list.add("phone=18610640856");
        list.add("message=万");
//        list.add("status=0");
//        list.add("gid=4");
//        list.add("sid=4");
//        list.add("name=小红");
//        list.add("province=北京 ");
//        list.add("city=北京市");
//        list.add("district=海淀区");
//        list.add("school=人大二中");
//        list.add("longitude=23.23");
//        list.add("callback=123");
        
//        list.add("sn=2046");
        
        //mid=528&uid=2&sign=be9420050e101201d617475b0ef49379&token=25f435a809c19bd3d0b898c603d35591
        String sign = CommonUtil.sign(list);
        
        Collections.sort(list);
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < list.size(); i++) {
            buffer.append(list.get(i));
            buffer.append("&");
        }
        buffer.append("sign=");
        buffer.append(sign);
        
        System.out.println(buffer.toString());
        
        
        //System.out.println(StringUtil.md5(Constants.DEFAULT_PASSWORD+String.valueOf(14)));
        
        
        
    }

}
