/**
 * JavaEnumUtils.java
 */
package com.uxiaoxi.ym.appserver.framework.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author renh
 * 2013-4-8
 */
public class JavaEnumUtils {

    private static Map<String, Object> cache = new HashMap<String, Object>();

    public static void put(String key, Object value) {
        cache.put(key, value);
    }

    public static Object get(String key) {
        return cache.get(key);
    }
}
