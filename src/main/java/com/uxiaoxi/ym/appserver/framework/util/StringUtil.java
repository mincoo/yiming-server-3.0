package com.uxiaoxi.ym.appserver.framework.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字串工具类
 * 
 * @author renh
 */
public class StringUtil {

    private StringUtil() {
    }

    /**
     * 检测某字串是否存在某数组中
     * 
     * @param value
     * @param array
     * @return 存在返回真，不存在返回假
     */
    public static boolean arrayContainsStr(String value, String[] array) {
        if (array == null)
            return false;
        for (String v : array) {
            if (v.equals(value))
                return true;
        }
        return false;

    }

    public static boolean arrayContainsInt(int value, String[] array) {
        if (array == null)
            return false;
        for (String v : array) {
            if (Integer.valueOf(v).intValue() == value)
                return true;
        }
        return false;
    }

    /**
     * 将数组成str连接成字符串
     * 
     * @param str
     * @param array
     * @return
     */
    public static String concatArray(String str, Object[] array) {
        if (str == null || array == null) {
            return "";
        }
        String result = "";
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                result += array[i].toString();
            } else {
                result += array[i].toString() + str;
            }
        }
        return result;
    }

    public static String implodeValue(String str, Object[] array) {
        if (str == null || array == null) {
            return "";
        }
        String result = "";
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                result += "?";
            } else {
                result += "?" + str;
            }
        }
        return result;
    }

    /**
     * MD5加密方法
     * 
     * @param str
     *            String
     * @return String
     * @throws UnsupportedEncodingException 
     */
    public static String md5(String str)  {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return null;
        }
        StringBuffer result = new StringBuffer();
        try {
            byte[] resultByte;
            resultByte = messageDigest.digest(str.getBytes("UTF-8"));
            
            
            for (int i = 0; i < resultByte.length; ++i) {
                result.append(Integer.toHexString(( 0x000000FF & resultByte[i])|0xFFFFFF00 ).substring(6));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    /**
     * 验证Email地址是否有效
     * 
     * @param sEmail
     * @return
     */
    public static boolean validEmail(String sEmail) {
        String pattern = "^([a-z0-9A-Z]+[-|\\.|_]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        return sEmail.matches(pattern);
    }


    /**
     * 得到WEB-INF的绝对路径
     * 
     * @return
     */
    public static String getWebInfPath() {
        String filePath = Thread.currentThread().getContextClassLoader()
                .getResource("").toString();
        if (filePath.toLowerCase().indexOf("file:") > -1) {
            filePath = filePath.substring(6, filePath.length());
        }
        if (filePath.toLowerCase().indexOf("classes") > -1) {
            filePath = filePath.replaceAll("/classes", "");
        }
        if (System.getProperty("os.name").toLowerCase().indexOf("window") < 0) {
            filePath = "/" + filePath;
        }
        if (!filePath.endsWith("/"))
            filePath += "/";
        return filePath;
    }

    /**
     * 得到根目录绝对路径(不包含WEB-INF)
     * 
     * @return
     */
    public static String getRootPath() {
        // return "E:/javatool/apache-tomcat-6.0.18/webapps/user_test";
        String filePath = Thread.currentThread().getContextClassLoader()
                .getResource("").toString();
        if (filePath.toLowerCase().indexOf("file:") > -1) {
            filePath = filePath.substring(6, filePath.length());
        }
        if (filePath.toLowerCase().indexOf("classes") > -1) {
            filePath = filePath.replaceAll("/classes", "");
        }
        if (filePath.toLowerCase().indexOf("web-inf") > -1) {
            filePath = filePath.substring(0, filePath.length() - 9);
        }
        if (System.getProperty("os.name").toLowerCase().indexOf("window") < 0) {
            filePath = "/" + filePath;
        }

        if (filePath.endsWith("/"))
            filePath = filePath.substring(0, filePath.length() - 1);

        return filePath;
    }

    public static String getRootPath(String resource) {
        String filePath = Thread.currentThread().getContextClassLoader()
                .getResource(resource).toString();
        if (filePath.toLowerCase().indexOf("file:") > -1) {
            filePath = filePath.substring(6, filePath.length());
        }
        // if (filePath.toLowerCase().indexOf("classes") > -1) {
        // filePath = filePath.replaceAll("/classes", "");
        // }
        // if (filePath.toLowerCase().indexOf("web-inf") > -1) {
        // filePath = filePath.substring(0, filePath.length() - 9);
        // }
        if (System.getProperty("os.name").toLowerCase().indexOf("window") < 0) {
            filePath = "/" + filePath;
        }
        if (!filePath.endsWith("/"))
            filePath += "/";

        return filePath;
    }

    /**
     * 得到一个32位随机字符
     * 
     * @return
     */
    public static String getEntry() {
        Random random = new Random(100);
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(new String(
                "yyyyMMddHHmmssS"));
        return md5(formatter.format(now) + random.nextDouble());
    }

    /**
     * 将中文汉字转成UTF8编码
     * 
     * @param str
     * @return
     */
    public static String toUTF8(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        try {
            return new String(str.getBytes("ISO8859-1"), "UTF-8");
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public static String to(String str, String charset) {
        if (str == null || str.equals("")) {
            return "";
        }
        try {
            return new String(str.getBytes("ISO8859-1"), charset);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public static String getRandStr(int n) {
        Random random = new Random();
        String sRand = "";
        for (int i = 0; i < n; i++) {
            String rand = String.valueOf(random.nextInt(10));
            sRand += rand;
        }
        return sRand;
    }

    /**
     * 得到一个数字的大写(一到十之内)
     * 
     * @param num
     * @return
     */
    public static String getChineseNum(int num) {
        String[] chineseNum = new String[] { "一", "二", "三", "四", "五", "六", "七",
                "八", "九", "十" };
        return chineseNum[num];
    }

    public static String replaceEnter(String str) {
        if (str == null)
            return null;
        return str.replaceAll("\r", "").replaceAll("\n", "");
    }

    public static String replaceAll(String source, String target, String content) {
        StringBuffer buffer = new StringBuffer(source);
        int start = buffer.indexOf(target);
        if (start > 0) {
            source = buffer.replace(start, start + target.length(), content)
                    .toString();
        }
        return source;
    }

    /**
     * 去除HTML 元素
     * 
     * @param element
     * @return
     */
    public static String getTxtWithoutHTMLElement(String element) {
        if (null == element || "".equals(element.trim())) {
            return element;
        }

        Pattern pattern = Pattern.compile("<[^<|^>]*>");
        Matcher matcher = pattern.matcher(element);
        StringBuffer txt = new StringBuffer();
        while (matcher.find()) {
            String group = matcher.group();
            if (group.matches("<[\\s]*>")) {
                matcher.appendReplacement(txt, group);
            } else {
                matcher.appendReplacement(txt, "");
            }
        }
        matcher.appendTail(txt);
        String temp = txt.toString().replaceAll("\n", "");
        temp = temp.replaceAll(" ", "");
        return temp;
    }

    /**
     * clear trim to String
     * 
     * @return
     */
    public static String toTrim(String strtrim) {
        if (null != strtrim && !strtrim.equals("")) {
            return strtrim.trim();
        }
        return "";
    }

    /**
     * 转义字串的$
     * 
     * @param str
     * @return
     */
    public static String filterDollarStr(String str) {
        String sReturn = "";
        if (!toTrim(str).equals("")) {
            if (str.indexOf('$', 0) > -1) {
                while (str.length() > 0) {
                    if (str.indexOf('$', 0) > -1) {
                        sReturn += str.subSequence(0, str.indexOf('$', 0));
                        sReturn += "\\$";
                        str = str.substring(str.indexOf('$', 0) + 1,
                                str.length());
                    } else {
                        sReturn += str;
                        str = "";
                    }
                }

            } else {
                sReturn = str;
            }
        }
        return sReturn;
    }

    public static String compressHtml(String html) {
        if (html == null)
            return null;

        html = html.replaceAll("[\\t\\n\\f\\r]", "");
        return html;
    }

    public static String toCurrency(Double d) {
        if (d != null) {
            DecimalFormat df = new DecimalFormat("￥#,###.00");
            return df.format(d);
        }
        return "";
    }

    public static String toString(Integer i) {
        if (i != null) {
            return String.valueOf(i);
        }
        return "";
    }

    public static String toString(Double d) {
        if (null != d) {
            return String.valueOf(d);
        }
        return "";
    }

    public static String getRandom() {
        int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Random rand = new Random();
        for (int i = 10; i > 1; i--) {
            int index = rand.nextInt(i);
            int tmp = array[index];
            array[index] = array[i - 1];
            array[i - 1] = tmp;
        }
        int result = 0;
        for (int i = 0; i < 6; i++)
            result = result * 10 + array[i];

        return "" + result;
    }

    public static String inputStream2String(InputStream is) {
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        try {
            while ((line = in.readLine()) != null) {
                buffer.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    public static String decode(String keyword) {
        try {
            keyword = URLDecoder.decode(keyword, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return keyword;
    }

    /**
     * 进行解析
     * 
     * @param regex
     * @param rpstr
     * @param source
     * @return
     */
    public static String doFilter(String regex, String rpstr, String source) {
        Pattern p = Pattern.compile(regex, 2 | Pattern.DOTALL);
        Matcher m = p.matcher(source);
        return m.replaceAll(rpstr);
    }

    /**
     * 脚本过滤
     * 
     * @param source
     * @return
     */
    public static String formatScript(String source) {
        source = source.replaceAll("javascript", "&#106avascript");
        source = source.replaceAll("jscript:", "&#106script:");
        source = source.replaceAll("js:", "&#106s:");
        source = source.replaceAll("value", "&#118alue");
        source = source.replaceAll("about:", "about&#58");
        source = source.replaceAll("file:", "file&#58");
        source = source.replaceAll("document.cookie", "documents&#46cookie");
        source = source.replaceAll("vbscript:", "&#118bscript:");
        source = source.replaceAll("vbs:", "&#118bs:");
        source = doFilter("(on(mouse|exit|error|click|key))", "&#111n$2",
                source);
        return source;
    }

    /**
     * 格式化HTML代码
     * 
     * @param htmlContent
     * @return
     */
    public static String htmlDecode(String htmlContent) {
        htmlContent = formatScript(htmlContent);
        htmlContent = htmlContent.replaceAll(" ", "&nbsp;")
                .replaceAll("<", "&lt;").replaceAll(">", "&gt;")
                .replaceAll("\n\r", "<br>").replaceAll("\r\n", "<br>")
                .replaceAll("\r", "<br>");
        return htmlContent;
    }

    /**
     * 动态添加表前缀，对没有前缀的表增加前缀
     * 
     * @param table
     * @param prefix
     * @return
     */
    public static String addPrefix(String table, String prefix) {
        String result = "";
        if (table.length() > prefix.length()) {
            if (table.substring(0, prefix.length()).toLowerCase()
                    .equals(prefix.toLowerCase()))
                result = table;
            else
                result = prefix + table;
        } else
            result = prefix + table;

        return result;
    }

    public static String addSuffix(String table, String suffix) {
        String result = "";
        if (table.length() > suffix.length()) {
            int start = table.length() - suffix.length();
            int end = start + suffix.length();
            if (table.substring(start, end).toLowerCase()
                    .equals(suffix.toLowerCase()))
                result = table;
            else
                result = table + suffix;
        } else
            result = table + suffix;

        return result;
    }
}
